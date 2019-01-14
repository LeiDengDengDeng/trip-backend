package com.trip.vo;

/**
 * Created by cong on 2019-01-10.
 */
public class ScenicInfoVO extends ScenicVO{

    /**
     * 平均评分
     */
    private double star;

    /**
     * 评论人数
     */
    private int commentCount;

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
