package com.trip.service;

import com.trip.mapper.FriendMapper;
import com.trip.mapper.UserMapper;
import com.trip.vo.FriendVO;
import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2018-12-30.
 */
@Service
public class FriendServiceImpl implements FriendService{

    @Autowired
    private FriendMapper friendMapper;

    @Autowired
    private UserMapper userMapper;

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
        List<Integer> friendIds=friendMapper.selectAll(userId);
        List<UserVO> friends = getUserVOList(friendIds);
        return ResponseVO.buildSuccess(friends);
    }

    private List<UserVO> getUserVOList(List<Integer> friendIds) {
        List<UserVO> friends=new ArrayList<>();
        for(Integer friendId:friendIds){
            UserVO friend=userMapper.selectUserInfoById(friendId);
            if(friend!=null){
                friends.add(friend);
            }
        }
        return friends;
    }

    @Override
    public ResponseVO getFriendByName(Integer userId, String name) {
        List<Integer> friendIds=friendMapper.selectByName(userId,name);
        return ResponseVO.buildSuccess(getUserVOList(friendIds));
    }

    @Override
    public ResponseVO getFollower(Integer friendId) {
        List<Integer> followerIds=friendMapper.selectByFriend(friendId);
        return ResponseVO.buildSuccess(getUserVOList(followerIds));
    }

    @Override
    public ResponseVO deleteFriend(FriendVO friendVO) {
        friendMapper.deleteFriend(friendVO);
        return ResponseVO.buildSuccess();
    }
}
