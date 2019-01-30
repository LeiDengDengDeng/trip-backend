package com.trip.controller;

import com.trip.service.TeamMessageService;
import com.trip.vo.ResponseVO;
import com.trip.vo.TeamMessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 团队消息
 * Created by cong on 2019-01-30.
 */
@RestController
public class TeamMessageController {

    @Autowired
    private TeamMessageService messageService;

    /**
     * 查询团队消息
     * @param teamId
     * @return
     */
    @RequestMapping(value = "/teamMessages/{teamId}",method = RequestMethod.GET)
    public ResponseVO selectTeamMessages(@PathVariable Integer teamId){
        return messageService.selectTeamMessages(teamId);
    }

    /**
     * 添加团队消息
     * @param messageVO
     * @return
     */
    @RequestMapping(value = "/teamMessage",method = RequestMethod.POST)
    public ResponseVO addTeamMessage(@RequestBody TeamMessageVO messageVO){
        return messageService.addTeamMessage(messageVO);
    }

}
