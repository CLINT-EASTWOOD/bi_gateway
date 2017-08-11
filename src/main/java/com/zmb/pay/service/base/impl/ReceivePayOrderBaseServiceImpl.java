package com.zmb.pay.service.base.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.baseUtil.utils.BeanToMapUtil;
import com.zmb.baseUtil.utils.TreeMapSHA256Util;
import com.zmb.bi.service.common.PayCommonService;
import com.zmb.pay.bean.common.PayResponse;
import com.zmb.pay.bean.request.ReceivePayOrderRequest;
import com.zmb.pay.service.base.IReceivePayOrderBaseService;

@Service
public class ReceivePayOrderBaseServiceImpl implements IReceivePayOrderBaseService {

	@Autowired
	private PayCommonService payCommonService;
	
	private static final String requestUrl = "/pay/receivePayOrder";

	public PayResponse receivePayOrderBaseService(Object biRequestBody, String salt) {

		PayResponse payResponse = new PayResponse();

		try {
			
			ReceivePayOrderRequest receivePayOrderRequest = new ReceivePayOrderRequest();

			/*BeanCopier copier = BeanCopier.create(biRequestBody.getClass(), receivePayOrderRequest.getClass(), false);
			copier.copy(biRequestBody, receivePayOrderRequest, null);*/
			
			BeanUtils.copyProperties(receivePayOrderRequest, biRequestBody);

			receivePayOrderRequest.setAppVersion(null);
			receivePayOrderRequest.setUdid(null);
			receivePayOrderRequest.setMerOrderIp(null);
			receivePayOrderRequest.setMerOrderChl(null);
			receivePayOrderRequest.setToken(null);
			receivePayOrderRequest.setUserToken(null);
			receivePayOrderRequest.setSign(null);

			HashMap<String, String> requestMap = new HashMap<String, String>();
			//BeanUtils.populate(receivePayOrderRequest, requestMap);
			
			requestMap = (HashMap<String, String>) BeanToMapUtil.convertBean(receivePayOrderRequest);

			String signRequest = TreeMapSHA256Util.encryptWithoutNull(requestMap, salt);

			receivePayOrderRequest.setSign(signRequest);
			
			payResponse = payCommonService.payCommonService(receivePayOrderRequest, requestUrl);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

		return payResponse;
	}
}
