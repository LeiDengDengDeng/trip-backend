package com.trip.vo;

import lombok.Data;

/**
 * @author fjj
 * @date 2019/1/7 下午1:09
 */
@Data
public class TeamVO {
    private Integer id;
    private String name;
    private Long establishTime;
    private Integer minimumLimit;
    private Integer maximumLimit;
    private Long startTime;
    private Long endTime;
    private Integer scenicId;
}
