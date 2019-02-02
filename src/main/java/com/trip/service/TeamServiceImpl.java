package com.trip.service;

import com.trip.enumeration.TeamIdentity;
import com.trip.mapper.TeamMapper;
import com.trip.mapper.TeamMemberMapper;
import com.trip.mapper.UserMapper;
import com.trip.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private UserMapper userMapper;

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
        if(teamMapper.selectTeamById(teamId) == null){
            return ResponseVO.buildFailure("不存在该队伍");
        }
        return ResponseVO.buildSuccess(teamMemberMapper.selectMemberByTeamId(teamId));
    }

    @Override
    public ResponseVO joinTeam(JoinTeamVO joinTeamVO) {
        TeamInfoVO teamInfoVO = teamMapper.selectTeamById(joinTeamVO.getTeamId());
        if(teamInfoVO == null){
            return ResponseVO.buildFailure("不存在该队伍");
        }
        if(userMapper.selectUserInfoById(joinTeamVO.getUserId()) == null){
            return ResponseVO.buildFailure("不存在该用户");
        }
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
        if(teamMapper.selectTeamById(teamId) == null){
            return ResponseVO.buildFailure("不存在该队伍");
        }
        return ResponseVO.buildSuccess(teamMapper.selectTeamById(teamId));
    }

    @Override
    public ResponseVO updateTeam(TeamVO teamVO) {
        if(teamMapper.selectTeamById(teamVO.getId()) == null){
            return ResponseVO.buildFailure("不存在此队伍");
        }
        return ResponseVO.buildSuccess(teamMapper.updateTeam(teamVO));
    }

    @Override
    public ResponseVO getMyEstablishedTeam(int userId) {
        if(userMapper.selectUserInfoById(userId) == null){
            return ResponseVO.buildFailure("不存在该用户");
        }
        List<Integer> teamIds = teamMemberMapper.selectTeamIdsByUserIdAndIdentity(userId,TeamIdentity.LEADER);
        return ResponseVO.buildSuccess(teamMapper.selectBatchOfTeamByIds(teamIds));
    }

    @Override
    public ResponseVO getMyJoinedTeam(int userId) {
        if(userMapper.selectUserInfoById(userId) == null){
            return ResponseVO.buildFailure("不存在该用户");
        }

        List<Integer> teamIds = teamMemberMapper.selectTeamIdsByUserIdAndIdentity(userId,TeamIdentity.MEMBER);
        if(teamIds.size() == 0){
            return ResponseVO.buildSuccess(new ArrayList<TeamInfoVO>());
        }
        return ResponseVO.buildSuccess(teamMapper.selectBatchOfTeamByIds(teamIds));
    }

    @Override
    public ResponseVO quitTeam(QuitTeamVO quitTeamVO) {
        TeamInfoVO teamInfoVO = teamMapper.selectTeamById(quitTeamVO.getTeamId());
        if(teamInfoVO == null){
            return ResponseVO.buildFailure("不存在该队伍");
        }
        if(userMapper.selectUserInfoById(quitTeamVO.getUserId()) == null) {
            return ResponseVO.buildFailure("不存在该用户");
        }
        TeamIdentity teamIdentity = teamMemberMapper.selectMemberIdentityByTeamIdAndUserId(quitTeamVO.getTeamId(),quitTeamVO.getUserId());
        if(teamIdentity == null){
            return ResponseVO.buildFailure("该队伍中不存在该用户");
        }
        return ResponseVO.buildSuccess(teamMemberMapper.deleteTeamMember(quitTeamVO));
    }

    @Override
    public ResponseVO disbandTeam(DisbandTeamVO disbandTeamVO) {
        TeamInfoVO teamInfoVO = teamMapper.selectTeamById(disbandTeamVO.getTeamId());
        if(teamInfoVO == null){
            return ResponseVO.buildFailure("不存在该队伍");
        }
        if(userMapper.selectUserInfoById(disbandTeamVO.getUserId()) == null) {
            return ResponseVO.buildFailure("不存在该用户");
        }
        TeamIdentity teamIdentity = teamMemberMapper.selectMemberIdentityByTeamIdAndUserId(disbandTeamVO.getTeamId(),disbandTeamVO.getUserId());
        if(teamIdentity == null){
            return ResponseVO.buildFailure("该队伍中不存在该用户");
        }
        if(teamIdentity != TeamIdentity.LEADER){
            return ResponseVO.buildFailure("没有权限");
        }
        // 获取队伍中所有成员
        List<TeamMemberVO> list = teamMemberMapper.selectMemberByTeamId(disbandTeamVO.getTeamId());
        // 成员逐个退出队伍
        for(TeamMemberVO member : list){
            QuitTeamVO quitTeamVO = new QuitTeamVO();
            quitTeamVO.setTeamId(disbandTeamVO.getTeamId());
            quitTeamVO.setUserId(member.getId());
            teamMemberMapper.deleteTeamMember(quitTeamVO);
        }
        // 删除队伍
        teamMapper.deleteTeam(disbandTeamVO);

        return ResponseVO.buildSuccess();

    }

    @Override
    public ResponseVO getAllTeamsByScenicId(int scenicId) {
        return ResponseVO.buildSuccess(teamMapper.selectAllTeamsByScenicId(scenicId));
    }
}
