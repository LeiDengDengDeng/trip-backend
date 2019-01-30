package com.trip.vo;

/**
 * 团队消息详细信息
 * 包括用户详细信息
 * Created by cong on 2019-01-30.
 */
public class TeamMessageDetailVO{

    /**
     * 发送者详细信息
     */
    private UserVO sender;

    /**
     * 团队消息
     */
    private TeamMessageVO message;

    public TeamMessageDetailVO(UserVO sender, TeamMessageVO message) {
        this.sender = sender;
        this.message = message;
    }

    public TeamMessageDetailVO() {
    }

    public UserVO getSender() {
        return sender;
    }

    public void setSender(UserVO sender) {
        this.sender = sender;
    }

    public TeamMessageVO getMessage() {
        return message;
    }

    public void setMessage(TeamMessageVO message) {
        this.message = message;
    }
}
