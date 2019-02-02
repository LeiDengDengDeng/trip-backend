package com.trip.vo;

/**
 * Created by cong on 2018-12-29.
 */
public class FriendVO {

    private Integer userId;

    private Integer friendId;

    private String friendName;

    public FriendVO(Integer userId, Integer friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public FriendVO() {
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}
