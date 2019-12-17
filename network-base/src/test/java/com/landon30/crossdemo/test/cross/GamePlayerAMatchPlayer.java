package com.landon30.crossdemo.test.cross;

/**
 * 跨服玩法A的匹配数据，按照战力匹配
 *
 * @author landon30
 */
public class GamePlayerAMatchPlayer {
    private int serverId;
    private long roleId;
    private int fight;

    public GamePlayerAMatchPlayer(int serverId, long roleId, int fight) {
        this.serverId = serverId;
        this.roleId = roleId;
        this.fight = fight;
    }

    public int getServerId() {
        return serverId;
    }

    public long getRoleId() {
        return roleId;
    }

    public int getFight() {
        return fight;
    }
}
