package com.cy.store.controller;

import com.cy.store.entity.ProductKind;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.IProductKindService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("product_kind")
@RestController
public class ProductKindController extends BaseController {
    @Autowired
    private IProductKindService productKindService;


    @GetMapping({"", "/"})
    public JsonResult<List<ProductKind>> getByParent(String parent) {
        List<ProductKind> data = productKindService.getByParent(parent);
        return new JsonResult<>(OK, CODE, data);
    }
}