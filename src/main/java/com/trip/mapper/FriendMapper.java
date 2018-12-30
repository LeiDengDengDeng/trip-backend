package com.trip.mapper;

import com.trip.vo.FriendVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * Created by cong on 2018-12-29.
 */
@Mapper
public interface FriendMapper {

    public void insertFriend(FriendVO friendVO);

    public Integer select(FriendVO friendVO);

    public List<Integer> selectAll(Integer userId);

    public List<Integer> selectByName(@Param("userId")Integer userId,@Param("friendName")String friendName);

}
