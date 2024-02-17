package tech.ydb.coordination.impl;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.annotations.VisibleForTesting;
import com.google.protobuf.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tech.ydb.coordination.CoordinationSession;
import tech.ydb.coordination.SemaphoreLease;
import tech.ydb.coordination.description.SemaphoreDescription;
import tech.ydb.coordination.description.SemaphoreWatcher;
import tech.ydb.coordination.settings.CoordinationSessionSettings;
import tech.ydb.coordination.settings.DescribeSemaphoreMode;
import tech.ydb.coordination.settings.WatchSemaphoreMode;
import tech.ydb.core.Issue;
import tech.ydb.core.Result;
import tech.ydb.core.Status;
import tech.ydb.core.StatusCode;
import tech.ydb.core.grpc.GrpcRequestSettings;


public class CoordinationSessionImpl implements CoordinationSession {
    private static final Logger logger = LoggerFactory.getLogger(CoordinationSession.class);

    private final CoordinationRpc rpc;
    private final String nodePath;
    private final Duration connectTimeout;
    private final ByteString protectionKey;
    private final Executor executor;

    private final Map<Consumer<State>, Consumer<State>> listeners = new ConcurrentHashMap<>();
    private final AtomicReference<State> state = new AtomicReference<>(State.UNSTARTED);
    private final AtomicReference<StreamState> stream = new AtomicReference<>();

    public CoordinationSessionImpl(CoordinationRpc rpc, String nodePath, CoordinationSessionSettings settings) {
        this(rpc, nodePath, settings.getConnectTimeout(),
                settings.getExecutor() != null ? settings.getExecutor() : ForkJoinPool.commonPool(),
                createRandomKey()
        );
    }

