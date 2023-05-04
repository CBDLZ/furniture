package com.cy.store.service;

import com.cy.store.entity.DesignOrder;

public interface IDesignService {
    /**
     * 添加设计请求
     * @param designOrder
     */
    void addNewDesign(DesignOrder designOrder);
}
