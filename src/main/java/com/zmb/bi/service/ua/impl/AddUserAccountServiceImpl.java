package com.zmb.bi.service.ua.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.dao.CarWashInfoDao;
import com.zmb.bi.persist.po.CarWashInfo;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.common.UACommonService;
import com.zmb.bi.service.ua.IAddUserAccountService;
import com.zmb.ua.bean.account.request.AccountRegisterRequest;
import com.zmb.ua.bean.account.request.UserRegisterRequest;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.service.base.IAccountRegisterBaseService;
import com.zmb.ua.service.base.IUserRegisterBaseService;

/**
 * @version		:	1.0
 * @description :	用户账户系统添加用户帐户服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-21 11:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class AddUserAccountServiceImpl implements IAddUserAccountService {

	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private UACommonService uaCommonService;
	@Autowired
	private IUserRegisterBaseService userRegisterService;
	@Autowired
	private IAccountRegisterBaseService accountRegisterService;
	
	@Autowired
	private CarWashInfoDao carWashInfoDao;

	/**
	 * 用户账户系统添加用户帐户
	 * @param		:	biRequest		BIRequest
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	@Override
	public BiResponse addUserAccountService(BiRequest biRequest){
		
		BiResponse biResponse = new BiResponse(biRequest);
		
		UARequest uaRequest = uaCommonService.parseRequestHeadBi2UA(biRequest);
		
		UAResponse uaResponse = new UAResponse();
		
		CarWashInfo carWashInfo = new CarWashInfo();
		
		biCommonService.copyProperties(carWashInfo, biRequest.getBody());
		
		int carCount = carWashInfoDao.selectByCarPlateNoCount(carWashInfo.getCarPlateNo());
		
		if (carCount == 0) {

			UserRegisterRequest userRegisterRequest = new UserRegisterRequest();

			biCommonService.copyProperties(userRegisterRequest, biRequest.getBody());

			uaRequest.setBody(userRegisterRequest);

			uaResponse = userRegisterService.userRegisterBaseService(uaRequest);

			if (RtnRespEnum.SUCCESS.getCode().equals(uaResponse.getHead().getReturnCode())) {

				AccountRegisterRequest accountRegisterRequest = new AccountRegisterRequest();

				biCommonService.copyProperties(accountRegisterRequest, biRequest.getBody());

				accountRegisterRequest.setUid(JSONObject.parseObject(JSON.toJSONString(uaResponse.getBody())).getString("uid"));
				accountRegisterRequest.setSubaccId("1");
				accountRegisterRequest.setState("0");
				uaRequest.setBody(accountRegisterRequest);

				uaResponse = accountRegisterService.accountRegisterBaseService(uaRequest);

				if (RtnRespEnum.SUCCESS.getCode().equals(uaResponse.getHead().getReturnCode())) {

					carWashInfo.setUid(accountRegisterRequest.getUid());
					carWashInfo.setCarId(biCommonService.createGlobalSeq("130", "car_id"));

					carWashInfoDao.insertSelective(carWashInfo);
				}
			}
		} else {
			uaResponse.getHead().setReturnCode("");
			uaResponse.getHead().setReturnMsg("车辆信息已存在");
		}
		
		biCommonService.createBiHeadSign(biRequest.getHead().getChannel(), biResponse, uaResponse.getBody());
		
		uaCommonService.parseResponseHeadUA2Bi(biRequest.getHead().getChannel(), biResponse, uaResponse);
		
		return biResponse;
	}
}
