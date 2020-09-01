package com.xiao.domian.dao;

import com.xiao.domian.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 获取用户信息
     * @param user 用户对象
     * @return 用户对象
     */
    User getUserInfo(User user);
    /**
     * 获取用户列表信息
     * @param user 用户对象
     * @return 用户列表
     */
    List<User> getUserInfoList(User user);
    /**
     * 添加用户信息
     * @param user 用户对象
     * @return 用户id
     */
    String addUserInfo(User user);

    /**
     * 查询用户角色
     * @return user
     */
    List<User> getUserPart();
}
