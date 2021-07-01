// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AddFriendNameCardTask.proto

package Jubo.JuLiao.IM.Wx.Proto;

public final class AddFriendNameCardTask {
  private AddFriendNameCardTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AddFriendNameCardTaskMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 商家个人微信内部全局唯一识别码
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    java.lang.String getWeChatId();
    /**
     * <pre>
     * 商家个人微信内部全局唯一识别码
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    com.google.protobuf.ByteString
        getWeChatIdBytes();

    /**
     * <pre>
     * 名片消息id
     * </pre>
     *
     * <code>int64 MsgSvrId = 3;</code>
     */
    long getMsgSvrId();

    /**
     * <pre>
     * 招呼语
     * </pre>
     *
     * <code>string Message = 4;</code>
     */
    java.lang.String getMessage();
    /**
     * <pre>
     * 招呼语
     * </pre>
     *
     * <code>string Message = 4;</code>
     */
    com.google.protobuf.ByteString
        getMessageBytes();

    /**
     * <pre>
     * 备注信息
     * </pre>
     *
     * <code>string Remark = 5;</code>
     */
    java.lang.String getRemark();
    /**
     * <pre>
     * 备注信息
     * </pre>
     *
     * <code>string Remark = 5;</code>
     */
    com.google.protobuf.ByteString
        getRemarkBytes();

