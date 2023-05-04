package com.cy.store.service;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

import java.util.List;

/** 处理订单和订单数据的业务层接口 */
public interface IOrderService {
    /**
     * 创建订单
     * @param aid 收货地址的id
     * @param cids 即将购买的商品数据在购物车表中的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 成功创建的订单数据
     */

    Order create(Integer aid, Integer[] cids, Integer uid, String username);

    /**
     * 通过uid找订单
     * @param uid
     * @return
     */
    List<Order> findByUid(Integer uid);

    /**
     * 更新订单状态
     * @param uid
     * @return
     */

    Integer updateStatus(Integer uid);

    /**
     * 查找订单的商品
     * @param oid
     * @return
     */
    List<OrderItem> findOrderItemByOid(Integer oid);

    /**
     * 查找订单
     * @param oid
     * @return
     */
    Order findOrderByOid(Integer oid);

}