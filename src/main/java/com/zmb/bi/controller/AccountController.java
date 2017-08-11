package com.zmb.bi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.ua.IAccountTradeService;

/**
 * @version		:	1.0
 * @description :	账户系统控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-12 11:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
@RequestMapping("account")
public class AccountController extends BaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IAccountTradeService accountTradeService;

	
	/**
	 * 账户添加
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("add")
	public void addAccountController(){
		
	}
	
	/**
	 * 账户充值
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("recharge")
	@ResponseBody
	public BiResponse rechangeAccountController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/account/recharge");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = accountTradeService.accountTradeService(biRequest);
		}
		
		return biResponse;
	}
	
	/**
	 * 账户消费
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("consume")
	public BiResponse consumeAccountController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/account/consume");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = accountTradeService.accountTradeService(biRequest);
		}
		
		return biResponse;
	}
	
	/**
	 * 账户交易流水查询
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("qryAcctTradeFlow")
	public void queryAccountPayedFlow(){
		
	}
	
	/**
	 * 账户信息查询
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@RequestMapping("qryAcctInfo")
	public void queryAccountInfo(){
		
	}
}
