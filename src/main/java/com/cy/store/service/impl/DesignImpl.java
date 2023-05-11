package com.cy.store.service.impl;

import com.cy.store.entity.DesignOrder;
import com.cy.store.mapper.DesignOrderMapper;
import com.cy.store.service.IDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<DesignOrder> selectNotTaken() {
        List<DesignOrder> lists = designOrderMapper.selectNotTaken();
        return lists;
    }

    @Override
    public Integer takeOrder(Integer did, Integer designerId) {
        Integer result = designOrderMapper.updateByDid(did, designerId);
        return result;
    }

    @Override
    public List<DesignOrder> selectTaken(Integer designerId) {
        List<DesignOrder> results = designOrderMapper.selectTaken(designerId);
        return results;
    }

    @Override
    public List<DesignOrder> selectByUid(Integer uid) {
        List<DesignOrder> results = designOrderMapper.selectByUid(uid);

        return results;
    }
}
