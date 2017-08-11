package com.zmb.bi.persist.po;

import java.util.Date;

public class SysParam {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.param_type
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String paramType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.param_key
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String paramKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.param_value
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String paramValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.description
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Date createDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Date updateDt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.id
     *
     * @return the value of sys_param.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.id
     *
     * @param id the value for sys_param.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.param_type
     *
     * @return the value of sys_param.param_type
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.param_type
     *
     * @param paramType the value for sys_param.param_type
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.param_key
     *
     * @return the value of sys_param.param_key
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.param_key
     *
     * @param paramKey the value for sys_param.param_key
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.param_value
     *
     * @return the value of sys_param.param_value
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.param_value
     *
     * @param paramValue the value for sys_param.param_value
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.description
     *
     * @return the value of sys_param.description
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.description
     *
     * @param description the value for sys_param.description
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.status
     *
     * @return the value of sys_param.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.status
     *
     * @param status the value for sys_param.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.create_by
     *
     * @return the value of sys_param.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.create_by
     *
     * @param createBy the value for sys_param.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.create_dt
     *
     * @return the value of sys_param.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.create_dt
     *
     * @param createDt the value for sys_param.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.update_by
     *
     * @return the value of sys_param.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.update_by
     *
     * @param updateBy the value for sys_param.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.update_dt
     *
     * @return the value of sys_param.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.update_dt
     *
     * @param updateDt the value for sys_param.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}