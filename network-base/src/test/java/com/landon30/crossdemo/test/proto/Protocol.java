// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protocol.proto

package com.landon30.crossdemo.test.proto;

public final class Protocol {
    private Protocol() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    /**
     * Protobuf enum {@code ProtocolMsgType}
     */
    public enum ProtocolMsgType
            implements com.google.protobuf.ProtocolMessageEnum {
        /**
         * <code>G_CROSS_PLAYER_INFO = 10001;</code>
         */
        G_CROSS_PLAYER_INFO(10001),
        ;

        /**
         * <code>G_CROSS_PLAYER_INFO = 10001;</code>
         */
        public static final int G_CROSS_PLAYER_INFO_VALUE = 10001;


        public final int getNumber() {
            return value;
        }

        /**
         * @deprecated Use {@link #forNumber(int)} instead.
         */
        @Deprecated
        public static ProtocolMsgType valueOf(int value) {
            return forNumber(value);
        }

        public static ProtocolMsgType forNumber(int value) {
            switch (value) {
                case 10001:
                    return G_CROSS_PLAYER_INFO;
                default:
                    return null;
            }
        }

        public static com.google.protobuf.Internal.EnumLiteMap<ProtocolMsgType>
        internalGetValueMap() {
            return internalValueMap;
        }

        private static final com.google.protobuf.Internal.EnumLiteMap<
                ProtocolMsgType> internalValueMap =
                new com.google.protobuf.Internal.EnumLiteMap<ProtocolMsgType>() {
                    public ProtocolMsgType findValueByNumber(int number) {
                        return ProtocolMsgType.forNumber(number);
                    }
                };

        public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
            return getDescriptor().getValues().get(ordinal());
        }

