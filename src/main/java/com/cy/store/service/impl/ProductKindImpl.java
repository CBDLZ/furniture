package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.entity.ProductKind;
import com.cy.store.mapper.ProductKindMapper;
import com.cy.store.service.IProductKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductKindImpl implements IProductKindService {

    @Autowired
    private ProductKindMapper productKindMapper;
    @Override
    public List<ProductKind> getByParent(String parent) {
        List<ProductKind> list = productKindMapper.findByParent(parent);

//        减少冗余数据
        for (ProductKind productKind : list) {
            productKind.setKid(null);
            productKind.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return productKindMapper.findNameByCode(code);
    }
}
