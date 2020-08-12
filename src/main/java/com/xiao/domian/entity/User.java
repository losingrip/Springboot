package com.xiao.domian.entity;

import lombok.Data;

import java.net.DatagramPacket;

/**
 * 用户个人信息 的摘要说明。
 *
 * @date: 2020/3/4 19:42:11.
 *
 */

@Data
public class User {

    //用户id.
    private String userId;
    //用户电话.
    private String userNumber;
    //密码.
    private String userPwd;
    //性别.
    private boolean userSex;
    //姓名.
    private String userName;
    //角色.
    private String userPart;
    //类型.
    private String userType;
    //生日.
    private String userBirthday;
    //地址.
    private String userAddress;
    //注册日期.
    private String userSignDate;
    //头像.
    private String userHeadImg;
    //爱好.
    private String userLike;
    //备注.
    private String userStr;
    //备用.
    private String strString;
    //备用.
    private int intInteger;

}



