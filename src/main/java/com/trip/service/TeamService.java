package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.TeamVO;

/**
 * @author fjj
 * @date 2019/1/7 下午1:13
 */
public interface TeamService {
    /**
     * 创建出游队伍
     * @param teamVO
     * @return
     */
    ResponseVO establishTeam(TeamVO teamVO);
}
