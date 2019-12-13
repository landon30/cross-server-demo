package com.landon30.crossdemo.test.idea;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.landon30.crossdemo.test.net.CrossNetMessage;
import com.landon30.crossdemo.test.proto.Protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * 测试Hessian
 *
 * @author landon30
 */
public class TestHessian {
    public static void main(String[] args) throws Exception {
        // bytes由protobuf序列化得到
        Protocol.PlayerInfoMsg.Builder builder = Protocol.PlayerInfoMsg.newBuilder();
        builder.setName("landon");
        builder.setAge(31);

        Protocol.PlayerInfoMsg msg = builder.build();
        byte[] protoBytes = msg.toByteArray();

        // 用于hessian序列化的对象
        CrossNetMessage netMsg = new CrossNetMessage(Protocol.ProtocolMsgType.G_CROSS_PLAYER_INFO_VALUE, protoBytes);
        // hessian序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(bos);
        output.writeObject(netMsg);
        byte[] hessianBytes = bos.toByteArray();

        // hessian反序列化
        ByteArrayInputStream bin = new ByteArrayInputStream(hessianBytes);
        Hessian2Input input = new Hessian2Input(bin);

        CrossNetMessage deseNetMsg = (CrossNetMessage) input.readObject();

        System.out.println(deseNetMsg.getMsgType());
        System.out.println(Arrays.equals(protoBytes, deseNetMsg.getBody()));

        Protocol.PlayerInfoMsg deseMsg = Protocol.PlayerInfoMsg.parseFrom(deseNetMsg.getBody());
        System.out.println(deseMsg.getName() + ":" + deseMsg.getAge());

        System.out.println(Protocol.ProtocolMsgType.forNumber(deseNetMsg.getMsgType()));
    }
}
