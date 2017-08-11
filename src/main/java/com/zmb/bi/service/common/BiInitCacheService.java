package com.zmb.bi.service.common;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.dao.ChannelInfoDao;
import com.zmb.bi.dao.SysParamDao;
import com.zmb.bi.dao.WhiteListDao;
import com.zmb.bi.persist.po.ChannelInfo;
import com.zmb.bi.persist.po.SysParam;
import com.zmb.bi.persist.po.WhiteList;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @version		:	1.0
 * @description :	行业网关系统缓存服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-16 09:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class BiInitCacheService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BiInitCacheService.class);

	@Autowired
	private ChannelInfoDao channelInfoDao;
	@Autowired
	private SysParamDao sysParamDao;
	@Autowired
	private WhiteListDao whiteListDao;

	// 创建一个缓存管理器
	private static CacheManager SINGLETON_MANAGER = CacheManager.create();
	// 渠道信息缓存
	public static Cache CHANNEL_INFO_CACHE = SINGLETON_MANAGER.getCache("channelInfoCache");
	// 系统参数缓存
	public static Cache SYS_PARAM_CACHE = SINGLETON_MANAGER.getCache("sysParamCache");
	// 白名单列表缓存
	public static Cache WHITE_LIST_CACHE = SINGLETON_MANAGER.getCache("whiteListCache");

	/**
	 * 系统缓存初始化
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	public void initCacheService() {
		
		LOGGER.info("缓存初始化开始");
		
		List<ChannelInfo> channelInfoList = channelInfoDao.selectAvailableList();
		List<SysParam> sysParamsList = sysParamDao.selectAvailableList();
		List<WhiteList> whiteListList = whiteListDao.selectAvailableList();
		
		for (ChannelInfo channelInfo : channelInfoList) {
			CHANNEL_INFO_CACHE.put(new Element(channelInfo.getChannelCode() + "", channelInfo));
		}
		for (SysParam sysParams : sysParamsList) {
			SYS_PARAM_CACHE.put(new Element(sysParams.getParamType() + "-" + sysParams.getParamKey(), sysParams));
		}
		for (WhiteList whiteList : whiteListList) {
			WHITE_LIST_CACHE.put(new Element(whiteList.getChannelCode() + "-" + whiteList.getSourceUrl(), whiteList));
		}
		
		LOGGER.info("缓存初始化结束");
	}
	
	/**
	 * 系统缓存初始化
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	public void reloadChannelInfoCacheServer(){
		
		LOGGER.info("重新加载渠道信息缓存开始");
		
		List<ChannelInfo> channelInfoList = channelInfoDao.selectAvailableList();
		
		CHANNEL_INFO_CACHE.removeAll();
		
		for (ChannelInfo channelInfo : channelInfoList) {
			CHANNEL_INFO_CACHE.put(new Element(channelInfo.getChannelCode() + "", channelInfo));
		}
		
		LOGGER.info("重新加载渠道信息缓存结束");
	}
	
	/**
	 * 系统缓存初始化
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	public void reloadSysParamCacheServer(){
		
		LOGGER.info("重新加载系统参数缓存开始");
		
		List<SysParam> sysParamsList = sysParamDao.selectAvailableList();
		
		SYS_PARAM_CACHE.removeAll();
		
		for (SysParam sysParams : sysParamsList) {
			SYS_PARAM_CACHE.put(new Element(sysParams.getParamType() + "-" + sysParams.getParamKey(), sysParams));
		}
		
		LOGGER.info("重新加载系统参数缓存结束");
	}
	
	/**
	 * 系统缓存初始化
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	public void reloadWhiteListCacheServer(){
		
		LOGGER.info("重新加载白名单列表缓存开始");
		
		List<WhiteList> whiteListList = whiteListDao.selectAvailableList();
		
		WHITE_LIST_CACHE.removeAll();
		
		for (WhiteList whiteList : whiteListList) {
			WHITE_LIST_CACHE.put(new Element(whiteList.getChannelCode() + "-" + whiteList.getSourceUrl(), whiteList));
		}
		
		LOGGER.info("重新加载白名单列表缓存结束");
	}
}
