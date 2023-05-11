package com.cy.store.mapper;

import com.cy.store.entity.DesignOrder;
import java.util.List;

public interface DesignOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_design_order
     *
     * @mbggenerated Wed Apr 19 22:48:44 CST 2023
     */
    int deleteByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_design_order
     *
     * @mbggenerated Wed Apr 19 22:48:44 CST 2023
     */
    int insert(DesignOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_design_order
     *
     * @mbggenerated Wed Apr 19 22:48:44 CST 2023
     */
    DesignOrder selectByPrimaryKey(Integer did);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_design_order
     *
     * @mbggenerated Wed Apr 19 22:48:44 CST 2023
     */
    List<DesignOrder> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_design_order
     *
     * @mbggenerated Wed Apr 19 22:48:44 CST 2023
     */
    int updateByPrimaryKey(DesignOrder record);

    /**
     * 选择未被接受的订单
     * @return
     */
    List<DesignOrder> selectNotTaken();

    /**
     * 更新订单状态
     * @param did
     * @param designerId
     * @return
     */
    Integer updateByDid(Integer did, Integer designerId);

    /**
     * 选择设计师已接受的订单
     * @return
     */
    List<DesignOrder> selectTaken(Integer designer_id);

    List<DesignOrder> selectByUid(Integer uid);
}