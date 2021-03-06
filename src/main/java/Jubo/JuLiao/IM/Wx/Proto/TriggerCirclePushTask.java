// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TriggerCirclePushTask.proto

package Jubo.JuLiao.IM.Wx.Proto;

public final class TriggerCirclePushTask {
  private TriggerCirclePushTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TriggerCirclePushTaskMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 所属微信
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    java.lang.String getWeChatId();
    /**
     * <pre>
     * 所属微信
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    com.google.protobuf.ByteString
        getWeChatIdBytes();

    /**
     * <pre>
     * 起始时间 选其一 单位 秒
     * </pre>
     *
     * <code>int64 StartTime = 2;</code>
     */
    long getStartTime();

    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    java.util.List<java.lang.Long> getCircleIdsList();
    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    int getCircleIdsCount();
    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    long getCircleIds(int index);
  }
  /**
   * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage}
   */
  public  static final class TriggerCirclePushTaskMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage)
      TriggerCirclePushTaskMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use TriggerCirclePushTaskMessage.newBuilder() to construct.
    private TriggerCirclePushTaskMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TriggerCirclePushTaskMessage() {
      weChatId_ = "";
      startTime_ = 0L;
      circleIds_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private TriggerCirclePushTaskMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
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

              weChatId_ = s;
              break;
            }
            case 16: {

              startTime_ = input.readInt64();
              break;
            }
            case 24: {
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
                circleIds_ = new java.util.ArrayList<java.lang.Long>();
                mutable_bitField0_ |= 0x00000004;
              }
              circleIds_.add(input.readInt64());
              break;
            }
            case 26: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000004) == 0x00000004) && input.getBytesUntilLimit() > 0) {
                circleIds_ = new java.util.ArrayList<java.lang.Long>();
                mutable_bitField0_ |= 0x00000004;
              }
              while (input.getBytesUntilLimit() > 0) {
                circleIds_.add(input.readInt64());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
          circleIds_ = java.util.Collections.unmodifiableList(circleIds_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.Builder.class);
    }

    private int bitField0_;
    public static final int WECHATID_FIELD_NUMBER = 1;
    private volatile java.lang.Object weChatId_;
    /**
     * <pre>
     * 所属微信
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    public java.lang.String getWeChatId() {
      java.lang.Object ref = weChatId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        weChatId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 所属微信
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getWeChatIdBytes() {
      java.lang.Object ref = weChatId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        weChatId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int STARTTIME_FIELD_NUMBER = 2;
    private long startTime_;
    /**
     * <pre>
     * 起始时间 选其一 单位 秒
     * </pre>
     *
     * <code>int64 StartTime = 2;</code>
     */
    public long getStartTime() {
      return startTime_;
    }

    public static final int CIRCLEIDS_FIELD_NUMBER = 3;
    private java.util.List<java.lang.Long> circleIds_;
    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    public java.util.List<java.lang.Long>
        getCircleIdsList() {
      return circleIds_;
    }
    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    public int getCircleIdsCount() {
      return circleIds_.size();
    }
    /**
     * <pre>
     * 朋友圈ids 选其一
     * </pre>
     *
     * <code>repeated int64 CircleIds = 3;</code>
     */
    public long getCircleIds(int index) {
      return circleIds_.get(index);
    }
    private int circleIdsMemoizedSerializedSize = -1;

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
      getSerializedSize();
      if (!getWeChatIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, weChatId_);
      }
      if (startTime_ != 0L) {
        output.writeInt64(2, startTime_);
      }
      if (getCircleIdsList().size() > 0) {
        output.writeUInt32NoTag(26);
        output.writeUInt32NoTag(circleIdsMemoizedSerializedSize);
      }
      for (int i = 0; i < circleIds_.size(); i++) {
        output.writeInt64NoTag(circleIds_.get(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getWeChatIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, weChatId_);
      }
      if (startTime_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, startTime_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < circleIds_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt64SizeNoTag(circleIds_.get(i));
        }
        size += dataSize;
        if (!getCircleIdsList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        circleIdsMemoizedSerializedSize = dataSize;
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
      if (!(obj instanceof Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage)) {
        return super.equals(obj);
      }
      Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage other = (Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage) obj;

      boolean result = true;
      result = result && getWeChatId()
          .equals(other.getWeChatId());
      result = result && (getStartTime()
          == other.getStartTime());
      result = result && getCircleIdsList()
          .equals(other.getCircleIdsList());
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
      hash = (37 * hash) + WECHATID_FIELD_NUMBER;
      hash = (53 * hash) + getWeChatId().hashCode();
      hash = (37 * hash) + STARTTIME_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getStartTime());
      if (getCircleIdsCount() > 0) {
        hash = (37 * hash) + CIRCLEIDS_FIELD_NUMBER;
        hash = (53 * hash) + getCircleIdsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parseFrom(
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
    public static Builder newBuilder(Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage prototype) {
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
     * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage)
        Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.Builder.class);
      }

      // Construct using Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.newBuilder()
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
        weChatId_ = "";

        startTime_ = 0L;

        circleIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor;
      }

      public Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage getDefaultInstanceForType() {
        return Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.getDefaultInstance();
      }

      public Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage build() {
        Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage buildPartial() {
        Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage result = new Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.weChatId_ = weChatId_;
        result.startTime_ = startTime_;
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          circleIds_ = java.util.Collections.unmodifiableList(circleIds_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.circleIds_ = circleIds_;
        result.bitField0_ = to_bitField0_;
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
        if (other instanceof Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage) {
          return mergeFrom((Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage other) {
        if (other == Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage.getDefaultInstance()) return this;
        if (!other.getWeChatId().isEmpty()) {
          weChatId_ = other.weChatId_;
          onChanged();
        }
        if (other.getStartTime() != 0L) {
          setStartTime(other.getStartTime());
        }
        if (!other.circleIds_.isEmpty()) {
          if (circleIds_.isEmpty()) {
            circleIds_ = other.circleIds_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureCircleIdsIsMutable();
            circleIds_.addAll(other.circleIds_);
          }
          onChanged();
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
        Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object weChatId_ = "";
      /**
       * <pre>
       * 所属微信
       * </pre>
       *
       * <code>string WeChatId = 1;</code>
       */
      public java.lang.String getWeChatId() {
        java.lang.Object ref = weChatId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          weChatId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 所属微信
       * </pre>
       *
       * <code>string WeChatId = 1;</code>
       */
      public com.google.protobuf.ByteString
          getWeChatIdBytes() {
        java.lang.Object ref = weChatId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          weChatId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 所属微信
       * </pre>
       *
       * <code>string WeChatId = 1;</code>
       */
      public Builder setWeChatId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        weChatId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 所属微信
       * </pre>
       *
       * <code>string WeChatId = 1;</code>
       */
      public Builder clearWeChatId() {
        
        weChatId_ = getDefaultInstance().getWeChatId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 所属微信
       * </pre>
       *
       * <code>string WeChatId = 1;</code>
       */
      public Builder setWeChatIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        weChatId_ = value;
        onChanged();
        return this;
      }

      private long startTime_ ;
      /**
       * <pre>
       * 起始时间 选其一 单位 秒
       * </pre>
       *
       * <code>int64 StartTime = 2;</code>
       */
      public long getStartTime() {
        return startTime_;
      }
      /**
       * <pre>
       * 起始时间 选其一 单位 秒
       * </pre>
       *
       * <code>int64 StartTime = 2;</code>
       */
      public Builder setStartTime(long value) {
        
        startTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 起始时间 选其一 单位 秒
       * </pre>
       *
       * <code>int64 StartTime = 2;</code>
       */
      public Builder clearStartTime() {
        
        startTime_ = 0L;
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Long> circleIds_ = java.util.Collections.emptyList();
      private void ensureCircleIdsIsMutable() {
        if (!((bitField0_ & 0x00000004) == 0x00000004)) {
          circleIds_ = new java.util.ArrayList<java.lang.Long>(circleIds_);
          bitField0_ |= 0x00000004;
         }
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public java.util.List<java.lang.Long>
          getCircleIdsList() {
        return java.util.Collections.unmodifiableList(circleIds_);
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public int getCircleIdsCount() {
        return circleIds_.size();
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public long getCircleIds(int index) {
        return circleIds_.get(index);
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public Builder setCircleIds(
          int index, long value) {
        ensureCircleIdsIsMutable();
        circleIds_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public Builder addCircleIds(long value) {
        ensureCircleIdsIsMutable();
        circleIds_.add(value);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public Builder addAllCircleIds(
          java.lang.Iterable<? extends java.lang.Long> values) {
        ensureCircleIdsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, circleIds_);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 朋友圈ids 选其一
       * </pre>
       *
       * <code>repeated int64 CircleIds = 3;</code>
       */
      public Builder clearCircleIds() {
        circleIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
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


      // @@protoc_insertion_point(builder_scope:Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage)
    }

    // @@protoc_insertion_point(class_scope:Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTaskMessage)
    private static final Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage();
    }

    public static Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TriggerCirclePushTaskMessage>
        PARSER = new com.google.protobuf.AbstractParser<TriggerCirclePushTaskMessage>() {
      public TriggerCirclePushTaskMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TriggerCirclePushTaskMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TriggerCirclePushTaskMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TriggerCirclePushTaskMessage> getParserForType() {
      return PARSER;
    }

    public Jubo.JuLiao.IM.Wx.Proto.TriggerCirclePushTask.TriggerCirclePushTaskMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033TriggerCirclePushTask.proto\022\027Jubo.JuLi" +
      "ao.IM.Wx.Proto\"V\n\034TriggerCirclePushTaskM" +
      "essage\022\020\n\010WeChatId\030\001 \001(\t\022\021\n\tStartTime\030\002 " +
      "\001(\003\022\021\n\tCircleIds\030\003 \003(\003b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Jubo_JuLiao_IM_Wx_Proto_TriggerCirclePushTaskMessage_descriptor,
        new java.lang.String[] { "WeChatId", "StartTime", "CircleIds", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
