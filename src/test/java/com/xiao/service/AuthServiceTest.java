package com.xiao.service;

import com.xiao.domian.entity.Part;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTest {

    @Autowired
    AuthService authService;

    @Test
    @Transactional
    @Rollback
    public void testAll() throws Exception{
       List<Part> parts = authService.getUserPart("12");
       System.out.println(parts);

       List<Part> partList = authService.getResource("1");
       System.out.println(partList);

       List<Part> userResource = authService.getUserResource("12");
        System.out.println(userResource);
    }
}