    @VisibleForTesting
    CoordinationSessionImpl(CoordinationRpc rpc, String nodePath, Duration timeout, Executor executor, ByteString key) {
        this.rpc = rpc;
        this.nodePath = nodePath;
        this.connectTimeout = timeout;
        this.protectionKey = key;
        this.executor = executor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Session{state=")
                .append(state.get());
        StreamState ss = stream.get();
        if (ss != null) {
            sb.append(", id=").append(ss.id).append(", stream=").append(ss.stream.hashCode());
        }

        return sb.append("}").toString();
    }

    @Override
    public CompletableFuture<Status> connect() {
        logger.trace("{} try to connect", this);
        if (!switchToConnecting()) {
            Status error = invalidStateStatus();
            logger.warn("{} cannot be connected by {}", this, error);
            return CompletableFuture.completedFuture(error);
        }

        final CompletableFuture<Status> connectFuture = new CompletableFuture<>();
        final Stream newStream = new Stream(rpc, GrpcRequestSettings.newBuilder()
                .withDeadline(connectTimeout)
                .build()
        );

        newStream.startStream().whenCompleteAsync((status, th) -> {
            if (th != null) {
                logger.warn("{} stream finished with exception", this, th);
                if (connectFuture.completeExceptionally(th)) {
                    switchToDisconnected();
                    return;
                }
            }
            if (status != null) {
                if (status.isSuccess()) {
                    logger.debug("{} stream finished with status {}", this, status);
                } else {
                    logger.warn("{} stream finished with status {}", this, status);
                }
                if (connectFuture.complete(status)) {
                    switchToDisconnected();
                    return;
                }
            }

            disconnect(th, status);
        }, executor);

        newStream.sendSessionStart(0, nodePath, connectTimeout, protectionKey).whenCompleteAsync((res, th) -> {
            if (th != null || res == null) {
                connectFuture.completeExceptionally(th);
                switchToDisconnected();
                return;
            }

            if (!res.isSuccess()) {
                connectFuture.complete(res.getStatus());
                switchToDisconnected();
                return;
            }

            if (!establishNewSession(res.getValue(), newStream)) {
                Issue issue = Issue.of("Cannot establish new session", Issue.Severity.ERROR);
                Status error = Status.of(StatusCode.CLIENT_INTERNAL_ERROR, null, issue);
                connectFuture.complete(error);
                return;
            }

            connectFuture.complete(Status.SUCCESS);

        }, executor);


        return connectFuture;
    }

    @Override
    public CompletableFuture<Status> stop() {
        if (switchToClose()) {
            logger.debug("{} closed", this);
        }

        StreamState s = stream.get();
        if (s == null) { // session is unstarted
            return CompletableFuture.completedFuture(Status.SUCCESS);
        }

        return s.stream.sendSessionStop();
    }

    @Override
    public Long getId() {
        StreamState current = stream.get();
        if (current == null) {
            return null;
        }
        return current.id;
    }

    @Override
    public State getState() {
        return state.get();
    }

    @Override
    public void addStateListener(Consumer<State> listener) {
        if (listener != null) {
            listeners.put(listener, listener);
        }
    }

    @Override
    public void removeStateListener(Consumer<State> listener) {
        listeners.remove(listener);
    }

    private void disconnect(Throwable th, Status status) {
        if (switchToLost()) {
            StreamState s = stream.get();
            if (s != null) {
                // disconnect grpc stream
                s.stream.cancelStream();
            }
        }
    }

    private void reconnect() {

    }

    private boolean establishNewSession(long sessionID, Stream newStream) {
        StreamState previous = stream.getAndSet(new StreamState(sessionID, newStream));
        if (!switchToConnected()) {
            stream.getAndSet(previous).stream.cancelStream();
            return false;
        }
        if (previous != null) {
            previous.stream.cancelStream();
        }
        return true;
    }


    private boolean updateState(State previous, State newState) {
        if (!state.compareAndSet(previous, newState)) {
            return false;
        }

        for (Consumer<CoordinationSession.State> listener: listeners.values()) {
            listener.accept(newState);
        }
        return true;
    }

    private boolean updateState(State newState) {
        State old = state.getAndSet(newState);
        if (old == newState) {
            return false;
        }

        for (Consumer<CoordinationSession.State> listener: listeners.values()) {
            listener.accept(newState);
        }

        return true;
    }

    private boolean switchToClose() {
        return updateState(State.CLOSED);
    }

    private boolean switchToLost() {
        return updateState(State.LOST);
    }

    private boolean switchToConnecting() {
        return updateState(State.UNSTARTED, State.CONNECTING) || updateState(State.LOST, State.RECONNECTING);
    }

    private boolean switchToReconnecting() {
        return updateState(State.CONNECTED, State.RECONNECTING) || updateState(State.RECONNECTED, State.RECONNECTING);
    }

    private boolean switchToConnected() {
        return updateState(State.CONNECTING, State.CONNECTED) || updateState(State.RECONNECTING, State.RECONNECTED);
    }

    private boolean switchToDisconnected() {
        return updateState(State.CONNECTING, State.UNSTARTED) || updateState(State.RECONNECTING, State.LOST);
    }

    private Status invalidStateStatus() {
        Issue issue = Issue.of("Session has invalid state " + getState(), Issue.Severity.ERROR);
        return Status.of(StatusCode.CLIENT_INTERNAL_ERROR, null, issue);
    }

    @Override
    public CompletableFuture<Status> createSemaphore(String name, long limit, byte[] data) {
        StreamState ss = stream.get();
        if (ss == null) {
            return CompletableFuture.completedFuture(invalidStateStatus());
        }

        StreamMsg<Status> msg = StreamMsg.createSemaphoreMsg(name, limit, data);
        ss.sendMessagg(msg);
        return msg.getResult().thenApplyAsync(Function.identity(), executor);
    }

    @Override
    public CompletableFuture<Status> updateSemaphore(String name, byte[] data) {
        StreamState ss = stream.get();
        if (ss == null) {
            return CompletableFuture.completedFuture(invalidStateStatus());
        }

        StreamMsg<Status> msg = StreamMsg.updateSemaphoreMsg(name, data);
        ss.sendMessagg(msg);
        return msg.getResult().thenApplyAsync(Function.identity(), executor);
    }

    @Override
    public CompletableFuture<Status> deleteSemaphore(String name, boolean force) {
        StreamState ss = stream.get();
        if (ss == null) {
            return CompletableFuture.completedFuture(invalidStateStatus());
        }

        StreamMsg<Status> msg = StreamMsg.deleteSemaphoreMsg(name, force);
        ss.sendMessagg(msg);
        return msg.getResult().thenApplyAsync(Function.identity(), executor);
    }

    CompletableFuture<Status> releaseSemaphore(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    private static ByteString createRandomKey() {
        byte[] protectionKey = new byte[16];
        ThreadLocalRandom.current().nextBytes(protectionKey);
        return ByteString.copyFrom(protectionKey);
    }


    private class StreamState {
        private final long id;
        private final Stream stream;
        private final AtomicLong reqIdx = new AtomicLong(0);

        StreamState(long id, Stream stream) {
            this.id = id;
            this.stream = stream;
        }

        void sendMessagg(StreamMsg<?> msg) {
            this.stream.sendMsg(reqIdx.incrementAndGet(), msg);
        }
    }


//
//    @Override
//    public CompletableFuture<Result<SemaphoreLease>> acquireSemaphore(String name, long count, byte[] data,
//            Duration timeout) {
//        byte[] sepamhoreData = data != null ? data : BYTE_ARRAY_STUB;
//        final int reqId = lastId.getAndIncrement();
//        logger.trace("Send acquireSemaphore {} with count {}", name, count);
//        return stream.sendAcquireSemaphore(name, count, timeout, false, sepamhoreData, reqId)
//                .thenApply(r -> r.map(v -> new SemaphoreLeaseImpl(this, name)));
//    }
//
//    @Override
//    public CompletableFuture<Result<SemaphoreLease>> acquireEphemeralSemaphore(String name, boolean exclusive,
//            byte[] data, Duration timeout) {
//        byte[] sepamhoreData = data != null ? data : BYTE_ARRAY_STUB;
//        final int reqId = lastId.getAndIncrement();
//        logger.trace("Send acquireEphemeralSemaphore {}", name);
//        long limit = exclusive ? -1L : 1L;
//        return stream.sendAcquireSemaphore(name, limit, timeout, true, sepamhoreData, reqId)
//                .thenApply(r -> r.map(v -> new SemaphoreLeaseImpl(this, name)));
//    }
//
//    CompletableFuture<Boolean> releaseSemaphore(String name) {
//        final int semaphoreReleaseId = lastId.getAndIncrement();
//        logger.trace("Send releaseSemaphore {}", name);
//        return stream.sendReleaseSemaphore(name, semaphoreReleaseId).thenApply(Result::getValue);
//    }
//
//    @Override
//    public CompletableFuture<Result<SemaphoreDescription>> describeSemaphore(String name,
//    DescribeSemaphoreMode mode) {
//        return stream.sendDescribeSemaphore(name, mode.includeOwners(), mode.includeWaiters());
//    }
//
//    @Override
//    public CompletableFuture<Result<SemaphoreWatcher>> describeAndWatchSemaphore(String name,
//            DescribeSemaphoreMode describeMode, WatchSemaphoreMode watchMode) {
//        final CompletableFuture<SemaphoreChangedEvent> changeFuture = new CompletableFuture<>();
//        return stream.sendDescribeSemaphore(name,
//                describeMode.includeOwners(), describeMode.includeWaiters(),
//                watchMode.watchData(), watchMode.watchOwners(),
//                changeFuture::complete
//        ).thenApply(r -> r.map(desc -> new SemaphoreWatcher(desc, changeFuture)));
//    }
//

    @Override
    public CompletableFuture<Result<SemaphoreLease>> acquireSemaphore(String name, long count, byte[] data,
            Duration timeout) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CompletableFuture<Result<SemaphoreLease>> acquireEphemeralSemaphore(String name, boolean exclusive,
            byte[] data, Duration timeout) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CompletableFuture<Result<SemaphoreDescription>> describeSemaphore(String name, DescribeSemaphoreMode mode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CompletableFuture<Result<SemaphoreWatcher>> describeAndWatchSemaphore(String name,
            DescribeSemaphoreMode describeMode, WatchSemaphoreMode watchMode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
