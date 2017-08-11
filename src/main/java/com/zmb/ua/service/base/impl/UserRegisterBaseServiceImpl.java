package com.zmb.ua.service.base.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.bi.service.common.UACommonService;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.service.base.IUserRegisterBaseService;

@Service
public class UserRegisterBaseServiceImpl implements IUserRegisterBaseService {

	@Autowired
	private UACommonService uaCommonService;
	
	private static final String requestUrl = "/user/regUser";

	@Override
	public UAResponse userRegisterBaseService(UARequest uaRequest){
		
		UAResponse uaResponse = uaCommonService.invokeUAService(uaRequest, requestUrl);
		return uaResponse;
	}
}
