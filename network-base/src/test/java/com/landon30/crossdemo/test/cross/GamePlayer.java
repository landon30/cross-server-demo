package com.landon30.crossdemo.test.cross;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 游戏服务器的一个玩家
 *
 * @author landon30
 */
public class GamePlayer {
    private long roleId;
    private int fight;
    private byte[] detail;

    public GamePlayer(long roleId, int fight) {
        this.roleId = roleId;
        this.fight = fight;

        detail = new byte[ThreadLocalRandom.current().nextInt(256)];
        ThreadLocalRandom.current().nextBytes(detail);
    }

    public long getRoleId() {
        return roleId;
    }

    public int getFight() {
        return fight;
    }

    public byte[] getDetail() {
        return detail;
    }
}
