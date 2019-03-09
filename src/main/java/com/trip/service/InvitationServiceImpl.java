package com.trip.service;

import com.trip.mapper.InvitationMapper;
import com.trip.vo.InvitationVO;
import com.trip.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cong on 2019-01-30.
 */
@Service
public class InvitationServiceImpl implements InvitationService{

    @Autowired
    private InvitationMapper invitationMapper;

    private static final ExecutorService THREAD_POOL= Executors.newCachedThreadPool();

    @Override
    public ResponseVO invite(InvitationVO invitation) {
        //TODO 判断邀请人是否在团队中
        //TODO 判断被邀请人是否在团队中
        invitationMapper.insert(invitation);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getInvitations(Integer receiverId) {
        List<InvitationVO> invitations=invitationMapper.selectByReceiver(receiverId);
        signRead(invitations);
        return ResponseVO.buildSuccess(invitations);
    }

    @Override
    public ResponseVO getUnreadInvitations(Integer receiverId) {
        List<InvitationVO> invitations=invitationMapper.selectByReceiverAndRead(receiverId,false);
        signRead(invitations);
        return ResponseVO.buildSuccess(invitations);
    }

    /**
     * 将邀请标记为已读
     * @param invitations
     */
    private void signRead(List<InvitationVO> invitations){
        THREAD_POOL.submit(()->{
            for(InvitationVO invitation:invitations){
                if(invitation.getHasRead())//已读，不需要标记
                    continue;
                invitationMapper.updateHasRead(invitation.getId(),true);
            }
        });
    }
}
