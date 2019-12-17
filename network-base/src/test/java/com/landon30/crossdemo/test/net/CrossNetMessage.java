package com.landon30.crossdemo.test.net;

import java.io.Serializable;

/**
 * 用于测试的跨服务器沟通的消息，参考'RequestBody'
 *
 * @author landon30
 */
public class CrossNetMessage implements Serializable {

    private static final long serialVersionUID = -2172197944632027298L;

    private int msgType;
    private byte[] body;

    public CrossNetMessage(int msgType, byte[] body) {
        this.msgType = msgType;
        this.body = body;
    }

    public CrossNetMessage(int msgType) {
        this.msgType = msgType;
    }

    public int getMsgType() {
        return msgType;
    }

    public byte[] getBody() {
        return body;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
