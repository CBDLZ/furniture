package com.cy.store.service;

import com.cy.store.entity.Products;
import org.apache.ibatis.javassist.runtime.Inner;

import java.util.List;

/** 处理商品数据的业务层接口 */
public interface IProductsService {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Products> selectAll();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Products findById(Integer id);

    void insert(Products products);


    void updateById(Integer uid, String username, Products products);

    void delete(Integer id);

    /**
     * 多条件筛选
     * @param kind1
     * @param kind2
     * @param color
     * @param material
     * @param minPrice
     * @param maxPrice
     * @param minWidth
     * @param maxWidth
     * @param minDepth
     * @param maxDepth
     * @param minHeight
     * @param maxHeight
     * @return
     */
    List<Products> selectByMultiple(Integer kind1, Integer kind2, Integer priceSort, String color, String material, Integer minPrice, Integer maxPrice, Integer minWidth, Integer maxWidth, Integer minDepth, Integer maxDepth, Integer minHeight, Integer maxHeight);
}