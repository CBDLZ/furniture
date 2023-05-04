package com.cy.store.mapper;



import com.cy.store.entity.Picture;

import java.util.List;

public interface PictureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated Thu Apr 27 15:49:46 CST 2023
     */
    int deleteByPrimaryKey(Integer picId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated Thu Apr 27 15:49:46 CST 2023
     */
    int insert(Picture record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated Thu Apr 27 15:49:46 CST 2023
     */
    Picture selectByPrimaryKey(Integer picId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated Thu Apr 27 15:49:46 CST 2023
     */
    List<Picture> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pic
     *
     * @mbggenerated Thu Apr 27 15:49:46 CST 2023
     */
    int updateByPrimaryKey(Picture record);

    /**
     * 通过productId查找产品图片
     * @return
     */
    List<Picture> selectByProductId(Integer productId);

    /**
     * 通过产品id和种类选择图片
     * @param productId
     * @param kind
     * @return
     */
    List<Picture> selectByProductIdAndKind(Integer productId, Integer kind);

    /**
     * 通过产品id删除
     * @param productId
     * @return
     */

    int deleteByProductId(Integer productId);

}