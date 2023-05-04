package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(18);
        address.setName("admin");
        address.setPhone("17858802974");
        address.setAddress("雁塔区小寨赛格");
        Integer rows = addressMapper.insert(address);
        System.out.println("rows=" + rows);
    }

    @Test
    public void countByUid() {
        Integer uid = 18;
        Integer count = addressMapper.countByUid(uid);
        System.out.println("count=" + count);
    }

    @Test
    public void findByUid() {
        Integer uid = 20;
        List<Address> list = addressMapper.findByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void updateNonDefaultByUid() {
        Integer uid = 18;
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateDefaultByAid() {
        Integer aid = 8;
        String modifiedUser = "管理员";
        Date modifiedTime = new Date();
        Integer rows = addressMapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByAid() {
        Integer aid = 8;
        Address result = addressMapper.findByAid(aid);
        System.out.println(result);
    }

    @Test
    public void deleteByAid() {
        Integer aid = 8;
        Integer rows = addressMapper.deleteByAid(aid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findLastModified() {
        Integer uid = 20;
        Address result = addressMapper.findLastModified(uid);
        System.out.println(result);
    }

    @Test
    public void editTest() {
        Address address = new Address();
        address.setAid(14);
        address.setName("xxwwww");
        address.setProvinceName("xwwwx");
        address.setProvinceCode("xwwwx");
        address.setModifiedTime(new Date());

//        Integer result = addressMapper.edit("1","d", "dd","user", "dd", "ffaf", "fadsf", "fadsf", "123", "ff", "122", "122", "dddd", "afaf", String.valueOf(new Date()));
        Integer result = addressMapper.edit(address);
        System.out.println(result);
    }
}