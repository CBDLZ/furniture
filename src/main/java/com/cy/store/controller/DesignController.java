package com.cy.store.controller;


import com.cy.store.entity.Address;
import com.cy.store.entity.DesignOrder;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDesignService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("design")
public class DesignController extends BaseController{
    @Autowired
    private IDesignService designService;

    @RequestMapping("new_design")
    public JsonResult<Void> addNewDesign(DesignOrder designOrder, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
//        String username = getUsernameFromSession(session);
        designOrder.setUid(uid);

        // 调用业务对象的方法执行业务
        designService.addNewDesign(designOrder);
        // 响应成功
        return new JsonResult<Void>(OK, CODE);
    }


}
