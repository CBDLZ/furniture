package com.cy.store.service;

import com.cy.store.entity.Review;
import com.cy.store.vo.ReviewVO;

import java.util.List;

public interface IReviewService {
    /**
     * 插入评论
     * @param review
     * @return
     */
    Integer insert(Review review);

    List<Review> selectByPid(Integer pid);

    Float findAvgScore(Integer pid);

    Integer findReviewPercent(Integer pid, Integer score);

    List<ReviewVO> findVOByPid(Integer pid);
}
