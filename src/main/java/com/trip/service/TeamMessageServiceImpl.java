package com.trip.service;

import com.trip.mapper.TeamMessageMapper;
import com.trip.mapper.UserMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.TeamMessageDetailVO;
import com.trip.vo.TeamMessageVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

/**
 * Created by cong on 2019-01-30.
 */
@Service
public class TeamMessageServiceImpl implements TeamMessageService{

    @Autowired
    private TeamMessageMapper teamMessageMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVO selectTeamMessages(Integer teamId) {
        List<TeamMessageVO> teamMessages=teamMessageMapper.selectByTeam(teamId);
        List<TeamMessageDetailVO> teamMessageDetails=new ArrayList<>();

        Map<Integer,UserVO> userCache=new HashMap<>();
        for(TeamMessageVO teamMessage:teamMessages){
            UserVO sender=userCache.get(teamMessage.getSenderId());
            if(sender==null){//缓存中不存在
                sender=userMapper.selectUserInfoById(teamMessage.getSenderId());
                userCache.put(teamMessage.getSenderId(),sender);
            }
            if(sender==null)//查不到发送者信息,跳过这条消息
                continue;
            TeamMessageDetailVO detail=new TeamMessageDetailVO(sender,teamMessage);
            teamMessageDetails.add(detail);
        }
        return ResponseVO.buildSuccess(teamMessageDetails);
    }

    @Override
    public ResponseVO addTeamMessage(TeamMessageVO messageVO) {
        //TODO 判断是否为团队成员
        teamMessageMapper.insert(messageVO);
        return ResponseVO.buildSuccess();
    }
}
