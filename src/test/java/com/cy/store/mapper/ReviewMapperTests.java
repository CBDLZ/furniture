package com.cy.store.mapper;


import com.cy.store.entity.DesignOrder;
import com.cy.store.entity.User;
import com.cy.store.vo.ReviewVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReviewMapperTests {
    @Autowired
    private ReviewMapper reviewMapper;




    @Test
    public void findAvg(){
        Float score = reviewMapper.findAvgScore(1);

        System.out.println((int) (score+0.5f));
    }

    @Test
    public void findVOByPid(){
        List<ReviewVO> reviewVOS = reviewMapper.findVOByPid(1);

        System.out.println(reviewVOS);
    }
}
