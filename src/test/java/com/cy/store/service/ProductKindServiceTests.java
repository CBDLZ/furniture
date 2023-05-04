package com.cy.store.service;


import com.cy.store.entity.District;
import com.cy.store.entity.ProductKind;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductKindServiceTests {
    @Autowired
    private IProductKindService productKindService;

    @Test
    public void getByParent() {
        try {
            String parent = "86";
            List<ProductKind> list = productKindService.getByParent(parent);
            System.out.println("count=" + list.size());
            for (ProductKind item : list) {
                System.out.println(item);
            }
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getNameByCode() {
        try {
            String code = "9";
            String result = productKindService.getNameByCode(code);
            System.out.println(result);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}