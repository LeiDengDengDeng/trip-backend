package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.TeamMessageVO;

import java.util.List;

/**
 * 团队消息
 * Created by cong on 2019-01-30.
 */
public interface TeamMessageService {

    /**
     * 查询团队消息
     * @param teamId
     * @return
     */
    public ResponseVO selectTeamMessages(Integer teamId);

    /**
     * 添加团队消息
     * @param messageVO
     * @return
     */
    public ResponseVO addTeamMessage(TeamMessageVO messageVO);

}
