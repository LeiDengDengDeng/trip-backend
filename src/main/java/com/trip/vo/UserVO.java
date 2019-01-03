package com.trip.vo;

import com.trip.enumeration.UserIdentity;
import com.trip.enumeration.UserState;

import java.util.Date;

/**
 * @author fjj
 * @date 2019/1/2 下午11:42
 */
public class UserVO {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Long joinDate) {
        this.joinDate = joinDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(UserIdentity identity) {
        this.identity = identity;
    }
}
