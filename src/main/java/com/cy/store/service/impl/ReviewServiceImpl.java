package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Review;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.mapper.ReviewMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.IReviewService;
import com.cy.store.service.ex.*;
import com.cy.store.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    private ReviewMapper reviewMapper;




    @Override
    public Integer insert(Review review) {
        Integer rows = reviewMapper.insert(review);
        return rows;
    }

    @Override
    public List<Review> selectByPid(Integer pid) {
        List<Review> results = reviewMapper.selectByPid(pid);
        return results;
    }

    @Override
    public Float findAvgScore(Integer pid) {
        Float avgScore = reviewMapper.findAvgScore(pid);
        return avgScore;
    }

    @Override
    public Integer findReviewPercent(Integer pid,Integer score) {
        Float countReviewByPidAndScore = Float.valueOf(reviewMapper.CountReviewByPidAndScore(pid, score));
        Float countReviewByPid = Float.valueOf(reviewMapper.CountReviewByPid(pid));
        System.out.println("countReviewByPidAndScore"+countReviewByPidAndScore+" "+"countReviewByPid+countReviewByPid"+countReviewByPid);
        Integer percent = (int) ((countReviewByPidAndScore/countReviewByPid)*100);
        return percent;
    }

    @Override
    public List<ReviewVO> findVOByPid(Integer pid) {
        List<ReviewVO> lists = reviewMapper.findVOByPid(pid);
        return lists;
    }
}