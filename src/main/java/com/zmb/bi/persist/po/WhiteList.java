package com.zmb.bi.persist.po;

import java.util.Date;

public class WhiteList {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.channel_code
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Integer channelCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.source_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String sourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.target_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String targetUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Date createDt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private String updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column white_list.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    private Date updateDt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.id
     *
     * @return the value of white_list.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.id
     *
     * @param id the value for white_list.id
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.channel_code
     *
     * @return the value of white_list.channel_code
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Integer getChannelCode() {
        return channelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.channel_code
     *
     * @param channelCode the value for white_list.channel_code
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setChannelCode(Integer channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.source_url
     *
     * @return the value of white_list.source_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.source_url
     *
     * @param sourceUrl the value for white_list.source_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.target_url
     *
     * @return the value of white_list.target_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.target_url
     *
     * @param targetUrl the value for white_list.target_url
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl == null ? null : targetUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.status
     *
     * @return the value of white_list.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.status
     *
     * @param status the value for white_list.status
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.create_by
     *
     * @return the value of white_list.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.create_by
     *
     * @param createBy the value for white_list.create_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.create_dt
     *
     * @return the value of white_list.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Date getCreateDt() {
        return createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.create_dt
     *
     * @param createDt the value for white_list.create_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.update_by
     *
     * @return the value of white_list.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.update_by
     *
     * @param updateBy the value for white_list.update_by
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column white_list.update_dt
     *
     * @return the value of white_list.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public Date getUpdateDt() {
        return updateDt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column white_list.update_dt
     *
     * @param updateDt the value for white_list.update_dt
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}