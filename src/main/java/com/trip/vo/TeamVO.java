package com.trip.vo;

import lombok.Data;

/**
 * @author fjj
 * @date 2019/1/7 下午1:09
 */
@Data
public class TeamVO {
    // 自增id
    private Integer id;
    // 队伍名称
    private String name;
    // 创建时间
    private Long establishTime;
    // 最小组队人数
    private Integer minimumLimit;
    // 最大组队人数
    private Integer maximumLimit;
    // 计划出游时间
    private Long startTime;
    // 计划回程时间
    private Long endTime;
    // 预计去的景点id
    private Integer scenicId;
    // 创建者id
    private Integer leaderId;
}