        public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
            return getDescriptor();
        }

        public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
            return Protocol.getDescriptor().getEnumTypes().get(0);
        }

        private static final ProtocolMsgType[] VALUES = values();

        public static ProtocolMsgType valueOf(
                com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException(
                        "EnumValueDescriptor is not for this type.");
            }
            return VALUES[desc.getIndex()];
        }

        private final int value;

        private ProtocolMsgType(int value) {
            this.value = value;
        }

        // @@protoc_insertion_point(enum_scope:ProtocolMsgType)
    }

    public interface PlayerInfoMsgOrBuilder extends
            // @@protoc_insertion_point(interface_extends:PlayerInfoMsg)
            com.google.protobuf.MessageOrBuilder {

        /**
         * <code>optional string name = 1;</code>
         */
        boolean hasName();

        /**
         * <code>optional string name = 1;</code>
         */
        String getName();

        /**
         * <code>optional string name = 1;</code>
         */
        com.google.protobuf.ByteString
        getNameBytes();

        /**
         * <code>optional int32 age = 2;</code>
         */
        boolean hasAge();

        /**
         * <code>optional int32 age = 2;</code>
         */
        int getAge();
    }

    /**
     * Protobuf type {@code PlayerInfoMsg}
     */
    public static final class PlayerInfoMsg extends
            com.google.protobuf.GeneratedMessageV3 implements
            // @@protoc_insertion_point(message_implements:PlayerInfoMsg)
            PlayerInfoMsgOrBuilder {
        // Use PlayerInfoMsg.newBuilder() to construct.
        private PlayerInfoMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private PlayerInfoMsg() {
            name_ = "";
            age_ = 0;
        }

        @Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private PlayerInfoMsg(
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
                            if (!parseUnknownField(input, unknownFields,
                                    extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            name_ = bs;
                            break;
                        }
                        case 16: {
                            bitField0_ |= 0x00000002;
                            age_ = input.readInt32();
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
            return Protocol.internal_static_PlayerInfoMsg_descriptor;
        }

        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return Protocol.internal_static_PlayerInfoMsg_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            PlayerInfoMsg.class, Builder.class);
        }

        private int bitField0_;
        public static final int NAME_FIELD_NUMBER = 1;
        private volatile Object name_;

        /**
         * <code>optional string name = 1;</code>
         */
        public boolean hasName() {
            return ((bitField0_ & 0x00000001) == 0x00000001);
        }

        /**
         * <code>optional string name = 1;</code>
         */
        public String getName() {
            Object ref = name_;
            if (ref instanceof String) {
                return (String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    name_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string name = 1;</code>
         */
        public com.google.protobuf.ByteString
        getNameBytes() {
            Object ref = name_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int AGE_FIELD_NUMBER = 2;
        private int age_;

        /**
         * <code>optional int32 age = 2;</code>
         */
        public boolean hasAge() {
            return ((bitField0_ & 0x00000002) == 0x00000002);
        }

        /**
         * <code>optional int32 age = 2;</code>
         */
        public int getAge() {
            return age_;
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
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                output.writeInt32(2, age_);
            }
            unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
            }
            if (((bitField0_ & 0x00000002) == 0x00000002)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(2, age_);
            }
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        private static final long serialVersionUID = 0L;

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PlayerInfoMsg)) {
                return super.equals(obj);
            }
            PlayerInfoMsg other = (PlayerInfoMsg) obj;

            boolean result = true;
            result = result && (hasName() == other.hasName());
            if (hasName()) {
                result = result && getName()
                        .equals(other.getName());
            }
            result = result && (hasAge() == other.hasAge());
            if (hasAge()) {
                result = result && (getAge()
                        == other.getAge());
            }
            result = result && unknownFields.equals(other.unknownFields);
            return result;
        }

        @Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasName()) {
                hash = (37 * hash) + NAME_FIELD_NUMBER;
                hash = (53 * hash) + getName().hashCode();
            }
            if (hasAge()) {
                hash = (37 * hash) + AGE_FIELD_NUMBER;
                hash = (53 * hash) + getAge();
            }
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static PlayerInfoMsg parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerInfoMsg parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerInfoMsg parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerInfoMsg parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerInfoMsg parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PlayerInfoMsg parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PlayerInfoMsg parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static PlayerInfoMsg parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerInfoMsg parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static PlayerInfoMsg parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PlayerInfoMsg parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static PlayerInfoMsg parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PlayerInfoMsg prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * Protobuf type {@code PlayerInfoMsg}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
                // @@protoc_insertion_point(builder_implements:PlayerInfoMsg)
                PlayerInfoMsgOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return Protocol.internal_static_PlayerInfoMsg_descriptor;
            }

            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return Protocol.internal_static_PlayerInfoMsg_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                PlayerInfoMsg.class, Builder.class);
            }

            // Construct using com.landon30.crossdemo.test.proto.Protocol.PlayerInfoMsg.newBuilder()
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
                name_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                age_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return Protocol.internal_static_PlayerInfoMsg_descriptor;
            }

            public PlayerInfoMsg getDefaultInstanceForType() {
                return PlayerInfoMsg.getDefaultInstance();
            }

            public PlayerInfoMsg build() {
                PlayerInfoMsg result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            public PlayerInfoMsg buildPartial() {
                PlayerInfoMsg result = new PlayerInfoMsg(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.name_ = name_;
                if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.age_ = age_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            public Builder clone() {
                return (Builder) super.clone();
            }

            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
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
                    int index, Object value) {
                return (Builder) super.setRepeatedField(field, index, value);
            }

            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    Object value) {
                return (Builder) super.addRepeatedField(field, value);
            }

            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof PlayerInfoMsg) {
                    return mergeFrom((PlayerInfoMsg) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(PlayerInfoMsg other) {
                if (other == PlayerInfoMsg.getDefaultInstance()) return this;
                if (other.hasName()) {
                    bitField0_ |= 0x00000001;
                    name_ = other.name_;
                    onChanged();
                }
                if (other.hasAge()) {
                    setAge(other.getAge());
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
                PlayerInfoMsg parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (PlayerInfoMsg) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private Object name_ = "";

            /**
             * <code>optional string name = 1;</code>
             */
            public boolean hasName() {
                return ((bitField0_ & 0x00000001) == 0x00000001);
            }

            /**
             * <code>optional string name = 1;</code>
             */
            public String getName() {
                Object ref = name_;
                if (!(ref instanceof String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        name_ = s;
                    }
                    return s;
                } else {
                    return (String) ref;
                }
            }

            /**
             * <code>optional string name = 1;</code>
             */
            public com.google.protobuf.ByteString
            getNameBytes() {
                Object ref = name_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (String) ref);
                    name_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string name = 1;</code>
             */
            public Builder setName(
                    String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string name = 1;</code>
             */
            public Builder clearName() {
                bitField0_ = (bitField0_ & ~0x00000001);
                name_ = getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /**
             * <code>optional string name = 1;</code>
             */
            public Builder setNameBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                name_ = value;
                onChanged();
                return this;
            }

            private int age_;

            /**
             * <code>optional int32 age = 2;</code>
             */
            public boolean hasAge() {
                return ((bitField0_ & 0x00000002) == 0x00000002);
            }

            /**
             * <code>optional int32 age = 2;</code>
             */
            public int getAge() {
                return age_;
            }

            /**
             * <code>optional int32 age = 2;</code>
             */
            public Builder setAge(int value) {
                bitField0_ |= 0x00000002;
                age_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional int32 age = 2;</code>
             */
            public Builder clearAge() {
                bitField0_ = (bitField0_ & ~0x00000002);
                age_ = 0;
                onChanged();
                return this;
            }

            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:PlayerInfoMsg)
        }

        // @@protoc_insertion_point(class_scope:PlayerInfoMsg)
        private static final PlayerInfoMsg DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new PlayerInfoMsg();
        }

        public static PlayerInfoMsg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @Deprecated
        public static final com.google.protobuf.Parser<PlayerInfoMsg>
                PARSER = new com.google.protobuf.AbstractParser<PlayerInfoMsg>() {
            public PlayerInfoMsg parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new PlayerInfoMsg(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<PlayerInfoMsg> parser() {
            return PARSER;
        }

        @Override
        public com.google.protobuf.Parser<PlayerInfoMsg> getParserForType() {
            return PARSER;
        }

        public PlayerInfoMsg getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_PlayerInfoMsg_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_PlayerInfoMsg_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        String[] descriptorData = {
                "\n\016protocol.proto\"*\n\rPlayerInfoMsg\022\014\n\004nam" +
                        "e\030\001 \001(\t\022\013\n\003age\030\002 \001(\005*+\n\017ProtocolMsgType\022" +
                        "\030\n\023G_CROSS_PLAYER_INFO\020\221NB#\n!com.landon3" +
                        "0.crossdemo.test.proto"
        };
        com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
                new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
                    public com.google.protobuf.ExtensionRegistry assignDescriptors(
                            com.google.protobuf.Descriptors.FileDescriptor root) {
                        descriptor = root;
                        return null;
                    }
                };
        com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        }, assigner);
        internal_static_PlayerInfoMsg_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_PlayerInfoMsg_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_PlayerInfoMsg_descriptor,
                new String[]{"Name", "Age",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
