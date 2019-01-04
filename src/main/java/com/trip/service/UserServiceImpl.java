package com.trip.service;

import com.trip.enumeration.UserIdentity;
import com.trip.enumeration.UserState;
import com.trip.mapper.UserMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author fjj
 * @date 2019/1/2 下午11:41
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;



    @Override
    public ResponseVO addUser(UserVO userVO) {
        UserVO userVO1 = userMapper.selectUserByAvatar(userVO.getAvatar());
        if(userVO1 != null){
            return ResponseVO.buildSuccess(userVO1);
        }
        userVO.setJoinDate(System.currentTimeMillis()/1000);
        userVO.setState(UserState.UNCHECKED);
        userVO.setIdentity(UserIdentity.USER);
        userMapper.insertUser(userVO);

        return ResponseVO.buildSuccess(userVO);

    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        userMapper.updateUserById(userVO);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO getUser(int id) {
        UserVO userInfo = userMapper.selectUserInfoById(id);
        return ResponseVO.buildSuccess(userInfo);
    }

    @Override
    public ResponseVO getAllUsers() {
        List<UserVO> allUsers = userMapper.selectAllUsers();
        return ResponseVO.buildSuccess(allUsers);
    }

    @Override
    public ResponseVO getUsersByState(String state) {
        List<UserVO> users = userMapper.selectUsersByState(state);
        return ResponseVO.buildSuccess(users);
    }



    @Override
    public ResponseVO getUserByUsername(String username) {
        UserVO user = userMapper.selectUserByUsername(username);
        return ResponseVO.buildSuccess(user);
    }
}
