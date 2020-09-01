package com.xiao.service;

import com.xiao.domian.dao.UserMapper;
import com.xiao.domian.entity.User;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取用户信息
     * @param user 用户对象
     * @return 用户对象
     */
    @Override
    public User getUserInfo(User user) throws Exception {
        if (!StringHelper.isNullOrEmptyString(user.getUserId())||
                !StringHelper.isNullOrEmptyString(user.getUserNumber())){
            User resultUset = userMapper.getUserInfo(user);
            if (resultUset!=null){
                return resultUset;
            }else {
                throw new Exception("没有该用户");
            }
        }else {
            throw new Exception("用户id或者用户号码为空");
        }
    }

    /**
     * 添加用户信息
     * @param user 用户对象
     * @return 用户id
     */
    @Override
    public String addUserInfo(User user) {
        return null;
    }


    /**
     * 获取用户列表信息
     * @param user 用户对象
     * @return 用户列表
     */
    @Override
    public List<User> getUserInfoList(User user) {
        return userMapper.getUserInfoList(user);
    }

    /**
     * 查询用户角色
     * @return user
     */
    @Override
    public List<User> getUserPart() {
        return userMapper.getUserPart();
    }
}
