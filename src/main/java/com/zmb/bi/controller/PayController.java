package com.zmb.bi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zmb.baseUtil.controller.BaseController;
import com.zmb.bi.bean.common.BiRequest;
import com.zmb.bi.bean.common.BiResponse;
import com.zmb.bi.bean.constant.RtnRespEnum;
import com.zmb.bi.service.common.BiCommonService;
import com.zmb.bi.service.pay.IReceivePayOrderService;

/**
 * @version		:	1.0
 * @description :	支付系统控制器
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-26 09:30
 * @updateDate	:
 * @comments	:	
 */
@Controller
@RequestMapping("pay")
public class PayController extends BaseController {
	
	@Autowired
	private BiCommonService biCommonService;
	@Autowired
	private IReceivePayOrderService receivePayOrderAplService;
	
	/**
	 * 支付请求下单
	 * @param		:	biRequest		BiRequest
	 * @return		:	biResponse		BiResponse
	 * @comments	:	
	 */
	@RequestMapping("receivePayOrder")
	@ResponseBody
	public BiResponse ReceivePayOrderController(@RequestBody BiRequest biRequest){
		
		//BiResponse biResponse = biCommonService.biRequestHeadCheck(biRequest, "/pay/receivePayOrder");
		BiResponse biResponse = new BiResponse(biRequest);
		
		if(RtnRespEnum.FAILURE.getCode().equals(biResponse.getHead().getRtnCode())){
			biResponse = receivePayOrderAplService.receivePayOrderService(biRequest);
		}
		
		return biResponse;
	}
}
