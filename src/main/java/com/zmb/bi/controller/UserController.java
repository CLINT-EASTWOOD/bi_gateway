package com.zmb.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.ua.IQryUserInfoService;
import com.zmb.bi.service.ua.IUpdUserInfoService;

/**
 * @version		:	1.0
 * @description :	用户系统控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 09:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
	
	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IQryUserInfoService getUserInfoService;
	@Autowired
	private IUpdUserInfoService updUserInfoService;

	/**
	 * 系统用户添加
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("add")
	public void addUserController(){
		
	}
	
	/**
	 * 系统用户信息查询
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("qryUserInfo")
	public BiResponse getUserInfoController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/user/getUserInfo");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = getUserInfoService.getUserInfoService(biRequest);
		}
		
		return biResponse;
	}
	
	/**
	 * 系统用户信息修改
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("updUserInfo")
	public BiResponse chgUserInfoController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/user/chgUserInfo");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = updUserInfoService.updUserInfoService(biRequest);
		}
		
		return biResponse;
	}
}
