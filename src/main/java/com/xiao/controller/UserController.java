package com.xiao.controller;


import com.xiao.Utils.EmptyUtil;
import com.xiao.annotation.Auth;
import com.xiao.domian.entity.User;
import com.xiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUser")
    public User getUserInfo(String UserId, String UserNumber) throws Exception {
        EmptyUtil.isEmpty(UserId, "UserId");
        EmptyUtil.isEmpty(UserNumber, "UserNumber");
        User user = new User();
        user.setUserId(UserId);
        user.setUserNumber(UserNumber);
        return userService.getUserInfo(user);
    }

    @PostMapping("/addUser")
    @Auth(auth = "hello")
    public String addUserInfo(User user) throws Exception {
        return userService.addUserInfo(user);
    }

    @GetMapping("/hello")
    @Auth(auth = "hello")
    public String hellotest(String UserId) {
        return "hallo nmsl";
    }
}
