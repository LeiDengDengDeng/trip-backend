package com.trip.service;

import com.trip.vo.InvitationVO;
import com.trip.vo.ResponseVO;

/**
 * 邀请
 * Created by cong on 2019-01-30.
 */
public interface InvitationService {

    /**
     * 发起邀请
     * @param invitation
     * @return
     */
    public ResponseVO invite(InvitationVO invitation);

    /**
     * 查询所有邀请
     * @param receiverId 被邀请人的id
     * @return
     */
    public ResponseVO getInvitations(Integer receiverId);

    /**
     * 查询未读邀请
     * @param receiverId 被邀请人的id
     * @return
     */
    public ResponseVO getUnreadInvitations(Integer receiverId);

}
