package com.trip.service;

import com.trip.mapper.TeamMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author fjj
 * @date 2019/1/7 下午1:14
 */

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public ResponseVO establishTeam(TeamVO teamVO) {
        teamVO.setEstablishTime(System.currentTimeMillis()/1000);
        return ResponseVO.buildSuccess(teamMapper.insertTeam(teamVO));
    }
}
