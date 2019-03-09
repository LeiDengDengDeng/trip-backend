package com.trip.controller;

import com.trip.service.InvitationService;
import com.trip.vo.InvitationVO;
import com.trip.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 邀请加入团队
 * Created by cong on 2019-01-30.
 */
@RestController
public class InvitationController {

    @Autowired
    private InvitationService service;

    /**
     * 发起邀请
     * @param invitation
     * @return
     */
    @RequestMapping(value = "/invite",method = RequestMethod.POST)
    public ResponseVO invite(@RequestBody InvitationVO invitation){
        return service.invite(invitation);
    }

    /**
     * 查询所有邀请
     * @param receiverId 被邀请人的id
     * @return
     */
    @RequestMapping(value = "/invites/{receiverId}",method = RequestMethod.GET)
    public ResponseVO getInvitations(@PathVariable Integer receiverId){
        return service.getInvitations(receiverId);
    }

    /**
     * 查询未读邀请
     * @param receiverId 被邀请人的id
     * @return
     */
    @RequestMapping(value = "/invites/unread/{receiverId}",method = RequestMethod.GET)
    public ResponseVO getUnreadInvitations(@PathVariable Integer receiverId){
        return service.getUnreadInvitations(receiverId);
    }

}
