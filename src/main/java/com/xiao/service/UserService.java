package com.xiao.service;

import com.xiao.annotation.Auth;
import com.xiao.domian.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 获取用户信息
     * @param user 用户对象
     * @return 用户对象
     */
    User getUserInfo(User user) throws Exception;

    /**
     * 添加用户信息
     * @param user 用户对象
     * @return 用户id
     */
    String addUserInfo(User user);

    /**
     * 获取用户列表信息
     * @param user 用户对象
     * @return 用户列表
     */
    List<User> getUserInfoList(User user);

}
