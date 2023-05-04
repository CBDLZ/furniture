package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.entity.Products;
import com.cy.store.service.IProductsService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController extends BaseController {
    @Autowired
    private IProductsService productService;

    @RequestMapping("product_list")
    public JsonResult<List<Products>> getList() {
        List<Products> data = productService.selectAll();
        return new JsonResult<List<Products>>(OK, CODE, data);
    }

    @RequestMapping("filter_product_list")
    public JsonResult<List<Products>> getFilterList(Integer kind1, Integer kind2, Integer priceSort, String color, String material, Integer minPrice, Integer maxPrice, Integer minWidth, Integer maxWidth, Integer minDepth, Integer maxDepth, Integer minHeight, Integer maxHeight) {
        List<Products> data = productService.selectByMultiple(kind1, kind2, priceSort, color, material, minPrice, maxPrice, minWidth, maxWidth, minDepth, maxDepth, minHeight, maxHeight);
        return new JsonResult<List<Products>>(OK, CODE, data);
    }

    @GetMapping("{id}/get_product")
    public JsonResult<Products> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Products data = productService.findById(id);
        System.out.println(data);
        // 返回成功和数据
        return new JsonResult<Products>(OK, CODE, data);
    }

    @RequestMapping("add_product")
    public JsonResult<Void> addProduct(Products products, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        productService.insert(products);
        return new JsonResult<>(OK, CODE);
    }


    @RequestMapping("edit_product")
    public JsonResult<Void> delete(Products products, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        System.out.println(products);
        // 调用业务对象的方法执行业务
        productService.updateById(uid, username, products);
        // 响应成功
        return new JsonResult<Void>(OK, CODE);
    }

    @RequestMapping("{id}/delete")
    public JsonResult<Void> delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return new JsonResult<Void>(OK, CODE);
    }

}