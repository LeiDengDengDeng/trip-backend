package com.trip.mapper;

import com.trip.vo.FriendVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cong on 2018-12-30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendMapperTest {

    @Autowired
    private FriendMapper friendMapper;

    @Test
    public void insert(){
        FriendVO friendVO=new FriendVO();
        friendVO.setFriendId(1);
        friendVO.setUserId(2);
        friendVO.setFriendName("ccc");
        friendMapper.insertFriend(friendVO);
    }

    @Test
    public void select(){
        System.out.println(friendMapper.selectAll(2));
        System.out.println(friendMapper.selectByName(2,"c"));
    }

}
