package com.xiao.domian.entity;

import lombok.Data;

import java.util.List;

@Data
public class Part {
    //角色id
    private String partId;
    //角色名称
    private String partName;
    //用户们
    private List<User> users;
    //资源们
    private List<Resource> resources;
}
