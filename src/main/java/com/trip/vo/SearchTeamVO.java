package com.trip.vo;

import lombok.Data;

/**
 * @author fjj
 * @date 2019/3/26 12:14 AM
 */
@Data
public class SearchTeamVO {
    /**
     * 队伍名称关键词
     */
    private String keyWord;
    /**
     * 小于等于此时间出游的队伍
     */
    private Long beforeTime;
    /**
     * 景点名称关键词
     */
    private String scenicNameKeyWord;
    private Long currentTime;
}
