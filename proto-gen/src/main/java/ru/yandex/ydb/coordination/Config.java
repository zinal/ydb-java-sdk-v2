// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: kikimr/public/api/protos/ydb_coordination.proto

package ru.yandex.ydb.coordination;

/**
 * <pre>
 **
 * Configuration settings for a coordination node
 * </pre>
 *
 * Protobuf type {@code Ydb.Coordination.Config}
 */
public  final class Config extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Ydb.Coordination.Config)
    ConfigOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Config.newBuilder() to construct.
  private Config(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Config() {
    path_ = "";
    selfCheckPeriodMillis_ = 0;
    sessionGracePeriodMillis_ = 0;
    readConsistencyMode_ = 0;
    attachConsistencyMode_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Config(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            path_ = s;
            break;
          }
          case 16: {

            selfCheckPeriodMillis_ = input.readUInt32();
            break;
          }
          case 24: {

            sessionGracePeriodMillis_ = input.readUInt32();
            break;
          }
          case 32: {
            int rawValue = input.readEnum();

            readConsistencyMode_ = rawValue;
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            attachConsistencyMode_ = rawValue;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.yandex.ydb.coordination.CoordinationProtos.internal_static_Ydb_Coordination_Config_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.yandex.ydb.coordination.CoordinationProtos.internal_static_Ydb_Coordination_Config_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.yandex.ydb.coordination.Config.class, ru.yandex.ydb.coordination.Config.Builder.class);
  }

  public static final int PATH_FIELD_NUMBER = 1;
  private volatile java.lang.Object path_;
  /**
   * <pre>
   * Initialized on creation, cannot be set
   * </pre>
   *
   * <code>string path = 1;</code>
   */
  public java.lang.String getPath() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      path_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Initialized on creation, cannot be set
   * </pre>
   *
   * <code>string path = 1;</code>
   */
  public com.google.protobuf.ByteString
      getPathBytes() {
    java.lang.Object ref = path_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      path_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SELF_CHECK_PERIOD_MILLIS_FIELD_NUMBER = 2;
  private int selfCheckPeriodMillis_;
  /**
   * <pre>
   * Period in milliseconds for self-checks (default 1 second)
   * </pre>
   *
   * <code>uint32 self_check_period_millis = 2;</code>
   */
  public int getSelfCheckPeriodMillis() {
    return selfCheckPeriodMillis_;
  }

  public static final int SESSION_GRACE_PERIOD_MILLIS_FIELD_NUMBER = 3;
  private int sessionGracePeriodMillis_;
  /**
   * <pre>
   * Grace period for sessions on master change (default 10 seconds)
   * </pre>
   *
   * <code>uint32 session_grace_period_millis = 3;</code>
   */
  public int getSessionGracePeriodMillis() {
    return sessionGracePeriodMillis_;
  }

  public static final int READ_CONSISTENCY_MODE_FIELD_NUMBER = 4;
  private int readConsistencyMode_;
  /**
   * <pre>
   * Concistency mode for read operations
   * </pre>
   *
   * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
   */
  public int getReadConsistencyModeValue() {
    return readConsistencyMode_;
  }
  /**
   * <pre>
   * Concistency mode for read operations
   * </pre>
   *
   * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
   */
  public ru.yandex.ydb.coordination.ConsistencyMode getReadConsistencyMode() {
    ru.yandex.ydb.coordination.ConsistencyMode result = ru.yandex.ydb.coordination.ConsistencyMode.valueOf(readConsistencyMode_);
    return result == null ? ru.yandex.ydb.coordination.ConsistencyMode.UNRECOGNIZED : result;
  }

  public static final int ATTACH_CONSISTENCY_MODE_FIELD_NUMBER = 5;
  private int attachConsistencyMode_;
  /**
   * <pre>
   * Consistency mode for attach operations
   * </pre>
   *
   * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
   */
  public int getAttachConsistencyModeValue() {
    return attachConsistencyMode_;
  }
  /**
   * <pre>
   * Consistency mode for attach operations
   * </pre>
   *
   * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
   */
  public ru.yandex.ydb.coordination.ConsistencyMode getAttachConsistencyMode() {
    ru.yandex.ydb.coordination.ConsistencyMode result = ru.yandex.ydb.coordination.ConsistencyMode.valueOf(attachConsistencyMode_);
    return result == null ? ru.yandex.ydb.coordination.ConsistencyMode.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getPathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, path_);
    }
    if (selfCheckPeriodMillis_ != 0) {
      output.writeUInt32(2, selfCheckPeriodMillis_);
    }
    if (sessionGracePeriodMillis_ != 0) {
      output.writeUInt32(3, sessionGracePeriodMillis_);
    }
    if (readConsistencyMode_ != ru.yandex.ydb.coordination.ConsistencyMode.CONSISTENCY_MODE_UNSET.getNumber()) {
      output.writeEnum(4, readConsistencyMode_);
    }
    if (attachConsistencyMode_ != ru.yandex.ydb.coordination.ConsistencyMode.CONSISTENCY_MODE_UNSET.getNumber()) {
      output.writeEnum(5, attachConsistencyMode_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getPathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, path_);
    }
    if (selfCheckPeriodMillis_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(2, selfCheckPeriodMillis_);
    }
    if (sessionGracePeriodMillis_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(3, sessionGracePeriodMillis_);
    }
    if (readConsistencyMode_ != ru.yandex.ydb.coordination.ConsistencyMode.CONSISTENCY_MODE_UNSET.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(4, readConsistencyMode_);
    }
    if (attachConsistencyMode_ != ru.yandex.ydb.coordination.ConsistencyMode.CONSISTENCY_MODE_UNSET.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, attachConsistencyMode_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.yandex.ydb.coordination.Config)) {
      return super.equals(obj);
    }
    ru.yandex.ydb.coordination.Config other = (ru.yandex.ydb.coordination.Config) obj;

    boolean result = true;
    result = result && getPath()
        .equals(other.getPath());
    result = result && (getSelfCheckPeriodMillis()
        == other.getSelfCheckPeriodMillis());
    result = result && (getSessionGracePeriodMillis()
        == other.getSessionGracePeriodMillis());
    result = result && readConsistencyMode_ == other.readConsistencyMode_;
    result = result && attachConsistencyMode_ == other.attachConsistencyMode_;
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PATH_FIELD_NUMBER;
    hash = (53 * hash) + getPath().hashCode();
    hash = (37 * hash) + SELF_CHECK_PERIOD_MILLIS_FIELD_NUMBER;
    hash = (53 * hash) + getSelfCheckPeriodMillis();
    hash = (37 * hash) + SESSION_GRACE_PERIOD_MILLIS_FIELD_NUMBER;
    hash = (53 * hash) + getSessionGracePeriodMillis();
    hash = (37 * hash) + READ_CONSISTENCY_MODE_FIELD_NUMBER;
    hash = (53 * hash) + readConsistencyMode_;
    hash = (37 * hash) + ATTACH_CONSISTENCY_MODE_FIELD_NUMBER;
    hash = (53 * hash) + attachConsistencyMode_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.yandex.ydb.coordination.Config parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.yandex.ydb.coordination.Config parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.yandex.ydb.coordination.Config parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.yandex.ydb.coordination.Config parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ru.yandex.ydb.coordination.Config prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   **
   * Configuration settings for a coordination node
   * </pre>
   *
   * Protobuf type {@code Ydb.Coordination.Config}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Ydb.Coordination.Config)
      ru.yandex.ydb.coordination.ConfigOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.yandex.ydb.coordination.CoordinationProtos.internal_static_Ydb_Coordination_Config_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.yandex.ydb.coordination.CoordinationProtos.internal_static_Ydb_Coordination_Config_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.yandex.ydb.coordination.Config.class, ru.yandex.ydb.coordination.Config.Builder.class);
    }

    // Construct using ru.yandex.ydb.coordination.Config.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      path_ = "";

      selfCheckPeriodMillis_ = 0;

      sessionGracePeriodMillis_ = 0;

      readConsistencyMode_ = 0;

      attachConsistencyMode_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.yandex.ydb.coordination.CoordinationProtos.internal_static_Ydb_Coordination_Config_descriptor;
    }

    public ru.yandex.ydb.coordination.Config getDefaultInstanceForType() {
      return ru.yandex.ydb.coordination.Config.getDefaultInstance();
    }

    public ru.yandex.ydb.coordination.Config build() {
      ru.yandex.ydb.coordination.Config result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ru.yandex.ydb.coordination.Config buildPartial() {
      ru.yandex.ydb.coordination.Config result = new ru.yandex.ydb.coordination.Config(this);
      result.path_ = path_;
      result.selfCheckPeriodMillis_ = selfCheckPeriodMillis_;
      result.sessionGracePeriodMillis_ = sessionGracePeriodMillis_;
      result.readConsistencyMode_ = readConsistencyMode_;
      result.attachConsistencyMode_ = attachConsistencyMode_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ru.yandex.ydb.coordination.Config) {
        return mergeFrom((ru.yandex.ydb.coordination.Config)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.yandex.ydb.coordination.Config other) {
      if (other == ru.yandex.ydb.coordination.Config.getDefaultInstance()) return this;
      if (!other.getPath().isEmpty()) {
        path_ = other.path_;
        onChanged();
      }
      if (other.getSelfCheckPeriodMillis() != 0) {
        setSelfCheckPeriodMillis(other.getSelfCheckPeriodMillis());
      }
      if (other.getSessionGracePeriodMillis() != 0) {
        setSessionGracePeriodMillis(other.getSessionGracePeriodMillis());
      }
      if (other.readConsistencyMode_ != 0) {
        setReadConsistencyModeValue(other.getReadConsistencyModeValue());
      }
      if (other.attachConsistencyMode_ != 0) {
        setAttachConsistencyModeValue(other.getAttachConsistencyModeValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ru.yandex.ydb.coordination.Config parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.yandex.ydb.coordination.Config) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object path_ = "";
    /**
     * <pre>
     * Initialized on creation, cannot be set
     * </pre>
     *
     * <code>string path = 1;</code>
     */
    public java.lang.String getPath() {
      java.lang.Object ref = path_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        path_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Initialized on creation, cannot be set
     * </pre>
     *
     * <code>string path = 1;</code>
     */
    public com.google.protobuf.ByteString
        getPathBytes() {
      java.lang.Object ref = path_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        path_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Initialized on creation, cannot be set
     * </pre>
     *
     * <code>string path = 1;</code>
     */
    public Builder setPath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      path_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Initialized on creation, cannot be set
     * </pre>
     *
     * <code>string path = 1;</code>
     */
    public Builder clearPath() {
      
      path_ = getDefaultInstance().getPath();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Initialized on creation, cannot be set
     * </pre>
     *
     * <code>string path = 1;</code>
     */
    public Builder setPathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      path_ = value;
      onChanged();
      return this;
    }

    private int selfCheckPeriodMillis_ ;
    /**
     * <pre>
     * Period in milliseconds for self-checks (default 1 second)
     * </pre>
     *
     * <code>uint32 self_check_period_millis = 2;</code>
     */
    public int getSelfCheckPeriodMillis() {
      return selfCheckPeriodMillis_;
    }
    /**
     * <pre>
     * Period in milliseconds for self-checks (default 1 second)
     * </pre>
     *
     * <code>uint32 self_check_period_millis = 2;</code>
     */
    public Builder setSelfCheckPeriodMillis(int value) {
      
      selfCheckPeriodMillis_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Period in milliseconds for self-checks (default 1 second)
     * </pre>
     *
     * <code>uint32 self_check_period_millis = 2;</code>
     */
    public Builder clearSelfCheckPeriodMillis() {
      
      selfCheckPeriodMillis_ = 0;
      onChanged();
      return this;
    }

    private int sessionGracePeriodMillis_ ;
    /**
     * <pre>
     * Grace period for sessions on master change (default 10 seconds)
     * </pre>
     *
     * <code>uint32 session_grace_period_millis = 3;</code>
     */
    public int getSessionGracePeriodMillis() {
      return sessionGracePeriodMillis_;
    }
    /**
     * <pre>
     * Grace period for sessions on master change (default 10 seconds)
     * </pre>
     *
     * <code>uint32 session_grace_period_millis = 3;</code>
     */
    public Builder setSessionGracePeriodMillis(int value) {
      
      sessionGracePeriodMillis_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Grace period for sessions on master change (default 10 seconds)
     * </pre>
     *
     * <code>uint32 session_grace_period_millis = 3;</code>
     */
    public Builder clearSessionGracePeriodMillis() {
      
      sessionGracePeriodMillis_ = 0;
      onChanged();
      return this;
    }

    private int readConsistencyMode_ = 0;
    /**
     * <pre>
     * Concistency mode for read operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
     */
    public int getReadConsistencyModeValue() {
      return readConsistencyMode_;
    }
    /**
     * <pre>
     * Concistency mode for read operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
     */
    public Builder setReadConsistencyModeValue(int value) {
      readConsistencyMode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Concistency mode for read operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
     */
    public ru.yandex.ydb.coordination.ConsistencyMode getReadConsistencyMode() {
      ru.yandex.ydb.coordination.ConsistencyMode result = ru.yandex.ydb.coordination.ConsistencyMode.valueOf(readConsistencyMode_);
      return result == null ? ru.yandex.ydb.coordination.ConsistencyMode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Concistency mode for read operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
     */
    public Builder setReadConsistencyMode(ru.yandex.ydb.coordination.ConsistencyMode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      readConsistencyMode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Concistency mode for read operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode read_consistency_mode = 4;</code>
     */
    public Builder clearReadConsistencyMode() {
      
      readConsistencyMode_ = 0;
      onChanged();
      return this;
    }

    private int attachConsistencyMode_ = 0;
    /**
     * <pre>
     * Consistency mode for attach operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
     */
    public int getAttachConsistencyModeValue() {
      return attachConsistencyMode_;
    }
    /**
     * <pre>
     * Consistency mode for attach operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
     */
    public Builder setAttachConsistencyModeValue(int value) {
      attachConsistencyMode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Consistency mode for attach operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
     */
    public ru.yandex.ydb.coordination.ConsistencyMode getAttachConsistencyMode() {
      ru.yandex.ydb.coordination.ConsistencyMode result = ru.yandex.ydb.coordination.ConsistencyMode.valueOf(attachConsistencyMode_);
      return result == null ? ru.yandex.ydb.coordination.ConsistencyMode.UNRECOGNIZED : result;
    }
    /**
     * <pre>
     * Consistency mode for attach operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
     */
    public Builder setAttachConsistencyMode(ru.yandex.ydb.coordination.ConsistencyMode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      attachConsistencyMode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Consistency mode for attach operations
     * </pre>
     *
     * <code>.Ydb.Coordination.ConsistencyMode attach_consistency_mode = 5;</code>
     */
    public Builder clearAttachConsistencyMode() {
      
      attachConsistencyMode_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Ydb.Coordination.Config)
  }

  // @@protoc_insertion_point(class_scope:Ydb.Coordination.Config)
  private static final ru.yandex.ydb.coordination.Config DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.yandex.ydb.coordination.Config();
  }

  public static ru.yandex.ydb.coordination.Config getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Config>
      PARSER = new com.google.protobuf.AbstractParser<Config>() {
    public Config parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Config(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Config> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Config> getParserForType() {
    return PARSER;
  }

  public ru.yandex.ydb.coordination.Config getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
