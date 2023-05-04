package com.cy.store.service;

import com.cy.store.entity.District;
import com.cy.store.entity.ProductKind;

import java.util.List;

public interface IProductKindService {
    List<ProductKind> getByParent(String parent);
    String getNameByCode(String code);
}
