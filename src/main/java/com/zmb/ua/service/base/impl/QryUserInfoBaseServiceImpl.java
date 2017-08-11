package com.zmb.ua.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.service.common.UACommonService;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.service.base.IQryUserInfoBaseService;

@Service
public class QryUserInfoBaseServiceImpl implements IQryUserInfoBaseService {

	@Autowired
	private UACommonService uaCommonService;

	private static final String requestUrl = "/user/getUserInfo";

	@Override
	public UAResponse getUserInfoBaseService(UARequest uaRequest) {

		UAResponse uaResponse = uaCommonService.invokeUAService(uaRequest, requestUrl);
		return uaResponse;
	}
}
