package com.trip.service;

import com.trip.enumeration.UserIdentity;
import com.trip.enumeration.UserState;
import com.trip.mapper.UserMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author fjj
 * @date 2019/1/2 下午11:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public ResponseVO addUser(UserVO userVO) {
        try {
            UserVO userVO1 = userMapper.selectUserByAvatar(userVO.getAvatar());
            if(userVO1 != null){
                return ResponseVO.buildSuccess(userVO1);
            }
            userVO.setJoinDate(System.currentTimeMillis()/1000);
            userVO.setState(UserState.UNCHECKED);
            userVO.setIdentity(UserIdentity.USER);
            userMapper.insertUser(userVO);

            return ResponseVO.buildSuccess(userVO);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }

    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        try {
            userMapper.updateUserById(userVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUser(int id) {
        try {
            UserVO userInfo = userMapper.selectUserInfoById(id);
            return ResponseVO.buildSuccess(userInfo);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getAllUsers() {
        try {
            List<UserVO> allUsers = userMapper.selectAllUsers();
            return ResponseVO.buildSuccess(allUsers);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUsersByState(String state) {
        try {
            List<UserVO> users = userMapper.selectUsersByState(state);
            return ResponseVO.buildSuccess(users);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }



    @Override
    public ResponseVO getUserByUsername(String username) {
        try {
            UserVO user = userMapper.selectUserByUsername(username);
            return ResponseVO.buildSuccess(user);
        }catch (Exception e){
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
