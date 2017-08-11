package com.zmb.bi.service.common;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmb.baseUtil.utils.HttpClientUtil;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.exception.AplException;
import com.zmb.bi.persist.po.SysParam;
import com.zmb.pay.bean.common.PayResponse;
import com.zmb.pay.bean.constant.PayResponseConst;

@Service
public class PayCommonService {

	public PayResponse payCommonService(Object object, String interfaceUrl) {

		String response = HttpClientUtil.doPostContent(JSON.toJSONString(object),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("pay_gateway_invoke_conf-json_type").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("pay_gateway_invoke_conf-request_charset").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("pay_gateway_invoke_conf-response_charset").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("pay_gateway_invoke_conf-http_client_url").getObjectValue()).getParamValue() + interfaceUrl);
		
		JSONObject responseJsonObject = JSONObject.parseObject(response);
		String responseHeadCode = responseJsonObject.getString(PayResponseConst.RTN_CODE);
		String responseHeadMsg = responseJsonObject.getString(PayResponseConst.RTN_MSG);
		Object responseObject = responseJsonObject.getObject(PayResponseConst.BODY, Object.class);
		
		PayResponse payResponse = new PayResponse(responseHeadCode, responseHeadMsg, responseObject);
		
		return payResponse;
	}
	
	public Exception setPayRespHead(PayResponse payResponse, String rtnCode, String rtnMsg) {

		payResponse.setReturnCode(rtnCode);
		payResponse.setReturnMsg(rtnMsg);

		if (!RtnRespEnum.SUCCESS.equals(rtnCode)) {
			throw new AplException(rtnCode, rtnMsg);
		} else {
			return null;
		}
	}
}
