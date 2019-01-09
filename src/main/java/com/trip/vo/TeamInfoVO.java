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

    /**
     * 当前队伍人数
     */
    private Integer memberNum;
}
