package com.trip.service;

import com.trip.mapper.FriendMapper;
import com.trip.vo.FriendVO;
import com.trip.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cong on 2018-12-30.
 */
@Service
public class FriendServiceImpl implements FriendService{

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public ResponseVO addFriend(FriendVO friendVO) {
        Integer friendId=friendMapper.select(friendVO);
        if(friendId!=null)
            return ResponseVO.buildFailure("已添加该好友");
        friendMapper.insertFriend(friendVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getAllFriend(Integer userId) {
        return ResponseVO.buildSuccess(friendMapper.selectAll(userId));
    }

    @Override
    public ResponseVO getFriendByName(Integer userId, String name) {
        return ResponseVO.buildSuccess(friendMapper.selectByName(userId,name));
    }

    @Override
    public ResponseVO getFollower(Integer friendId) {
        return ResponseVO.buildSuccess(friendMapper.selectByFriend(friendId));
    }

    @Override
    public ResponseVO deleteFriend(FriendVO friendVO) {
        friendMapper.deleteFriend(friendVO);
        return ResponseVO.buildSuccess();
    }
}
