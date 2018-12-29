package com.trip.mapper;

import com.trip.vo.FriendVO;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * Created by cong on 2018-12-29.
 */
@Mapper
public interface FriendMapper {

    public void insertFriend(FriendVO friendVO);

}
