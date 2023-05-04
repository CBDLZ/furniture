package com.cy.store.service;

import com.cy.store.entity.Products;

import com.cy.store.service.ex.ServiceException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsServiceTests {
    @Autowired
    private IProductsService iProductsService;

    @Test
    public void insertProducts() {
        try {
            Products products = new Products();
            products.setId(99);
            products.setTitle("www");
            iProductsService.insert(products);
            System.out.println("添加成功！");
        } catch (ServiceException e) {
            System.out.println("注册失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

}
