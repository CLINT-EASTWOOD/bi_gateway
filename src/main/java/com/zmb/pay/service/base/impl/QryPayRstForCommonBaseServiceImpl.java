package com.zmb.pay.service.base.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmb.baseUtil.utils.TreeMapSHA256Util;
import com.zmb.bi.service.common.PayCommonService;
import com.zmb.pay.bean.common.PayResponse;
import com.zmb.pay.bean.request.QryPayRstForCommonRequest;
import com.zmb.pay.service.base.IQryPayRstForCommonBaseService;

import net.sf.cglib.beans.BeanCopier;

@Service
public class QryPayRstForCommonBaseServiceImpl implements IQryPayRstForCommonBaseService {

	@Autowired
	private PayCommonService payCommonService;
	
	private static final String requestUrl = "/pay/qryPayRstForcommon";

	public PayResponse qryPayRstForCommonBaseService(Object biRequestBody, String salt) {

		PayResponse payResponse = new PayResponse();
		
		try {

			QryPayRstForCommonRequest qryPayRstForCommonRequest = new QryPayRstForCommonRequest();

			BeanCopier copier = BeanCopier.create(biRequestBody.getClass(), qryPayRstForCommonRequest.getClass(), false);
			copier.copy(biRequestBody, qryPayRstForCommonRequest, null);

			qryPayRstForCommonRequest.setSign(null);

			HashMap<String, String> requestMap = new HashMap<String, String>();
			BeanUtils.populate(qryPayRstForCommonRequest, requestMap);
			
			String signRequest = TreeMapSHA256Util.encryptWithoutNull(requestMap, "salt");

			qryPayRstForCommonRequest.setSign(signRequest);

			payResponse = payCommonService.payCommonService(qryPayRstForCommonRequest, requestUrl);
			
			HashMap<String, String> responseMap = new HashMap<String, String>();
			BeanUtils.populate(payResponse.getBody(), responseMap);

			String signResponse = responseMap.remove("sign");

			String calcHeadSignResponse = TreeMapSHA256Util.encryptWithoutNull(responseMap, "salt");

			if (!calcHeadSignResponse.equals(signResponse)) {
				return payResponse;
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return payResponse;
	}
}
