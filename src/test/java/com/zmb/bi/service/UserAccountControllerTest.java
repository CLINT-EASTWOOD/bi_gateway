package com.zmb.bi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiRequestHead;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.ua.IAddUserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml", "classpath:spring-mvc.xml" })
public class UserAccountControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAccountControllerTest.class);

	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IAddUserAccountService addUserAccountService;

	@Test
	public void AddUserAccountController() {

		try {
			SimpleDateFormat ymd = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat hms = new SimpleDateFormat("HHmmssSSS");
			
			BiRequest biRequest = new BiRequest();
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("account", "13012345678");
			map.put("type", 1);
			map.put("phonenum", "13012345678");
			map.put("flag", "0");
			map.put("openDate", ymd.format(new Date()));
			map.put("carPlateNo", "京A00000");
			map.put("carBrand", "奔驰");
			map.put("carModel", "AMG S63");
			map.put("carColor", "黑");
			map.put("belongType", "001");
			
			BiRequestHead biRequestHead = new BiRequestHead();
			biRequestHead.setTranDate(ymd.format(new Date()));
			biRequestHead.setTranTime(hms.format(new Date()));
			biRequestHead.setChannel("20100001");
			biRequestHead.setInterfaceUrl("/ua/add");
			biRequestHead.setGlobalSeqNo(biCommonService.createGlobalSeq("130", "car_wash"));
			biRequestHead.setSign(biCommonService.createBiHeadSign("20100001", map));
			biRequest.setHead(biRequestHead);
			biRequest.setBody(map);
			
			BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/ua/add");
			//BiResponse biResponse = new BiResponse(biRequest);
			if (RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())) {
				biResponse = addUserAccountService.addUserAccountService(biRequest);
			} 
			
			logger.info(JSON.toJSONString(biResponse));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
