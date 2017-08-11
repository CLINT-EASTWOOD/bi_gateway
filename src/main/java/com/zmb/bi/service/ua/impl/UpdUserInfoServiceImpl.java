package com.zmb.bi.service.ua.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.common.UACommonService;
import com.zmb.bi.service.ua.IUpdUserInfoService;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.bean.user.request.UpdUserInfoRequest;
import com.zmb.ua.bean.user.response.UpdUserInfoResponse;
import com.zmb.ua.service.base.impl.UpdUserInfoBaseServiceImpl;

/**
 * @version		:	1.0
 * @description :	用户系统用户信息修改服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-21 11:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class UpdUserInfoServiceImpl implements IUpdUserInfoService {
	
	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private UACommonService uaCommonService;
	@Autowired
	private UpdUserInfoBaseServiceImpl updUserInfoBaseService;

	/**
	 * 用户系统用户信息修改
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@Override
	public BiResponse updUserInfoService(BiRequest biRequest){
		
		BiResponse biResponse = new BiResponse(biRequest);

		UARequest uaRequest = uaCommonService.parseRequestHeadBi2UA(biRequest);

		UAResponse uaResponse = new UAResponse();
		
		UpdUserInfoRequest updUserInfoRequest = new UpdUserInfoRequest();
		
		biCommonService.copyProperties(updUserInfoRequest, uaRequest.getBody());
		
		uaRequest.setBody(updUserInfoRequest);
		
		uaResponse = updUserInfoBaseService.updUserInfoBaseService(uaRequest);
		
		if (RtnRespEnum.SUCCESS.getCode().equals(uaResponse.getHead().getReturnCode())) {
			
			UpdUserInfoResponse updUserInfoResponse = new UpdUserInfoResponse();
			biCommonService.copyProperties(updUserInfoResponse, updUserInfoRequest);
			uaResponse.setBody(updUserInfoResponse);
		}

		biCommonService.createBiHeadSign(biRequest.getHead().getChannel(), biResponse, uaResponse.getBody());

		uaCommonService.parseResponseHeadUA2Bi(biRequest.getHead().getChannel(), biResponse, uaResponse);

		return biResponse;
	}
}
