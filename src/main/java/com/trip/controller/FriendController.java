package com.trip.controller;

import com.trip.service.FriendService;
import com.trip.vo.FriendVO;
import com.trip.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cong on 2018-12-30.
 */
@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    /**
     * 添加好友
     * @param friendVO
     * @return
     */
    @RequestMapping(value = "/friend",method = RequestMethod.POST)
    public ResponseVO addFriend(@RequestBody FriendVO friendVO){
        return friendService.addFriend(friendVO);
    }

    /**
     * 获取用户所有好友
     * @param userId
     * @return
     */
    @RequestMapping(value = "/friend/{userId}",method = RequestMethod.GET)
    public ResponseVO getAllFriend(@PathVariable Integer userId){
        return friendService.getAllFriend(userId);
    }

    /**
     * 根据姓名查找好友
     * @param userId
     * @param name
     * @return
     */
    @RequestMapping(value = "/friend",method = RequestMethod.GET)
    public ResponseVO getFriendByName(@RequestParam Integer userId,@RequestParam String name){
        return friendService.getFriendByName(userId,name);
    }



}
