// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RevokeMessageTask.proto

package Jubo.JuLiao.IM.Wx.Proto;

public final class RevokeMessageTask {
  private RevokeMessageTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RevokeMessageTaskMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *消息的msgSvrId
     * </pre>
     *
     * <code>int64 MsgId = 1;</code>
     */
    long getMsgId();

    /**
     * <pre>
     *微信唯一Id
     * </pre>
     *
     * <code>string WeChatId = 2;</code>
     */
    java.lang.String getWeChatId();
    /**
     * <pre>
     *微信唯一Id
     * </pre>
     *
     * <code>string WeChatId = 2;</code>
     */
    com.google.protobuf.ByteString
        getWeChatIdBytes();

    /**
     * <pre>
     *聊天好友微信唯一id
     * </pre>
     *
     * <code>string FriendId = 3;</code>
     */
    java.lang.String getFriendId();
    /**
     * <pre>
     *聊天好友微信唯一id
     * </pre>
     *
     * <code>string FriendId = 3;</code>
     */
    com.google.protobuf.ByteString
        getFriendIdBytes();

    /**
     * <pre>
     * </pre>
     *
     * <code>int64 TaskId = 4;</code>
     */
    long getTaskId();
  }
  /**
   * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage}
   */
  public  static final class RevokeMessageTaskMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage)
      RevokeMessageTaskMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RevokeMessageTaskMessage.newBuilder() to construct.
    private RevokeMessageTaskMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RevokeMessageTaskMessage() {
      msgId_ = 0L;
      weChatId_ = "";
      friendId_ = "";
      taskId_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RevokeMessageTaskMessage(
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
            case 8: {

              msgId_ = input.readInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              weChatId_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              friendId_ = s;
              break;
            }
            case 32: {

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
      return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.Builder.class);
    }

    public static final int MSGID_FIELD_NUMBER = 1;
    private long msgId_;
    /**
     * <pre>
     *消息的msgSvrId
     * </pre>
     *
     * <code>int64 MsgId = 1;</code>
     */
    public long getMsgId() {
      return msgId_;
    }

    public static final int WECHATID_FIELD_NUMBER = 2;
    private volatile java.lang.Object weChatId_;
    /**
     * <pre>
     *微信唯一Id
     * </pre>
     *
     * <code>string WeChatId = 2;</code>
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
     *微信唯一Id
     * </pre>
     *
     * <code>string WeChatId = 2;</code>
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

    public static final int FRIENDID_FIELD_NUMBER = 3;
    private volatile java.lang.Object friendId_;
    /**
     * <pre>
     *聊天好友微信唯一id
     * </pre>
     *
     * <code>string FriendId = 3;</code>
     */
    public java.lang.String getFriendId() {
      java.lang.Object ref = friendId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        friendId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     *聊天好友微信唯一id
     * </pre>
     *
     * <code>string FriendId = 3;</code>
     */
    public com.google.protobuf.ByteString
        getFriendIdBytes() {
      java.lang.Object ref = friendId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        friendId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TASKID_FIELD_NUMBER = 4;
    private long taskId_;
    /**
     * <pre>
     * </pre>
     *
     * <code>int64 TaskId = 4;</code>
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
      if (msgId_ != 0L) {
        output.writeInt64(1, msgId_);
      }
      if (!getWeChatIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, weChatId_);
      }
      if (!getFriendIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, friendId_);
      }
      if (taskId_ != 0L) {
        output.writeInt64(4, taskId_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (msgId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, msgId_);
      }
      if (!getWeChatIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, weChatId_);
      }
      if (!getFriendIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, friendId_);
      }
      if (taskId_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(4, taskId_);
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
      if (!(obj instanceof Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage)) {
        return super.equals(obj);
      }
      Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage other = (Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage) obj;

      boolean result = true;
      result = result && (getMsgId()
          == other.getMsgId());
      result = result && getWeChatId()
          .equals(other.getWeChatId());
      result = result && getFriendId()
          .equals(other.getFriendId());
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
      hash = (37 * hash) + MSGID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getMsgId());
      hash = (37 * hash) + WECHATID_FIELD_NUMBER;
      hash = (53 * hash) + getWeChatId().hashCode();
      hash = (37 * hash) + FRIENDID_FIELD_NUMBER;
      hash = (53 * hash) + getFriendId().hashCode();
      hash = (37 * hash) + TASKID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTaskId());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parseFrom(
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
    public static Builder newBuilder(Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage prototype) {
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
     * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage)
        Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.Builder.class);
      }

      // Construct using Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.newBuilder()
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
        msgId_ = 0L;

        weChatId_ = "";

        friendId_ = "";

        taskId_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor;
      }

      public Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage getDefaultInstanceForType() {
        return Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.getDefaultInstance();
      }

      public Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage build() {
        Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage buildPartial() {
        Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage result = new Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage(this);
        result.msgId_ = msgId_;
        result.weChatId_ = weChatId_;
        result.friendId_ = friendId_;
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
        if (other instanceof Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage) {
          return mergeFrom((Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage other) {
        if (other == Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage.getDefaultInstance()) return this;
        if (other.getMsgId() != 0L) {
          setMsgId(other.getMsgId());
        }
        if (!other.getWeChatId().isEmpty()) {
          weChatId_ = other.weChatId_;
          onChanged();
        }
        if (!other.getFriendId().isEmpty()) {
          friendId_ = other.friendId_;
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
        Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long msgId_ ;
      /**
       * <pre>
       *消息的msgSvrId
       * </pre>
       *
       * <code>int64 MsgId = 1;</code>
       */
      public long getMsgId() {
        return msgId_;
      }
      /**
       * <pre>
       *消息的msgSvrId
       * </pre>
       *
       * <code>int64 MsgId = 1;</code>
       */
      public Builder setMsgId(long value) {
        
        msgId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *消息的msgSvrId
       * </pre>
       *
       * <code>int64 MsgId = 1;</code>
       */
      public Builder clearMsgId() {
        
        msgId_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object weChatId_ = "";
      /**
       * <pre>
       *微信唯一Id
       * </pre>
       *
       * <code>string WeChatId = 2;</code>
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
       *微信唯一Id
       * </pre>
       *
       * <code>string WeChatId = 2;</code>
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
       *微信唯一Id
       * </pre>
       *
       * <code>string WeChatId = 2;</code>
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
       *微信唯一Id
       * </pre>
       *
       * <code>string WeChatId = 2;</code>
       */
      public Builder clearWeChatId() {
        
        weChatId_ = getDefaultInstance().getWeChatId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *微信唯一Id
       * </pre>
       *
       * <code>string WeChatId = 2;</code>
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

      private java.lang.Object friendId_ = "";
      /**
       * <pre>
       *聊天好友微信唯一id
       * </pre>
       *
       * <code>string FriendId = 3;</code>
       */
      public java.lang.String getFriendId() {
        java.lang.Object ref = friendId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          friendId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       *聊天好友微信唯一id
       * </pre>
       *
       * <code>string FriendId = 3;</code>
       */
      public com.google.protobuf.ByteString
          getFriendIdBytes() {
        java.lang.Object ref = friendId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          friendId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       *聊天好友微信唯一id
       * </pre>
       *
       * <code>string FriendId = 3;</code>
       */
      public Builder setFriendId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        friendId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *聊天好友微信唯一id
       * </pre>
       *
       * <code>string FriendId = 3;</code>
       */
      public Builder clearFriendId() {
        
        friendId_ = getDefaultInstance().getFriendId();
        onChanged();
        return this;
      }
      /**
       * <pre>
       *聊天好友微信唯一id
       * </pre>
       *
       * <code>string FriendId = 3;</code>
       */
      public Builder setFriendIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        friendId_ = value;
        onChanged();
        return this;
      }

      private long taskId_ ;
      /**
       * <pre>
       * </pre>
       *
       * <code>int64 TaskId = 4;</code>
       */
      public long getTaskId() {
        return taskId_;
      }
      /**
       * <pre>
       * </pre>
       *
       * <code>int64 TaskId = 4;</code>
       */
      public Builder setTaskId(long value) {
        
        taskId_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * </pre>
       *
       * <code>int64 TaskId = 4;</code>
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


      // @@protoc_insertion_point(builder_scope:Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage)
    }

    // @@protoc_insertion_point(class_scope:Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTaskMessage)
    private static final Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage();
    }

    public static Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RevokeMessageTaskMessage>
        PARSER = new com.google.protobuf.AbstractParser<RevokeMessageTaskMessage>() {
      public RevokeMessageTaskMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RevokeMessageTaskMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RevokeMessageTaskMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RevokeMessageTaskMessage> getParserForType() {
      return PARSER;
    }

    public Jubo.JuLiao.IM.Wx.Proto.RevokeMessageTask.RevokeMessageTaskMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\027RevokeMessageTask.proto\022\027Jubo.JuLiao.I" +
      "M.Wx.Proto\"]\n\030RevokeMessageTaskMessage\022\r" +
      "\n\005MsgId\030\001 \001(\003\022\020\n\010WeChatId\030\002 \001(\t\022\020\n\010Frien" +
      "dId\030\003 \001(\t\022\016\n\006TaskId\030\004 \001(\003b\006proto3"
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
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Jubo_JuLiao_IM_Wx_Proto_RevokeMessageTaskMessage_descriptor,
        new java.lang.String[] { "MsgId", "WeChatId", "FriendId", "TaskId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
