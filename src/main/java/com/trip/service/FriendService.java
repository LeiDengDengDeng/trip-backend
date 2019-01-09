package com.trip.service;

import com.trip.vo.FriendVO;
import com.trip.vo.ResponseVO;

/**
 * Created by cong on 2018-12-30.
 */
public interface FriendService {

    /**
     * 添加好友
     * @param friendVO
     * @return
     */
    public ResponseVO addFriend(FriendVO friendVO);

    /**
     * 获取用户所有好友
     * @param userId
     * @return
     */
    public ResponseVO getAllFriend(Integer userId);

    /**
     * 根据姓名查找好友
     * @param userId
     * @param name
     * @return
     */
    public ResponseVO getFriendByName(Integer userId,String name);

    /**
     * 获取所有关注friendId的人
     * @param friendId
     * @return
     */
    public ResponseVO getFollower(Integer friendId);

    /**
     * 删除好友
     * @param friendVO
     * @return
     */
    public ResponseVO deleteFriend(FriendVO friendVO);
}
