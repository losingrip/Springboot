package com.xiao;

import com.xiao.Zero.UserType;
import lombok.Data;

@Data
public class doinbi {
    private String name;
    private String pwd;
    private String number;
    private boolean sex;
    private int age;
    private UserType type;


    protected void printsomething() {
        System.out.println("我是你爸爸");
    }
}