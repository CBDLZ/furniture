package com.cy.store.mapper;


import com.cy.store.entity.DesignOrder;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DesignOrderMapper designOrderMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("eer");
        user.setPassword("312");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("eer");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid() {
        Integer uid = 14;
        String password = "333";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 14;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(17);
        user.setPhone("17858802222");
        user.setEmail("admin@cy.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateAvatarByUid() {
        Integer uid = 19;
        String avatar = "/upload/avatar.png";
        String modifiedUser = "超级管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void insertOrder(){
        DesignOrder designOrder = new DesignOrder();
        designOrder.setDid(1122220);
        designOrder.setUid(22);
        Integer insert = designOrderMapper.insert(designOrder);
        System.out.println(insert);
    }
}
