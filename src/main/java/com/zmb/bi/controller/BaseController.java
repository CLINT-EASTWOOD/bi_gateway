package com.zmb.bi.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zmb.bi.exception.AplException;
import com.zmb.bi.exception.BaseResBean;

/**
 * @version		:	1.0
 * @description :	BASE控制器
 * @author		:	zhangqiang
 * @updateAuthor:
 * @date		:	2016-06-01 09:30
 * @updateDate	:
 * @comments	:	
 */
public class BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	// 错误页面
	public static final String ERROR_PAGE = "common/error";
	// 报文编码
	private static final String HEADER_ENCODING = "UTF-8";
	// 报文缓存
	private static final boolean HEADER_NO_CACHE = true;
	// 报文文本格式
	private static final String HEADER_TEXT_CONTENT_TYPE = "text/plain";
	// 返回错误代码
	protected static final String RESP_CODE = "33333333";

	/**
	 * 异常处理
	 * @param		:	ex
	 * @return		:	String		
	 * @comments	:	
	 */
	@ExceptionHandler
	@ResponseBody
	public String _exceptionHandler(Exception ex) {
		
		LOGGER.error("控制器收到业务处理异常：", ex);
		
		BaseResBean res = new BaseResBean();
		
		if (ex instanceof AplException) {
			res.setRespCode(((AplException) ex).getErrCode());
			res.setRespMsg(((AplException) ex).getErrMsg());
		} else {
			res.setRespCode(RESP_CODE);
		}

		return JSON.toJSONString(res);
	}

	/**
	 * Ajax异常
	 * @param		:	content
	 * @param		:	contentType
	 * @param		:	response
	 * @return		:	String		null
	 * @comments	:	
	 */
	protected String ajax(String content, String contentType, HttpServletResponse response) throws Exception {
		
		initResponse(contentType, response);
		response.getWriter().write(content);
		response.getWriter().flush();

		return null;
	}

	/**
	 * 初始化Response
	 * @param		:	contentType
	 * @param		:	response
	 * @return		:	response		
	 * @comments	:	
	 */
	private HttpServletResponse initResponse(String contentType, HttpServletResponse response) {
		
		response.setContentType(contentType + ";charset=" + "UTF-8");
		response.addHeader("powered by", "msds");
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");

		return response;
	}

	/**
	 * Ajax请求异常
	 * @param		:	text		
	 * @param		:	response	
	 * @return		:	String		null
	 * @comments	:	
	 */
	protected String ajax(String text, HttpServletResponse response) throws Exception {
		return ajax(text, "text/plain", response);
	}
}
