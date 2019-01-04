package com.trip.service;

import com.trip.enumeration.UserIdentity;
import com.trip.enumeration.UserState;
import com.trip.mapper.UserMapper;
import com.trip.vo.ResponseVO;
import com.trip.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

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
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }

    }

    @Override
    public ResponseVO updateUser(UserVO userVO) {
        try {
            userMapper.updateUserById(userVO);
            return ResponseVO.buildSuccess();
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUser(int id) {
        try {
            UserVO userInfo = userMapper.selectUserInfoById(id);
            return ResponseVO.buildSuccess(userInfo);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getAllUsers() {
        try {
            List<UserVO> allUsers = userMapper.selectAllUsers();
            return ResponseVO.buildSuccess(allUsers);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }
    }

    @Override
    public ResponseVO getUsersByState(String state) {
        try {
            List<UserVO> users = userMapper.selectUsersByState(state);
            return ResponseVO.buildSuccess(users);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }
    }



    @Override
    public ResponseVO getUserByUsername(String username) {
        try {
            UserVO user = userMapper.selectUserByUsername(username);
            return ResponseVO.buildSuccess(user);
        }catch (Exception e){
            LOGGER.info(e.getMessage());
            return ResponseVO.buildFailure(e.toString());
        }
    }
}
