package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignMapperTests {
    @Autowired
    private DesignOrderMapper designOrderMapper;



    @Test
    public void updateStatus() {
        Integer result = designOrderMapper.updateByDid(1122226,12);
        System.out.println(result);
    }


}