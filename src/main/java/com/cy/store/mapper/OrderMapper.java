package com.cy.store.mapper;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;

import java.util.Date;
import java.util.List;

/** 处理订单及订单商品数据的持久层接口 */
public interface OrderMapper {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /**
     * 查找用户所有购买订单
     * @param uid
     * @return
     */
    List<Order> selectByUid(Integer uid);

    /**
     * 更新订单状态
     * @param oid
     * @param modifiedTime
     * @return
     */
    Integer updateStatus(Integer oid, Date modifiedTime);

    /**
     * 查找订单中的商品
     * @param oid
     * @return
     */
    List<OrderItem> selectOrderItemByOid(Integer oid);

    /**
     * 通过oid找订单
     * @param oid
     * @return
     */
    Order selectOrderByOid(Integer oid);
}