package com.trip.vo;

import com.trip.enumeration.UserIdentity;
import com.trip.enumeration.UserState;
import lombok.Data;

/**
 * @author fjj
 * @date 2019/1/17 5:27 PM
 */
@Data
public class UserInfoVO {
    // 用户Id
    private Integer id;
    // username相当于微信Id
    private String username;
    // 微信昵称
    private String nickname;
    // 用户真实姓名
    private String name;
    // 性别（1：男   女：0）
    private Integer gender;
    // 微信头像地址
    private String avatar;
    // 上传的认证照片的地址
    private String pictureUrl;
    // 第一次登录小程序的时间,UNIX时间戳
    private Long joinDate;
    // 电话
    private String phone;
    // 用户账号状态
    private UserState state;
    // 用户身份
    private UserIdentity identity;
    // 用户所在地址
    private String address;
    //收藏的景点数
    private Integer favoriteScenicNum;
    //关注数
    private Integer followingNum;
    //粉丝数
    private Integer followerNum;
}
