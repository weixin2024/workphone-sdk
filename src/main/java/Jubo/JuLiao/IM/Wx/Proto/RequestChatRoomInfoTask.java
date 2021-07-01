// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RequestChatRoomInfoTask.proto

package Jubo.JuLiao.IM.Wx.Proto;

public final class RequestChatRoomInfoTask {
  private RequestChatRoomInfoTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RequestChatRoomInfoTaskMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * 商家所属微信号
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    java.lang.String getWeChatId();
    /**
     * <pre>
     * 商家所属微信号
     * </pre>
     *
     * <code>string WeChatId = 1;</code>
     */
    com.google.protobuf.ByteString
        getWeChatIdBytes();

    /**
     * <code>string ChatRoomId = 2;</code>
     */
    java.lang.String getChatRoomId();
    /**
     * <code>string ChatRoomId = 2;</code>
     */
    com.google.protobuf.ByteString
        getChatRoomIdBytes();

    /**
     * <pre>
     * Flag=1:推送成员信息（ChatRoomMembersNotice)
     * </pre>
     *
     * <code>int32 Flag = 3;</code>
     */
    int getFlag();
  }
  /**
   * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage}
   */
  public  static final class RequestChatRoomInfoTaskMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage)
      RequestChatRoomInfoTaskMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RequestChatRoomInfoTaskMessage.newBuilder() to construct.
    private RequestChatRoomInfoTaskMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RequestChatRoomInfoTaskMessage() {
      weChatId_ = "";
      chatRoomId_ = "";
      flag_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RequestChatRoomInfoTaskMessage(
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
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              chatRoomId_ = s;
              break;
            }
            case 24: {

              flag_ = input.readInt32();
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
      return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.Builder.class);
    }

    public static final int WECHATID_FIELD_NUMBER = 1;
    private volatile java.lang.Object weChatId_;
    /**
     * <pre>
     * 商家所属微信号
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
     * 商家所属微信号
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

    public static final int CHATROOMID_FIELD_NUMBER = 2;
    private volatile java.lang.Object chatRoomId_;
    /**
     * <code>string ChatRoomId = 2;</code>
     */
    public java.lang.String getChatRoomId() {
      java.lang.Object ref = chatRoomId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        chatRoomId_ = s;
        return s;
      }
    }
    /**
     * <code>string ChatRoomId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getChatRoomIdBytes() {
      java.lang.Object ref = chatRoomId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        chatRoomId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FLAG_FIELD_NUMBER = 3;
    private int flag_;
    /**
     * <pre>
     * Flag=1:推送成员信息（ChatRoomMembersNotice)
     * </pre>
     *
     * <code>int32 Flag = 3;</code>
     */
    public int getFlag() {
      return flag_;
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
      if (!getChatRoomIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, chatRoomId_);
      }
      if (flag_ != 0) {
        output.writeInt32(3, flag_);
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
      if (!getChatRoomIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, chatRoomId_);
      }
      if (flag_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, flag_);
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
      if (!(obj instanceof Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage)) {
        return super.equals(obj);
      }
      Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage other = (Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage) obj;

      boolean result = true;
      result = result && getWeChatId()
          .equals(other.getWeChatId());
      result = result && getChatRoomId()
          .equals(other.getChatRoomId());
      result = result && (getFlag()
          == other.getFlag());
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
      hash = (37 * hash) + CHATROOMID_FIELD_NUMBER;
      hash = (53 * hash) + getChatRoomId().hashCode();
      hash = (37 * hash) + FLAG_FIELD_NUMBER;
      hash = (53 * hash) + getFlag();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parseFrom(
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
    public static Builder newBuilder(Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage prototype) {
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
     * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage)
        Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.Builder.class);
      }

      // Construct using Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.newBuilder()
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

        chatRoomId_ = "";

        flag_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor;
      }

      public Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage getDefaultInstanceForType() {
        return Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.getDefaultInstance();
      }

      public Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage build() {
        Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage buildPartial() {
        Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage result = new Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage(this);
        result.weChatId_ = weChatId_;
        result.chatRoomId_ = chatRoomId_;
        result.flag_ = flag_;
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
        if (other instanceof Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage) {
          return mergeFrom((Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage other) {
        if (other == Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage.getDefaultInstance()) return this;
        if (!other.getWeChatId().isEmpty()) {
          weChatId_ = other.weChatId_;
          onChanged();
        }
        if (!other.getChatRoomId().isEmpty()) {
          chatRoomId_ = other.chatRoomId_;
          onChanged();
        }
        if (other.getFlag() != 0) {
          setFlag(other.getFlag());
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
        Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage) e.getUnfinishedMessage();
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
       * 商家所属微信号
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
       * 商家所属微信号
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
       * 商家所属微信号
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
       * 商家所属微信号
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
       * 商家所属微信号
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

      private java.lang.Object chatRoomId_ = "";
      /**
       * <code>string ChatRoomId = 2;</code>
       */
      public java.lang.String getChatRoomId() {
        java.lang.Object ref = chatRoomId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          chatRoomId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ChatRoomId = 2;</code>
       */
      public com.google.protobuf.ByteString
          getChatRoomIdBytes() {
        java.lang.Object ref = chatRoomId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          chatRoomId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ChatRoomId = 2;</code>
       */
      public Builder setChatRoomId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        chatRoomId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ChatRoomId = 2;</code>
       */
      public Builder clearChatRoomId() {
        
        chatRoomId_ = getDefaultInstance().getChatRoomId();
        onChanged();
        return this;
      }
      /**
       * <code>string ChatRoomId = 2;</code>
       */
      public Builder setChatRoomIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        chatRoomId_ = value;
        onChanged();
        return this;
      }

      private int flag_ ;
      /**
       * <pre>
       * Flag=1:推送成员信息（ChatRoomMembersNotice)
       * </pre>
       *
       * <code>int32 Flag = 3;</code>
       */
      public int getFlag() {
        return flag_;
      }
      /**
       * <pre>
       * Flag=1:推送成员信息（ChatRoomMembersNotice)
       * </pre>
       *
       * <code>int32 Flag = 3;</code>
       */
      public Builder setFlag(int value) {
        
        flag_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Flag=1:推送成员信息（ChatRoomMembersNotice)
       * </pre>
       *
       * <code>int32 Flag = 3;</code>
       */
      public Builder clearFlag() {
        
        flag_ = 0;
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


      // @@protoc_insertion_point(builder_scope:Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage)
    }

    // @@protoc_insertion_point(class_scope:Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTaskMessage)
    private static final Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage();
    }

    public static Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RequestChatRoomInfoTaskMessage>
        PARSER = new com.google.protobuf.AbstractParser<RequestChatRoomInfoTaskMessage>() {
      public RequestChatRoomInfoTaskMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RequestChatRoomInfoTaskMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RequestChatRoomInfoTaskMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RequestChatRoomInfoTaskMessage> getParserForType() {
      return PARSER;
    }

    public Jubo.JuLiao.IM.Wx.Proto.RequestChatRoomInfoTask.RequestChatRoomInfoTaskMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035RequestChatRoomInfoTask.proto\022\027Jubo.Ju" +
      "Liao.IM.Wx.Proto\"T\n\036RequestChatRoomInfoT" +
      "askMessage\022\020\n\010WeChatId\030\001 \001(\t\022\022\n\nChatRoom" +
      "Id\030\002 \001(\t\022\014\n\004Flag\030\003 \001(\005b\006proto3"
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
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Jubo_JuLiao_IM_Wx_Proto_RequestChatRoomInfoTaskMessage_descriptor,
        new java.lang.String[] { "WeChatId", "ChatRoomId", "Flag", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