    /**
     * <pre>
     *任务Id
     * </pre>
     *
     * <code>int64 TaskId = 6;</code>
     */
    long getTaskId();
  }
  /**
   * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage}
   */
  public  static final class AddFriendNameCardTaskMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage)
      AddFriendNameCardTaskMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AddFriendNameCardTaskMessage.newBuilder() to construct.
    private AddFriendNameCardTaskMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AddFriendNameCardTaskMessage() {
      weChatId_ = "";
      msgSvrId_ = 0L;
      message_ = "";
      remark_ = "";
      taskId_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AddFriendNameCardTaskMessage(
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
            case 24: {

              msgSvrId_ = input.readInt64();
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              message_ = s;
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              remark_ = s;
              break;
            }
            case 48: {

              taskId_ = input.readInt64();
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
      return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.Builder.class);
    }

    public static final int WECHATID_FIELD_NUMBER = 1;
    private volatile java.lang.Object weChatId_;
    /**
     * <pre>
     * 商家个人微信内部全局唯一识别码
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
     * 商家个人微信内部全局唯一识别码
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

    public static final int MSGSVRID_FIELD_NUMBER = 3;
    private long msgSvrId_;
    /**
     * <pre>
     * 名片消息id
     * </pre>
     *
     * <code>int64 MsgSvrId = 3;</code>
     */
    public long getMsgSvrId() {
      return msgSvrId_;
    }

    public static final int MESSAGE_FIELD_NUMBER = 4;
    private volatile java.lang.Object message_;
    /**
     * <pre>
     * 招呼语
     * </pre>
     *
     * <code>string Message = 4;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 招呼语
     * </pre>
     *
     * <code>string Message = 4;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REMARK_FIELD_NUMBER = 5;
    private volatile java.lang.Object remark_;
    /**
     * <pre>
     * 备注信息
     * </pre>
     *
     * <code>string Remark = 5;</code>
     */
    public java.lang.String getRemark() {
      java.lang.Object ref = remark_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        remark_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 备注信息
     * </pre>
     *
     * <code>string Remark = 5;</code>
     */
    public com.google.protobuf.ByteString
        getRemarkBytes() {
      java.lang.Object ref = remark_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        remark_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKID_FIELD_NUMBER = 6;
    private long taskId_;
    /**
     * <pre>
     *任务Id
     * </pre>
     *
     * <code>int64 TaskId = 6;</code>
     */
    public long getTaskId() {
      return taskId_;
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
      if (!getWeChatIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, weChatId_);
      }
      if (msgSvrId_ != 0L) {
        output.writeInt64(3, msgSvrId_);
      }
      if (!getMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, message_);
      }
      if (!getRemarkBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, remark_);
      }
      if (taskId_ != 0L) {
        output.writeInt64(6, taskId_);
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
      if (msgSvrId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, msgSvrId_);
      }
      if (!getMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, message_);
      }
      if (!getRemarkBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, remark_);
      }
      if (taskId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(6, taskId_);
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
      if (!(obj instanceof Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage)) {
        return super.equals(obj);
      }
      Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage other = (Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage) obj;

      boolean result = true;
      result = result && getWeChatId()
          .equals(other.getWeChatId());
      result = result && (getMsgSvrId()
          == other.getMsgSvrId());
      result = result && getMessage()
          .equals(other.getMessage());
      result = result && getRemark()
          .equals(other.getRemark());
      result = result && (getTaskId()
          == other.getTaskId());
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
      hash = (37 * hash) + MSGSVRID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMsgSvrId());
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
      hash = (37 * hash) + REMARK_FIELD_NUMBER;
      hash = (53 * hash) + getRemark().hashCode();
      hash = (37 * hash) + TASKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTaskId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parseFrom(
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
    public static Builder newBuilder(Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage prototype) {
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
     * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage)
        Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.Builder.class);
      }

      // Construct using Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.newBuilder()
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

        msgSvrId_ = 0L;

        message_ = "";

        remark_ = "";

        taskId_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor;
      }

      public Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage getDefaultInstanceForType() {
        return Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.getDefaultInstance();
      }

      public Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage build() {
        Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage buildPartial() {
        Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage result = new Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage(this);
        result.weChatId_ = weChatId_;
        result.msgSvrId_ = msgSvrId_;
        result.message_ = message_;
        result.remark_ = remark_;
        result.taskId_ = taskId_;
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
        if (other instanceof Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage) {
          return mergeFrom((Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage other) {
        if (other == Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage.getDefaultInstance()) return this;
        if (!other.getWeChatId().isEmpty()) {
          weChatId_ = other.weChatId_;
          onChanged();
        }
        if (other.getMsgSvrId() != 0L) {
          setMsgSvrId(other.getMsgSvrId());
        }
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
          onChanged();
        }
        if (!other.getRemark().isEmpty()) {
          remark_ = other.remark_;
          onChanged();
        }
        if (other.getTaskId() != 0L) {
          setTaskId(other.getTaskId());
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
        Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object weChatId_ = "";
      /**
       * <pre>
       * 商家个人微信内部全局唯一识别码
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
       * 商家个人微信内部全局唯一识别码
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
       * 商家个人微信内部全局唯一识别码
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
       * 商家个人微信内部全局唯一识别码
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
       * 商家个人微信内部全局唯一识别码
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

      private long msgSvrId_ ;
      /**
       * <pre>
       * 名片消息id
       * </pre>
       *
       * <code>int64 MsgSvrId = 3;</code>
       */
      public long getMsgSvrId() {
        return msgSvrId_;
      }
      /**
       * <pre>
       * 名片消息id
       * </pre>
       *
       * <code>int64 MsgSvrId = 3;</code>
       */
      public Builder setMsgSvrId(long value) {
        
        msgSvrId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 名片消息id
       * </pre>
       *
       * <code>int64 MsgSvrId = 3;</code>
       */
      public Builder clearMsgSvrId() {
        
        msgSvrId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object message_ = "";
      /**
       * <pre>
       * 招呼语
       * </pre>
       *
       * <code>string Message = 4;</code>
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 招呼语
       * </pre>
       *
       * <code>string Message = 4;</code>
       */
      public com.google.protobuf.ByteString
          getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 招呼语
       * </pre>
       *
       * <code>string Message = 4;</code>
       */
      public Builder setMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        message_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 招呼语
       * </pre>
       *
       * <code>string Message = 4;</code>
       */
      public Builder clearMessage() {
        
        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 招呼语
       * </pre>
       *
       * <code>string Message = 4;</code>
       */
      public Builder setMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        message_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object remark_ = "";
      /**
       * <pre>
       * 备注信息
       * </pre>
       *
       * <code>string Remark = 5;</code>
       */
      public java.lang.String getRemark() {
        java.lang.Object ref = remark_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          remark_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 备注信息
       * </pre>
       *
       * <code>string Remark = 5;</code>
       */
      public com.google.protobuf.ByteString
          getRemarkBytes() {
        java.lang.Object ref = remark_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          remark_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 备注信息
       * </pre>
       *
       * <code>string Remark = 5;</code>
       */
      public Builder setRemark(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        remark_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 备注信息
       * </pre>
       *
       * <code>string Remark = 5;</code>
       */
      public Builder clearRemark() {
        
        remark_ = getDefaultInstance().getRemark();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 备注信息
       * </pre>
       *
       * <code>string Remark = 5;</code>
       */
      public Builder setRemarkBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        remark_ = value;
        onChanged();
        return this;
      }

      private long taskId_ ;
      /**
       * <pre>
       *任务Id
       * </pre>
       *
       * <code>int64 TaskId = 6;</code>
       */
      public long getTaskId() {
        return taskId_;
      }
      /**
       * <pre>
       *任务Id
       * </pre>
       *
       * <code>int64 TaskId = 6;</code>
       */
      public Builder setTaskId(long value) {
        
        taskId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *任务Id
       * </pre>
       *
       * <code>int64 TaskId = 6;</code>
       */
      public Builder clearTaskId() {
        
        taskId_ = 0L;
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


      // @@protoc_insertion_point(builder_scope:Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage)
    }

    // @@protoc_insertion_point(class_scope:Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTaskMessage)
    private static final Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage();
    }

    public static Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AddFriendNameCardTaskMessage>
        PARSER = new com.google.protobuf.AbstractParser<AddFriendNameCardTaskMessage>() {
      public AddFriendNameCardTaskMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AddFriendNameCardTaskMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AddFriendNameCardTaskMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AddFriendNameCardTaskMessage> getParserForType() {
      return PARSER;
    }

    public Jubo.JuLiao.IM.Wx.Proto.AddFriendNameCardTask.AddFriendNameCardTaskMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\033AddFriendNameCardTask.proto\022\027Jubo.JuLi" +
      "ao.IM.Wx.Proto\"s\n\034AddFriendNameCardTaskM" +
      "essage\022\020\n\010WeChatId\030\001 \001(\t\022\020\n\010MsgSvrId\030\003 \001" +
      "(\003\022\017\n\007Message\030\004 \001(\t\022\016\n\006Remark\030\005 \001(\t\022\016\n\006T" +
      "askId\030\006 \001(\003b\006proto3"
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
    internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Jubo_JuLiao_IM_Wx_Proto_AddFriendNameCardTaskMessage_descriptor,
        new java.lang.String[] { "WeChatId", "MsgSvrId", "Message", "Remark", "TaskId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}