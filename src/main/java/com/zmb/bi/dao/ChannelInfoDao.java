package com.zmb.bi.dao;

import java.util.List;

import com.zmb.bi.persist.po.ChannelInfo;

public interface ChannelInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    int insert(ChannelInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    int insertSelective(ChannelInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    ChannelInfo selectByPrimaryKey(Integer id);

    /**
	 * 全部渠道信息查询
	 * @param		:	
	 * @return		:	List<ChannelInfo>		全部渠道信息列表
	 * @comments	:	
	 */
    List<ChannelInfo> selectAll();
    
    /**
	 * 全部可用渠道信息查询
	 * @param		:	
	 * @return		:	List<ChannelInfo>		全部可用渠道信息列表
	 * @comments	:	
	 */
    List<ChannelInfo> selectAvailableList();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    int updateByPrimaryKeySelective(ChannelInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table channel_info
     *
     * @mbg.generated Wed Aug 02 18:36:40 CST 2017
     */
    int updateByPrimaryKey(ChannelInfo record);
}