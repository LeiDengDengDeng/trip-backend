package com.trip.service;

import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;

/**
 * @author fjj
 * @date 2019/1/2 下午11:40
 */
public interface UserService {
    /**
     * 添加一个用户
     * @param userVO
     * @return
     */
    ResponseVO addUser(UserVO userVO);

    /**
     * 更新用户信息
     * @param userVO
     * @return
     */
    ResponseVO updateUser(UserVO userVO);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    ResponseVO getUser(int id);

    /**
     * 查询所有用户
     * @return
     */
    ResponseVO getAllUsers();

    /**
     * 通过状态查询用户
     * @param state
     * @return
     */
    ResponseVO getUsersByState(String state);

    /**
     * 微信id查找用户
     * @param username
     * @return
     */
    ResponseVO getUserByUsername(String username);


}
