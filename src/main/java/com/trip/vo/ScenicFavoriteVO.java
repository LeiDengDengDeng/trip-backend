package com.trip.vo;

/**
 * 景点收藏
 * Created by cong on 2019-01-11.
 */
public class ScenicFavoriteVO {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 景点id
     */
    private Integer scenicId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getScenicId() {
        return scenicId;
    }

    public void setScenicId(Integer scenicId) {
        this.scenicId = scenicId;
    }
}
