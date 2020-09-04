package com.xiao.domian.dao;

import com.xiao.domian.entity.Part;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PartMapper {
    /**
     * 通过用户id查询角色
     * @param UserId 用户id
     * @return 角色
     */
    List<Part> getUserPart(String UserId);

    /**
     * 通过角色id查询资源
     * @param PartId 用户id
     * @return 角色
     */
    List<Part> getResource(String PartId);

    /**
     *
     * @param UserId
     * @return
     */
    List<Part> getUserResource(String UserId,String Auth);
}
