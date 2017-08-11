package com.zmb.bi.service.ua.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.common.UACommonService;
import com.zmb.bi.service.ua.IAccountTradeService;
import com.zmb.ua.bean.account.request.AccountTradeRequest;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.service.base.IAccountTradeBaseService;

/**
 * @version		:	1.0
 * @description :	账户系统账户交易服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-21 11:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class AccountTradeServiceImpl implements IAccountTradeService {

	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private UACommonService uaCommonService;
	@Autowired
	private IAccountTradeBaseService accountTradeBaseService;
	
	/**
	 * 账户系统账户交易
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@Override
	public BiResponse accountTradeService(BiRequest biRequest){
		
		BiResponse biResponse = new BiResponse(biRequest);
		
		UARequest uaRequest = uaCommonService.parseRequestHeadBi2UA(biRequest);
		
		AccountTradeRequest accountTradeRequest = new AccountTradeRequest();
		
		biCommonService.copyProperties(accountTradeRequest, biRequest.getBody());
		
		UAResponse uaResponse = new UAResponse();
		
		if (accountTradeRequest.getFundsFrom() == null && accountTradeRequest.getFundsTo() == null) {
			uaResponse.getHead().setReturnCode(RtnRespEnum.FAILURE.getCode());
			uaResponse.getHead().setReturnMsg(RtnRespEnum.FAILURE.getMsg());
		} else if (accountTradeRequest.getFundsFrom() != null && accountTradeRequest.getFundsTo() != null) {
			uaResponse.getHead().setReturnCode(RtnRespEnum.FAILURE.getCode());
			uaResponse.getHead().setReturnMsg(RtnRespEnum.FAILURE.getMsg());
		} else if (accountTradeRequest.getFundsFrom() != null) {
			uaRequest.setBody(accountTradeRequest);
			uaResponse = accountTradeBaseService.accountTradeBaseService(uaRequest);
		} else if (accountTradeRequest.getFundsTo() != null) {
			accountTradeRequest.setAmount(-accountTradeRequest.getAmount());
			uaRequest.setBody(accountTradeRequest);
			uaResponse = accountTradeBaseService.accountTradeBaseService(uaRequest);
		}
		
		biCommonService.createBiHeadSign(biRequest.getHead().getChannel(), biResponse, uaResponse.getBody());
		
		uaCommonService.parseResponseHeadUA2Bi(biRequest.getHead().getChannel(), biResponse, uaResponse);
		
		return biResponse;
	}
}
