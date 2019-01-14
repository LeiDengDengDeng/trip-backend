package com.trip.service;

import com.trip.enumeration.TeamIdentity;
import com.trip.mapper.TeamMapper;
import com.trip.mapper.TeamMemberMapper;
import com.trip.vo.JoinTeamVO;
import com.trip.vo.ResponseVO;
import com.trip.vo.TeamInfoVO;
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
    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Override
    public ResponseVO establishTeam(TeamVO teamVO) {
        teamVO.setEstablishTime(System.currentTimeMillis()/1000);
        //创建队伍
        teamMapper.insertTeam(teamVO);
        //插入成员表
        teamMemberMapper.insertTeamMember(teamVO.getId(),teamVO.getLeaderId(), TeamIdentity.LEADER);

        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getAllTeams() {
        return ResponseVO.buildSuccess(teamMapper.selectAllTeams());
    }

    @Override
    public ResponseVO getAllMembersByTeamId(int teamId) {
        return ResponseVO.buildSuccess(teamMemberMapper.selectMemberByTeamId(teamId));
    }

    @Override
    public ResponseVO joinTeam(JoinTeamVO joinTeamVO) {
        TeamInfoVO teamInfoVO = teamMapper.selectTeamById(joinTeamVO.getTeamId());
        boolean canJoin = true;
        if(teamInfoVO.getMaximumLimit() != null){
            if(teamInfoVO.getMemberNum() >= teamInfoVO.getMaximumLimit()){
                canJoin = false;
            }
        }
        if(canJoin){
            return ResponseVO.buildSuccess(teamMemberMapper.insertTeamMember(joinTeamVO.getTeamId(),
                    joinTeamVO.getUserId(),TeamIdentity.MEMBER));
        }else {
            return ResponseVO.buildFailure("该队伍已达最大人数，无法加入");
        }
    }

    @Override
    public ResponseVO getTeamById(int teamId) {
        return ResponseVO.buildSuccess(teamMapper.selectTeamById(teamId));
    }
}
