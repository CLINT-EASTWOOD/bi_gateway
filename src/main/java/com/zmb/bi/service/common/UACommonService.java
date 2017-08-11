package com.zmb.bi.service.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmb.baseUtil.utils.HttpClientUtil;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.persist.po.ChannelInfo;
import com.zmb.bi.persist.po.SysParam;
import com.zmb.ua.bean.common.UARequest;
import com.zmb.ua.bean.common.UAResponse;
import com.zmb.ua.bean.common.UAResponseHead;
import com.zmb.ua.bean.constant.UAResponseConst;

@Service
public class UACommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(UACommonService.class);
	
	private static final String BIGATEWAY_SYS_NO = "130";
	
	@Autowired
	private BiCommonService biCommonService;
	
	public UAResponse invokeUAService(Object object, String interfaceUrl) {
		
		logger.info("UTBASE HTTP POST URL : " + ((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("utbase_invoke_conf-http_client_url").getObjectValue()).getParamValue() + interfaceUrl);
		logger.info("UTBASE HTTP POST REQUEST : " + JSON.toJSONString(object));

		String response = HttpClientUtil.doPostContent(JSON.toJSONString(object),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("utbase_invoke_conf-json_type").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("utbase_invoke_conf-request_charset").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("utbase_invoke_conf-response_charset").getObjectValue()).getParamValue(),
				((SysParam)BiInitCacheService.SYS_PARAM_CACHE.get("utbase_invoke_conf-http_client_url").getObjectValue()).getParamValue() + interfaceUrl);

		logger.info("UTBASE HTTP POST RESPONSE : " + response);
		
		JSONObject responseJsonObject = JSONObject.parseObject(response);
		UAResponseHead responseHead = responseJsonObject.getObject(UAResponseConst.HEAD, UAResponseHead.class);
		Object responseBody = responseJsonObject.getObject(UAResponseConst.BODY, Object.class);

		UAResponse uaResponse = new UAResponse(responseHead, responseBody);

		return uaResponse;
	}
	
	public UARequest parseRequestHeadBi2UA(BiRequest biRequest){
		
		logger.info("Channel : " + biRequest.getHead().getChannel() + " - " + JSON.toJSONString(BiInitCacheService.CHANNEL_INFO_CACHE.get(biRequest.getHead().getChannel())));
		
		UARequest uaRequest = new UARequest();
		uaRequest.getHead().setTranDate(biRequest.getHead().getTranDate());
		uaRequest.getHead().setTranTime(biRequest.getHead().getTranTime());
		uaRequest.getHead().setPreSeqNo(biCommonService.createGlobalSeq(BIGATEWAY_SYS_NO, "BI"));
		uaRequest.getHead().setConsumerId(BIGATEWAY_SYS_NO);
		uaRequest.getHead().setChannel(((ChannelInfo)BiInitCacheService.CHANNEL_INFO_CACHE.get(biRequest.getHead().getChannel()).getObjectValue()).getInnerChannelCode());
		uaRequest.getHead().setBranchId(((ChannelInfo)BiInitCacheService.CHANNEL_INFO_CACHE.get(biRequest.getHead().getChannel()).getObjectValue()).getOrganization());
		uaRequest.getHead().setSourceSysId(((ChannelInfo)BiInitCacheService.CHANNEL_INFO_CACHE.get(biRequest.getHead().getChannel()).getObjectValue()).getTargetSysId() + "");
		
		return uaRequest;
	}
	
	public void parseResponseHeadUA2Bi(String channel, final BiResponse biResponse, UAResponse uaResponse){
		
		biResponse.getHead().setRtnCode(uaResponse.getHead().getReturnCode());
		biResponse.getHead().setRtnMsg(uaResponse.getHead().getReturnMsg());
		biResponse.getHead().setGlobalSeqNo(uaResponse.getHead().getExternalSeqNo());
		biResponse.getHead().setChannel(channel);
	}
	
	public void setUARespHead(final UAResponse uaResponse, String rtnCode, String rtnMsg) {

		uaResponse.getHead().setReturnCode(rtnCode);
		uaResponse.getHead().setReturnMsg(rtnMsg);
	}
}
