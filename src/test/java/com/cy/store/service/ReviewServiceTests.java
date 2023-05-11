package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceTests {
    @Autowired
    private IReviewService iReviewService;


    @Test
    public void percent() {
       Integer percent = iReviewService.findReviewPercent(1,5);
        System.out.println(percent);
    }

}
