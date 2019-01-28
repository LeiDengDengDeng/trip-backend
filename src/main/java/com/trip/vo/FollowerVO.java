package com.trip.vo;

/**
 * 关注我的
 * 加了一个属性：我是否已关注
 * Created by cong on 2019-01-26.
 */
public class FollowerVO extends UserVO{

    /**
     * 我是否关注
     */
    private boolean hasFollowed;

    public boolean getHasFollowed() {
        return hasFollowed;
    }

    public void setHasFollowed(boolean hasFollowed) {
        this.hasFollowed = hasFollowed;
    }
}
