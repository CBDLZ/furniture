package com.cy.store.service;

import com.cy.store.entity.DesignOrder;

import java.util.List;

public interface IDesignService {
    /**
     * 添加设计请求
     * @param designOrder
     */
    void addNewDesign(DesignOrder designOrder);

    /**
     * 选择未被接受的订单
     * @return
     */
    List<DesignOrder> selectNotTaken();

    /**
     * 接单
     * @param did
     * @param designerId
     * @return
     */
    Integer takeOrder(Integer did, Integer designerId);

    /**
     *  选择设计师接受的订单
     * @param designerId
     * @return
     */
    List<DesignOrder> selectTaken(Integer designerId);

    /**
     * 选择该用户的设计请求
     * @param uid
     * @return
     */
    List<DesignOrder> selectByUid(Integer uid);
}
