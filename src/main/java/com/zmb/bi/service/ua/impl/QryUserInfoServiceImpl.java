package com.zmb.bi.service.ua.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.bean.response.UAQryUserInfoResponse;
import com.zmb.bi.dao.CarWashInfoDao;
import com.zmb.bi.persist.po.CarWashInfo;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.common.UACommonService;
import com.zmb.bi.service.ua.IQryUserInfoService;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.bean.user.request.QryAccountInfoRequest;
import com.zmb.ua.bean.user.request.QryUserInfoRequest;
import com.zmb.ua.bean.user.response.QryAccountInfoResponse;
import com.zmb.ua.bean.user.response.QryUserInfoResponse;
import com.zmb.ua.service.base.IQryAccountInfoBaseService;
import com.zmb.ua.service.base.IQryUserInfoBaseService;

/**
 * @version		:	1.0
 * @description :	用户系统用户信息查询服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-21 11:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class QryUserInfoServiceImpl implements IQryUserInfoService {

	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private UACommonService uaCommonService;
	@Autowired
	private IQryUserInfoBaseService getUserInfoBaseService;
	@Autowired
	private IQryAccountInfoBaseService getAccountInfoBaseService;
	
	@Autowired
	private CarWashInfoDao carWashInfoDao;

	/**
	 * 用户系统用户信息查询
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@Override
	public BiResponse getUserInfoService(BiRequest biRequest) {

		BiResponse biResponse = new BiResponse(biRequest);

		UARequest uaRequest = uaCommonService.parseRequestHeadBi2UA(biRequest);

		UAResponse uaResponse = new UAResponse();
		
		QryUserInfoRequest getUserInfoRequest = new QryUserInfoRequest();
		
		biCommonService.copyProperties(getUserInfoRequest, uaRequest.getBody());
		
		uaRequest.setBody(getUserInfoRequest);
		
		uaResponse = getUserInfoBaseService.getUserInfoBaseService(uaRequest);
		
		if (RtnRespEnum.SUCCESS.getCode().equals(uaResponse.getHead().getReturnCode()) 
				&& uaResponse.getBody() != null
				&& ((List<QryUserInfoResponse>) uaResponse.getBody()).size() == 1) {
			
			QryUserInfoResponse getUserInfoResponse = ((List<QryUserInfoResponse>) uaResponse.getBody()).get(0);
			
			QryAccountInfoRequest getAccountInfoRequest = new QryAccountInfoRequest();
			biCommonService.copyProperties(getAccountInfoRequest, uaRequest.getBody());
			getAccountInfoRequest.setSubaccId("0");
			
			uaRequest.setBody(getAccountInfoRequest);
			
			uaResponse = getAccountInfoBaseService.getAccountInfoBaseService(uaRequest);
			
			if(RtnRespEnum.SUCCESS.getCode().equals(uaResponse.getHead().getReturnCode())
					&& uaResponse.getBody() != null
					&& ((List<QryAccountInfoResponse>) uaResponse.getBody()).size() == 1){
				
				QryAccountInfoResponse getAccountInfoResponse = ((List<QryAccountInfoResponse>) uaResponse.getBody()).get(0);
				
				CarWashInfo carWashInfo = carWashInfoDao.selectByUid(getAccountInfoResponse.getUid());
				
				UAQryUserInfoResponse uaGetUserInfoResponse = new UAQryUserInfoResponse();
				biCommonService.copyProperties(uaGetUserInfoResponse, carWashInfo);
				biCommonService.copyProperties(uaGetUserInfoResponse, getAccountInfoResponse);
				biCommonService.copyProperties(uaGetUserInfoResponse, getUserInfoResponse);
				
				biResponse.setBody(uaGetUserInfoResponse);
			}
		}

		biCommonService.createBiHeadSign(biRequest.getHead().getChannel(), biResponse, uaResponse.getBody());

		uaCommonService.parseResponseHeadUA2Bi(biRequest.getHead().getChannel(), biResponse, uaResponse);

		return biResponse;
	}
}
