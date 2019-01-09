package com.trip.vo;

import com.trip.enumeration.TeamIdentity;
import com.trip.enumeration.UserState;
import lombok.Data;

/**
 * @author fjj
 * @date 2019/1/9 8:49 PM
 */
@Data
public class TeamMemberVO {
    private Integer id;
    // 微信ID
    private String username;
    // 微信昵称
    private String nickname;
    // 用户真实姓名
    private String name;
    // 性别（1：男   女：0）
    private Integer gender;
    // 微信头像地址
    private String avatar;
    // 第一次登录小程序的时间,UNIX时间戳
    private Long joinDate;
    // 电话
    private String phone;
    // 用户账号状态
    private UserState state;
    // 用户所在地址
    private String address;
    //在队伍中的身份（队长，普通成员）
    private TeamIdentity teamIdentity;
}
