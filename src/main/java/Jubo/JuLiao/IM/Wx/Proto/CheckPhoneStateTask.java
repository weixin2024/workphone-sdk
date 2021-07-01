// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: CheckPhoneStateTask.proto

package Jubo.JuLiao.IM.Wx.Proto;

public final class CheckPhoneStateTask {
  private CheckPhoneStateTask() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CheckPhoneStateTaskMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage)
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
     * WechatId和imei用于服务端选择通道，对客户端无用
     * </pre>
     *
     * <code>string Imei = 2;</code>
     */
    java.lang.String getImei();
    /**
     * <pre>
     * WechatId和imei用于服务端选择通道，对客户端无用
     * </pre>
     *
     * <code>string Imei = 2;</code>
     */
    com.google.protobuf.ByteString
        getImeiBytes();
  }
  /**
   * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage}
   */
  public  static final class CheckPhoneStateTaskMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage)
      CheckPhoneStateTaskMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CheckPhoneStateTaskMessage.newBuilder() to construct.
    private CheckPhoneStateTaskMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CheckPhoneStateTaskMessage() {
      weChatId_ = "";
      imei_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private CheckPhoneStateTaskMessage(
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

              imei_ = s;
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
      return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.Builder.class);
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

    public static final int IMEI_FIELD_NUMBER = 2;
    private volatile java.lang.Object imei_;
    /**
     * <pre>
     * WechatId和imei用于服务端选择通道，对客户端无用
     * </pre>
     *
     * <code>string Imei = 2;</code>
     */
    public java.lang.String getImei() {
      java.lang.Object ref = imei_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imei_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * WechatId和imei用于服务端选择通道，对客户端无用
     * </pre>
     *
     * <code>string Imei = 2;</code>
     */
    public com.google.protobuf.ByteString
        getImeiBytes() {
      java.lang.Object ref = imei_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imei_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getImeiBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, imei_);
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
      if (!getImeiBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, imei_);
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
      if (!(obj instanceof Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage)) {
        return super.equals(obj);
      }
      Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage other = (Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage) obj;

      boolean result = true;
      result = result && getWeChatId()
          .equals(other.getWeChatId());
      result = result && getImei()
          .equals(other.getImei());
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
      hash = (37 * hash) + IMEI_FIELD_NUMBER;
      hash = (53 * hash) + getImei().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parseFrom(
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
    public static Builder newBuilder(Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage prototype) {
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
     * Protobuf type {@code Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage)
        Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.class, Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.Builder.class);
      }

      // Construct using Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.newBuilder()
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

        imei_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor;
      }

      public Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage getDefaultInstanceForType() {
        return Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.getDefaultInstance();
      }

      public Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage build() {
        Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage buildPartial() {
        Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage result = new Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage(this);
        result.weChatId_ = weChatId_;
        result.imei_ = imei_;
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
        if (other instanceof Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage) {
          return mergeFrom((Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage other) {
        if (other == Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage.getDefaultInstance()) return this;
        if (!other.getWeChatId().isEmpty()) {
          weChatId_ = other.weChatId_;
          onChanged();
        }
        if (!other.getImei().isEmpty()) {
          imei_ = other.imei_;
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
        Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage) e.getUnfinishedMessage();
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

      private java.lang.Object imei_ = "";
      /**
       * <pre>
       * WechatId和imei用于服务端选择通道，对客户端无用
       * </pre>
       *
       * <code>string Imei = 2;</code>
       */
      public java.lang.String getImei() {
        java.lang.Object ref = imei_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          imei_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * WechatId和imei用于服务端选择通道，对客户端无用
       * </pre>
       *
       * <code>string Imei = 2;</code>
       */
      public com.google.protobuf.ByteString
          getImeiBytes() {
        java.lang.Object ref = imei_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          imei_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * WechatId和imei用于服务端选择通道，对客户端无用
       * </pre>
       *
       * <code>string Imei = 2;</code>
       */
      public Builder setImei(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        imei_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * WechatId和imei用于服务端选择通道，对客户端无用
       * </pre>
       *
       * <code>string Imei = 2;</code>
       */
      public Builder clearImei() {
        
        imei_ = getDefaultInstance().getImei();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * WechatId和imei用于服务端选择通道，对客户端无用
       * </pre>
       *
       * <code>string Imei = 2;</code>
       */
      public Builder setImeiBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        imei_ = value;
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


      // @@protoc_insertion_point(builder_scope:Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage)
    }

    // @@protoc_insertion_point(class_scope:Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTaskMessage)
    private static final Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage();
    }

    public static Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CheckPhoneStateTaskMessage>
        PARSER = new com.google.protobuf.AbstractParser<CheckPhoneStateTaskMessage>() {
      public CheckPhoneStateTaskMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new CheckPhoneStateTaskMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<CheckPhoneStateTaskMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CheckPhoneStateTaskMessage> getParserForType() {
      return PARSER;
    }

    public Jubo.JuLiao.IM.Wx.Proto.CheckPhoneStateTask.CheckPhoneStateTaskMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031CheckPhoneStateTask.proto\022\027Jubo.JuLiao" +
      ".IM.Wx.Proto\"<\n\032CheckPhoneStateTaskMessa" +
      "ge\022\020\n\010WeChatId\030\001 \001(\t\022\014\n\004Imei\030\002 \001(\tb\006prot" +
      "o3"
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
    internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Jubo_JuLiao_IM_Wx_Proto_CheckPhoneStateTaskMessage_descriptor,
        new java.lang.String[] { "WeChatId", "Imei", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}