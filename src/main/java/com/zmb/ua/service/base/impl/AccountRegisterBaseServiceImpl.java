package com.zmb.ua.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.service.common.UACommonService;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.service.base.IAccountRegisterBaseService;

@Service
public class AccountRegisterBaseServiceImpl implements IAccountRegisterBaseService {
	
	@Autowired
	private UACommonService uaCommonService;
	
	private static final String requestUrl = "/account/regAcc";

	@Override
	public UAResponse accountRegisterBaseService(UARequest uaRequest){
		
		UAResponse uaResponse = uaCommonService.invokeUAService(uaRequest, requestUrl);
		return uaResponse;
	}
}
