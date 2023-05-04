package com.cy.store.service;

import com.cy.store.entity.Picture;
import com.cy.store.entity.Products;

import java.util.List;

public interface IPictureService {
    /**
     * 通过productId查找图片
     * @param productId
     * @return
     */
//    List<Picture> selectByPicId(Integer productId);

    /**
     * 添加商品图片
     * @param picture
     * @return
     */
    Integer insert(Picture picture);

    /**
     * 选择所有图片路径
     * @return
     */
    List<Picture> selectByProductId(Integer productId);

    /**
     * 编辑和发送图片前删除旧图片
     * @param parent
     * @return
     */
    Boolean deleteFolder(List<String> parent);

    /**
     * 根据商品id和种类找图片
     * @param productId
     * @param kind
     * @return
     */
    List<Picture> findPic(Integer productId, Integer kind);

    /**
     * 通过产品ID删除图片
     * @param productId
     * @return
     */
    Integer deletePicDatabase(Integer productId);
}