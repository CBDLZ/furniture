package com.cy.store.service.impl;

import com.cy.store.entity.DesignOrder;
import com.cy.store.mapper.DesignOrderMapper;
import com.cy.store.service.IDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DesignImpl implements IDesignService {
    @Autowired
    private DesignOrderMapper designOrderMapper;

    @Override
    public void addNewDesign(DesignOrder designOrder) {
        Date now = new Date();
        designOrder.setCreatedTime(now);
        designOrder.setStatus(0);
        designOrderMapper.insert(designOrder);
    }
}
