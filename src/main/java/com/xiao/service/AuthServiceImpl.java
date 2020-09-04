package com.xiao.service;

import com.xiao.Utils.EmptyUtil;
import com.xiao.domian.dao.PartMapper;
import com.xiao.domian.entity.Part;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService{
    @Resource
    private PartMapper partMapper;

    @Override
    public List<Part> getUserPart(String UserId){
        EmptyUtil.isEmpty(UserId,"UserId");
        return partMapper.getUserPart(UserId);
    }

    @Override
    public List<Part> getResource(String PartId) {
        EmptyUtil.isEmpty(PartId,"PartId");
        return partMapper.getResource(PartId);
    }

    @Override
    public List<Part> getUserResource(String UserId ,String Auth) {
        EmptyUtil.isEmpty(UserId,"UserId");
        return partMapper.getUserResource(UserId,Auth);
    }
}
