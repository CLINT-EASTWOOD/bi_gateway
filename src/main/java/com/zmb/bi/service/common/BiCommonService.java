package com.zmb.bi.service.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.exception.AplException;
import com.zmb.bi.persist.po.ChannelInfo;
import com.zmb.bi.persist.po.WhiteList;

/**
 * @version		:	1.0
 * @description :	行业网关系统公共服务
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-15 09:30
 * @updateDate	:
 * @comments	:	
 */
@Service
public class BiCommonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BiCommonService.class);

	// 请求超时时间
	private static final long TIME_DIFF = 5 * 60 * 1000L;

	/**
	 * 请求信息头部校验
	 * @param		:	biRequest		BIRequest
	 * @param		:	interfaceUrl	接口URL
	 * @return		:	BiResponse		BIResponse
	 * @comments	:	
	 */
	public BiResponse biRequestHeadCheck(BiRequest biRequest, String interfaceUrl) {

		BiResponse biResponse = new BiResponse(biRequest);
		
		if (!interfaceUrlCheck(biRequest, interfaceUrl)) {
			setBiRespHead(biResponse, "13030001", "接口路由不匹配");
		} else if (!whiteUrlCheck(biRequest)) {
			setBiRespHead(biResponse, "13030002", "接口路由异常");
		} else if (!requestDateTimeCheck(biRequest)) {
			setBiRespHead(biResponse, "13030003", "接口请求超时");
		} else if (!checkBiHeadSign(biRequest)) {
			setBiRespHead(biResponse, "13030004", "接口校验异常");
		}

		return biResponse;
	}

	/**
	 * 生成行业网关头部签名
	 * @param		:	channelCode		渠道代码
	 * @param		:	biRequest		BIRequest
	 * @param		:	responseBody	响应体信息
	 * @return		:	
	 * @comments	:	
	 */
	public void createBiHeadSign(String channelCode, final BiResponse biResponse, Object responseBody) {

		String salt = ((ChannelInfo) BiInitCacheService.CHANNEL_INFO_CACHE.get(channelCode).getObjectValue()).getSalt();
		
		String calcHeadSignResponse = DigestUtils.sha256Hex(generateSign(responseBody, salt));
		
		biResponse.getHead().setSign(calcHeadSignResponse);
		biResponse.setBody(responseBody == null ? new JSONObject() : responseBody);
	}

	/**
	 * 生成行业网关头部签名
	 * @param		:	channelCode		渠道代码
	 * @param		:	responseBody	响应体信息
	 * @return		:	
	 * @comments	:	
	 */
	public String createBiHeadSign(String channelCode, Object requestBody) {

		String salt = ((ChannelInfo) BiInitCacheService.CHANNEL_INFO_CACHE.get(channelCode).getObjectValue()).getSalt();
		
		String calcHeadSign = DigestUtils.sha256Hex(generateSign(requestBody, salt));

		return calcHeadSign;
	}

	/**
	 * 白名单校验
	 * @param		:	biRequest		BIRequest
	 * @return		:	boolean			校验是否通过
	 * @comments	:	
	 */
	private static boolean whiteUrlCheck(BiRequest biRequest) {

		if (((WhiteList) BiInitCacheService.WHITE_LIST_CACHE.get(biRequest.getHead().getChannel() + "-" + biRequest.getHead().getInterfaceUrl()).getObjectValue())
				.getSourceUrl().equals(biRequest.getHead().getInterfaceUrl())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 接口URL校验
	 * @param		:	biRequest		BIRequest
	 * @param		:	interfaceUrl	接口URL
	 * @return		:	boolean			校验是否通过
	 * @comments	:	
	 */
	private static boolean interfaceUrlCheck(BiRequest biRequest, String interfaceUrl) {

		if (interfaceUrl.equals(biRequest.getHead().getInterfaceUrl())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 交易请求时间校验
	 * @param		:	biRequest		BIRequest
	 * @return		:	boolean			校验是否通过
	 * @comments	:	
	 */
	private static boolean requestDateTimeCheck(BiRequest biRequest) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		try {
			Date requestDT = sdf.parse(biRequest.getHead().getTranDate() + biRequest.getHead().getTranTime());
			Date nowDT = new Date();

			if (nowDT.getTime() - requestDT.getTime() <= TIME_DIFF && nowDT.getTime() - requestDT.getTime() >= 0) {
				return true;
			}
		} catch (ParseException e) {
			LOGGER.error("时间转换异常", e);
		}

		return false;
	}

	/**
	 * 签名校验
	 * @param		:	biRequest		BIRequest
	 * @return		:	boolean			校验是否通过
	 * @comments	:	
	 */
	private static boolean checkBiHeadSign(BiRequest biRequest) {

		String salt = ((ChannelInfo) BiInitCacheService.CHANNEL_INFO_CACHE.get(biRequest.getHead().getChannel())
				.getObjectValue()).getSalt();
		
		JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(biRequest.getBody()));
		
		String sign = generateSign(jsonObject, salt);
		
		LOGGER.info("加密前字符串 : " + sign);

		String calcHeadSignRequest = DigestUtils.sha256Hex(sign);
		
		LOGGER.info("加密后字符串 : " + calcHeadSignRequest);

		if (calcHeadSignRequest.equals(biRequest.getHead().getSign())) {
			return true;
		} else {
			return false;
		}
	}

	// 序列类型Map
	private static Map<String, String> seqTypeMap = new HashMap<String, String>();

	/**
	 * 生成全局流水号
	 * @param		:	sysCode			系统代码
	 * @param		:	seqType			序列类型
	 * @return		:	globalSeq		全局流水号
	 * @comments	:	
	 */
	public String createGlobalSeq(String sysCode, String seqType) {

		String seqKey = new StringBuilder().append(sysCode).append(seqType).toString();
		String seq = "";
		StringBuilder globalSeq = new StringBuilder();

		String nodeValue = System.getenv("zmb_node");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateValue = sdf.format(new Date());

		synchronized (seqTypeMap) {
			if (!(seqTypeMap.containsKey(seqKey))) {
				seq = "1000000000";
				seqTypeMap.put(seqKey, seq);
			} else {
				seq = seqTypeMap.get(seqKey);
			}

			if (seq.equals("9999999999"))
				seqTypeMap.put(seqKey, "1000000000");
			else {
				seqTypeMap.put(seqKey, new StringBuilder().append(Integer.parseInt(seq) + 1).append("").toString());
			}

		}

		globalSeq.append(sysCode);
		globalSeq.append(nodeValue);
		globalSeq.append(dateValue);
		globalSeq.append(seq);

		return globalSeq.toString();
	}
	

	/**
	 * 生成明文签名
	 * @param		:	obj			生成签名对象
	 * @param		:	salt		生成签名盐值
	 * @return		:	signs		明文签名字符串
	 * @comments	:	
	 */
	private static String generateSign(Object obj, String salt) {
		
		TreeMap<String, Object> paramTreeMap = JSON.parseObject(JSON.toJSONString(obj), TreeMap.class);
		
		String sign = JSON.toJSONString(paramTreeMap);
		sign = "null".equals(sign) ? "{}" : sign;
		
		LOGGER.info("ParamTreeMap : " + sign + " \nSalt : " + salt);

		String signs = salt + sign + salt;

		LOGGER.info("GenerateSign : " + signs);

		return signs;
	}
	

	/**
	 * 对象内容拷贝
	 * @param		:	dest			目的对项
	 * @param		:	orig			源对象
	 * @return		:	
	 * @comments	:	
	 */
	public void copyProperties(Object dest, Object orig){
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (Exception e) {
			LOGGER.error("对象内容拷贝异常", e);
		}
	}
	

	/**
	 * 设置相应头部信息
	 * @param		:	biRequest		BIRequest
	 * @param		:	rtnCode			返回代码
	 * @param		:	rtnMsg			返回消息
	 * @return		:	Exception		异常
	 * @comments	:	
	 */
	public Exception setBiRespHead(BiResponse biResponse, String rtnCode, String rtnMsg) {

		biResponse.getHead().setRtnCode(rtnCode);
		biResponse.getHead().setRtnMsg(rtnMsg);
		
		LOGGER.info("SetBiRespHead : RtnCode - " + rtnCode + " , RtnMsg - " + rtnMsg);

		if (!RtnRespEnum.SUCCESS.equals(rtnCode)) {
			throw new AplException(rtnCode, rtnMsg);
		} else {
			return null;
		}
	}
}
