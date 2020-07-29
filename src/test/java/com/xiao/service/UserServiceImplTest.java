package com.xiao.service;

import com.xiao.domian.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    @Transactional
    @Rollback
    public void testAll() throws Exception {
        User user = new User();
        user.setUserId("12");
        User result = userService.getUserInfo(user);
        if (result==null){
            throw new Exception("ds");
        }
        User u = new User();
        List<User> list = userService.getUserInfoList(u);
        list.forEach(x ->{
            System.out.println(x.toString());
        });
    }
}