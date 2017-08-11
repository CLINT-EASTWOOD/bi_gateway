package com.zmb.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmb.baseUtil.controller.BaseController;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.ua.IAddUserAccountService;

/**
 * @version		:	1.0
 * @description :	系统配置控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-16 09:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
@RequestMapping("ua")
public class UserAccountController extends BaseController {
	
	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IAddUserAccountService addUserAccountService;

	/**
	 * 系统用户帐户添加
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("add")
	@ResponseBody
	public BiResponse AddUserAccountController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/ua/add");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = addUserAccountService.addUserAccountService(biRequest);
		}
		
		return biResponse;
	}
}
