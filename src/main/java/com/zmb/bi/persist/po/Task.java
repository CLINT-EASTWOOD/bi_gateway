package com.zmb.bi.persist.po;

import java.util.Date;

public class Task {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.id
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_code
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private String taskCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_name
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private String taskName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.date
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Date date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.time
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.loop
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Integer loop;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.exec_status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Integer execStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.create_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.create_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Date createDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.update_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.update_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    private Date updateDt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.id
     *
     * @return the value of task.id
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.id
     *
     * @param id the value for task.id
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_code
     *
     * @return the value of task.task_code
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public String getTaskCode() {
        return taskCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_code
     *
     * @param taskCode the value for task.task_code
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode == null ? null : taskCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_name
     *
     * @return the value of task.task_name
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_name
     *
     * @param taskName the value for task.task_name
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.date
     *
     * @return the value of task.date
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.date
     *
     * @param date the value for task.date
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.time
     *
     * @return the value of task.time
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.time
     *
     * @param time the value for task.time
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.loop
     *
     * @return the value of task.loop
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Integer getLoop() {
        return loop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.loop
     *
     * @param loop the value for task.loop
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setLoop(Integer loop) {
        this.loop = loop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.exec_status
     *
     * @return the value of task.exec_status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Integer getExecStatus() {
        return execStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.exec_status
     *
     * @param execStatus the value for task.exec_status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setExecStatus(Integer execStatus) {
        this.execStatus = execStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.status
     *
     * @return the value of task.status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.status
     *
     * @param status the value for task.status
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.create_by
     *
     * @return the value of task.create_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.create_by
     *
     * @param createBy the value for task.create_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.create_dt
     *
     * @return the value of task.create_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.create_dt
     *
     * @param createDt the value for task.create_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.update_by
     *
     * @return the value of task.update_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.update_by
     *
     * @param updateBy the value for task.update_by
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.update_dt
     *
     * @return the value of task.update_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.update_dt
     *
     * @param updateDt the value for task.update_dt
     *
     * @mbg.generated Mon Jun 19 16:06:15 CST 2017
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}