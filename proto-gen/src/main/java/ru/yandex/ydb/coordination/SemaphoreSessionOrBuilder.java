// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/protos/ydb_coordination.proto

package ru.yandex.ydb.coordination;

public interface SemaphoreSessionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Ydb.Coordination.SemaphoreSession)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A monotonically increasing id which determines locking order
   * </pre>
   *
   * <code>uint64 order_id = 5;</code>
   */
  long getOrderId();

  /**
   * <pre>
   * An id of the session which tried to acquire the semaphore
   * </pre>
   *
   * <code>uint64 session_id = 1;</code>
   */
  long getSessionId();

  /**
   * <pre>
   * A timeout in milliseconds for operation in waiters queue
   * </pre>
   *
   * <code>uint64 timeout_millis = 2;</code>
   */
  long getTimeoutMillis();

  /**
   * <pre>
   * Number of tokens for an acquire operation
   * </pre>
   *
   * <code>uint64 count = 3;</code>
   */
  long getCount();

  /**
   * <pre>
   * User-defined data attached to the acquire operation
   * </pre>
   *
   * <code>bytes data = 4;</code>
   */
  com.google.protobuf.ByteString getData();
}