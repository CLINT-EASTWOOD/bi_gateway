package com.zmb.bi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version		:	1.0
 * @description :	健康检查控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-19 09:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
public class HealthController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

	/**
	 * 系统健康检查
	 * @param		:	
	 * @return		:	String		健康检查成功提示信息
	 * @comments	:	
	 */
	@RequestMapping("/health/check")
	@ResponseBody
	public String healthCheckController(){
		
		LOGGER.info("HEALTH CHECK OK");
		return "HEALTH CHECK OK";
	}
}
