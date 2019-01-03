package com.trip.mapper;

import com.trip.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fjj
 * @date 2019/1/2 下午11:51
 */
@Mapper
public interface UserMapper {
    int insertUser(UserVO user);

    int updateUserById(UserVO userVO);

    UserVO selectUserInfoById(int id);

    List<UserVO> selectAllUsers();

    List<UserVO> selectUsersByState(String state);

    UserVO selectUserByUsername(String username);

    UserVO selectUserByAvatar(String avatar);
}
