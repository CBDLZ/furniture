package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.Review;
import com.cy.store.entity.User;
import com.cy.store.service.IReviewService;
import com.cy.store.service.IUserService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("review")
public class ReviewController extends BaseController{
    @Autowired
    private IReviewService reviewService;



    @RequestMapping("add")
    public JsonResult<Void> addReview(Integer pid, Integer oid, Byte score, String review, HttpSession session) {
        Review p_review = new Review();
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        p_review.setPid(pid);
        p_review.setOid(oid);
        p_review.setScore(score);
        p_review.setReview(review);
        p_review.setUid(uid);
        p_review.setCreatedUser(username);
        p_review.setCreatedTime(new Date());
        Integer rows = reviewService.insert(p_review);


        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<Void>(OK, CODE);
    }


    @RequestMapping({"","/"})
    public JsonResult<List<Review>> findReview(Integer pid) {
        List<Review> data = reviewService.selectByPid(pid);

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<List<Review>>(OK, CODE, data);
    }

    @RequestMapping("avg/{pid}")
    public JsonResult<Float> findAvgScore(@PathVariable("pid") Integer pid) {
        Float data = reviewService.findAvgScore(pid);

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<Float>(OK, CODE, data);
    }

    @RequestMapping("get_percent/{pid}/{score}")
    public JsonResult<Integer> getPercent(@PathVariable("pid") Integer pid, @PathVariable("score") Integer score) {
        Integer data = reviewService.findReviewPercent(pid, score);
        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<Integer>(OK, CODE, data);
    }

    @RequestMapping("get_review/{pid}")
    public JsonResult<List<ReviewVO>> getReviewByPid(@PathVariable("pid") Integer pid) {
        List<ReviewVO> data = reviewService.findVOByPid(pid);
        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<List<ReviewVO>>(OK, CODE, data);
    }
}
