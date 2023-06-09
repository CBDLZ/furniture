package com.cy.store.controller;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.service.IOrderService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行业务
        Order data = orderService.create(aid, cids, uid, username);
        // 返回成功与数据
        return new JsonResult<Order>(OK, CODE, data);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Order>> getOrders(HttpSession session) {
        // 从Session中取出uid和username
        Integer uid = getUidFromSession(session);

        List<Order> data = orderService.findByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<Order>>(OK, CODE, data);
    }

    @RequestMapping("{oid}/update_status")
    public JsonResult<Void> updataStatus(@PathVariable("oid") Integer oid) {
        Integer result = orderService.updateStatus(oid);

        // 返回成功与数据
        return new JsonResult<Void>(OK, CODE);
    }

    @RequestMapping("{oid}/orderItem")
    public JsonResult<List<OrderItem>> findOrderItemByOid(@PathVariable("oid") Integer oid) {
        List<OrderItem> data = orderService.findOrderItemByOid(oid);

        // 返回成功与数据
        return new JsonResult<List<OrderItem>>(OK, CODE, data);
    }

    @RequestMapping("{oid}/order")
    public JsonResult<Order> findOrderByOid(@PathVariable("oid") Integer oid) {
        Order data = orderService.findOrderByOid(oid);

        // 返回成功与数据
        return new JsonResult<Order>(OK, CODE, data);
    }
}