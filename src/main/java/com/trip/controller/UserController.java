package com.trip.controller;

import com.trip.service.UserService;
import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fjj
 * @date 2019/1/2 下午11:40
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "user/add",method = RequestMethod.POST)
    public ResponseVO addUser(@RequestBody UserVO userVO){
        return userService.addUser(userVO);
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public ResponseVO updateUser(@RequestBody UserVO userVO){return userService.updateUser(userVO);}

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/username/{username}",method = RequestMethod.GET)
    public ResponseVO getUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @RequestMapping(value = "/user/all",method = RequestMethod.GET)
    public ResponseVO getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/user/state/{state}",method = RequestMethod.GET)
    public ResponseVO getUsersByState(@PathVariable String state){
        return userService.getUsersByState(state);
    }




}
