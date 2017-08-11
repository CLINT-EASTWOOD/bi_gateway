package com.zmb.bi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmb.bi.service.common.BiInitCacheService;

/**
 * @version		:	1.0
 * @description :	系统配置控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-13 09:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
@RequestMapping("conf")
public class BossController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BossController.class);

	@Autowired
	private BiInitCacheService biInitCacheService;
	
	/**
	 * 重新加载渠道缓存信息
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	@RequestMapping("reloadChannelInfoCache")
	public void reloadChannelInfoCacheController(){
		
		LOGGER.info("Begin ReloadChannelInfoCache");
		biInitCacheService.reloadChannelInfoCacheServer();
		LOGGER.info("End ReloadChannelInfoCache");
	}
	
	/**
	 * 重新加载系统参数缓存信息
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	@RequestMapping("reloadSysParamCache")
	public void reloadSysParamCacheController(){
		
		LOGGER.info("Begin ReloadSysParamCache");
		biInitCacheService.reloadSysParamCacheServer();
		LOGGER.info("Begin ReloadSysParamCache");
	}
	
	/**
	 * 重新加载白名单缓存信息
	 * @param		:	
	 * @return		:	
	 * @comments	:	
	 */
	@RequestMapping("reloadWhiteListCache")
	public void reloadWhiteListCacheController(){
		
		LOGGER.info("Begin ReloadWhiteListCache");
		biInitCacheService.reloadWhiteListCacheServer();
		LOGGER.info("Begin ReloadWhiteListCache");
	}
}
