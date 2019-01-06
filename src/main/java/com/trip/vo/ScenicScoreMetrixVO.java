package com.trip.vo;

/**
 * Created by cong on 2019-01-06.
 */
public class ScenicScoreMetrixVO {

    /**
     * 评分人数
     */
    private int count;

    /**
     * 平局评分
     */
    private double average;

    public ScenicScoreMetrixVO(int count, double average) {
        this.count = count;
        this.average = average;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
