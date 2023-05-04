package com.cy.store.service.impl;

import com.cy.store.entity.Products;
import com.cy.store.mapper.ProductsMapper;
import com.cy.store.service.IProductsService;
import com.cy.store.service.ex.DeleteException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/** 处理商品数据的业务层实现类 */
@Service
public class ProductsServiceImpl implements IProductsService {
    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public List<Products> selectAll() {
        List<Products> list = productsMapper.selectAll();
        for (Products products : list) {
            products.setPriority(null);
            products.setCreatedUser(null);
            products.setCreatedTime(null);
            products.setModifiedUser(null);
            products.setModifiedTime(null);
        }
        return list;
    }

    @Override
    public Products findById(Integer id) {
        // 根据参数id调用私有方法执行查询，获取商品数据
        Products products = productsMapper.selectByPrimaryKey(id);
        // 判断查询结果是否为null
        if (products == null) {
            // 是：抛出ProductNotFoundException
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        // 将查询结果中的部分属性设置为null
        products.setPriority(null);
        products.setCreatedUser(null);
        products.setCreatedTime(null);
        products.setModifiedUser(null);
        products.setModifiedTime(null);
        // 返回查询结果
        return products;
    }

    @Override
    public void insert(Products products){
        Date now = new Date();
        products.setCreatedTime(now);
        Integer rows = productsMapper.insert(products);
        if (rows != 1) {
            // 是：插入数据时出现某种错误，则抛出InsertException异常
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }



    @Override
    public void updateById(Integer uid, String username, Products products) {


        if (products == null){
            throw new ProductNotFoundException("商品空，编辑失败");
        }else {
            products.setModifiedUser(username);
            products.setModifiedTime(new Date());
            productsMapper.updateByPrimaryKey(products);
        }

    }

    @Override
    public void delete(Integer id) {
        Integer row = productsMapper.deleteByPrimaryKey(id);
        if (row !=1 ){
            throw new DeleteException("删除错误");
        }
    }

    @Override
    public List<Products> selectByMultiple(Integer kind1, Integer kind2, Integer priceSort, String color, String material, Integer minPrice, Integer maxPrice, Integer minWidth, Integer maxWidth, Integer minDepth, Integer maxDepth, Integer minHeight, Integer maxHeight) {
        List<Products> result = productsMapper.selectByMultiple(kind1, kind2, priceSort, color, material, minPrice, maxPrice, minWidth,maxWidth, minDepth, maxDepth, minHeight, maxHeight);

        return result;
    }
}
