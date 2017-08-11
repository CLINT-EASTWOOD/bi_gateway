package com.zmb.bi.service.pay.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.persist.po.SysParam;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.common.BiInitCacheService;
import com.zmb.bi.service.pay.IQryPayRstForCommonService;
import com.zmb.pay.bean.common.PayResponse;
import com.zmb.pay.service.base.IQryPayRstForCommonBaseService;

/**
 * @version		:	1.0
 * @description :	支付系统查询支付结果服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-26 11:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class QryPayRstForCommonServiceImpl implements IQryPayRstForCommonService {

	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IQryPayRstForCommonBaseService qryPayRstForCommonBaseService;
	
	private static final String PAY_GATEWAY_SALT = "pay_gateway_salt-";

	/**
	 * 支付系统查询支付结果
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@Override
	public BiResponse qryPayRstForCommonService(BiRequest biRequest) {

		BiResponse biResponse = new BiResponse(biRequest);

		String salt = ((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get(PAY_GATEWAY_SALT + biRequest.getHead().getChannel()).getObjectValue()).getParamValue();
		
		PayResponse payResponse = qryPayRstForCommonBaseService.qryPayRstForCommonBaseService(biRequest.getBody(), salt);
		
		biCommonService.createBiHeadSign(biRequest.getHead().getChannel(), biResponse, payResponse.getBody());

		biResponse.getHead().setRtnCode(payResponse.getReturnCode());
		biResponse.getHead().setRtnMsg(payResponse.getReturnMsg());
		biResponse.getHead().setChannel(biRequest.getHead().getChannel());

		return biResponse;
	}
}
