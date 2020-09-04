package com.xiao.service;

import com.xiao.domian.entity.Part;

import java.util.List;

public interface AuthService {

    List<Part> getUserPart(String UserId);

    List<Part> getResource(String PartId);

    List<Part> getUserResource(String UserId,String Auth);
}
