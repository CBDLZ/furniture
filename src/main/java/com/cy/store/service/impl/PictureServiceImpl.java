package com.cy.store.service.impl;

import com.cy.store.entity.Picture;
import com.cy.store.mapper.PictureMapper;
import com.cy.store.service.IPictureService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.NotFoundException;
import com.cy.store.util.DeleteFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/** 处理商品数据的业务层实现类 */
@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> selectByProductId(Integer productId) {
        List<Picture> list = pictureMapper.selectByProductId(productId);
        for (Picture picture : list) {

        }
        return list;
    }

    @Override
    public Integer insert(Picture picture) {
        int result = pictureMapper.insert(picture);
        if (result == 0){
            throw new InsertException("图片插入失败");
        }
        return result;
    }


    @Override
    public Boolean deleteFolder(List<String> parent) {
        DeleteFile deleteFile = new DeleteFile();
        Boolean result = null;

        result = deleteFile.delete(parent);

        return result;
    }

    @Override
    public List<Picture> findPic(Integer productId, Integer kind) {
        List<Picture> result = pictureMapper.selectByProductIdAndKind(productId,kind);
        if (result == null){
            throw new NotFoundException("图片未找到");

        }
        return result;
    }

    @Override
    public Integer deletePicDatabase(Integer productId) {
        Integer result = pictureMapper.deleteByProductId(productId);
        return result;
    }
}