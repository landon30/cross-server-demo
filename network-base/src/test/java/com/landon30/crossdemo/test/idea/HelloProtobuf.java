package com.landon30.crossdemo.test.idea;

import com.landon30.crossdemo.test.proto.Protocol;

/**
 * 测试protobuf的序列化和反序列化
 *
 * @author landon30
 */
public class HelloProtobuf {
    public static void main(String[] args) throws Exception {
        Protocol.PlayerInfoMsg.Builder builder = Protocol.PlayerInfoMsg.newBuilder();
        builder.setName("landon");
        builder.setAge(31);

        Protocol.PlayerInfoMsg msg = builder.build();
        byte[] bytes = msg.toByteArray();
        Protocol.PlayerInfoMsg deseMsg = Protocol.PlayerInfoMsg.parseFrom(bytes);

        System.out.println(deseMsg.getName());
        System.out.println(deseMsg.getAge());
    }
}
