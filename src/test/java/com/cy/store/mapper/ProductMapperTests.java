package com.cy.store.mapper;

import com.cy.store.entity.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
        @Autowired
        private ProductsMapper productMapper;

        @Test
        public void findHotList() {
            List<Products> list = productMapper.selectAll();
            System.out.println("count=" + list.size());
            for (Products item : list) {
                System.out.println(item);
            }
        }


    @Test
    public void findByMultiple() {
        List<Products> list = productMapper.selectByMultiple(1,6, 1,"白色", "木材", 0, 10000,0,100,0,200,0,300);
        System.out.println("count=" + list.size());
        for (Products item : list) {
            System.out.println(item);
        }
    }
}

