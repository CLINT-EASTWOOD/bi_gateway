package com.zmb.bi.dao;

import com.zmb.bi.persist.po.TaskFlow;

public interface TaskFlowDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    int insert(TaskFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    int insertSelective(TaskFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    TaskFlow selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    int updateByPrimaryKeySelective(TaskFlow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task_flow
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    int updateByPrimaryKey(TaskFlow record);
}