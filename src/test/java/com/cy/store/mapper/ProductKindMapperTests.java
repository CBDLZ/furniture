package com.cy.store.mapper;

import com.cy.store.entity.District;
import com.cy.store.entity.ProductKind;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductKindMapperTests {
    @Autowired
    private ProductKindMapper productKindMapper;

    @Test
    public void findByParent() {
        String parent = "86";
        List<ProductKind> list = productKindMapper.findByParent(parent);
        System.out.println("count=" + list.size());
        for (ProductKind productKind : list) {
            System.out.println(productKind);
        }
    }

    @Test
    public void findNameByCode() {
        String code = "10";
        String name = productKindMapper.findNameByCode(code);
        System.out.println(name);
    }
}