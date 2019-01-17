package com.trip.vo;

import lombok.Data;

/**
 * @author fjj
 * @date 2019/1/9 7:38 PM
 */
@Data
public class TeamInfoVO {
    private Integer id;
    private String name;
    private Long establishTime;
    private Integer minimumLimit;
    private Integer maximumLimit;
    private Long startTime;
    private Long endTime;
    private Integer scenicId;
    private String intro;
    private Double average;

    /**
     * 当前队伍人数
     */
    private Integer memberNum;
    /**
     * 景点名称
     */
    private String scenicName;
    /**
     * 景点图片
     */
    private String scenicPicUrl;
}
