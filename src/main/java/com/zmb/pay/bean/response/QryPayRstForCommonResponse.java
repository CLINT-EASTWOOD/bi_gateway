package com.zmb.pay.bean.response;

import com.zmb.pay.bean.common.PayMsgResponse;

public class QryPayRstForCommonResponse {
	
	private String platPayFlowNo;
	private String merOrderId;
	private String merOrderTime;
	private String merOrderAmt;
	private String merOrderActPayAmt;
	private String merOrderPoundage;
	private String checkDate;
	private String merOrderPayState;
	private String settleFlag;
	private PayMsgResponse payMsg;
	private String sign;
	
	public String getPlatPayFlowNo() {
		return platPayFlowNo;
	}
	public void setPlatPayFlowNo(String platPayFlowNo) {
		this.platPayFlowNo = platPayFlowNo;
	}
	public String getMerOrderId() {
		return merOrderId;
	}
	public void setMerOrderId(String merOrderId) {
		this.merOrderId = merOrderId;
	}
	public String getMerOrderTime() {
		return merOrderTime;
	}
	public void setMerOrderTime(String merOrderTime) {
		this.merOrderTime = merOrderTime;
	}
	public String getMerOrderAmt() {
		return merOrderAmt;
	}
	public void setMerOrderAmt(String merOrderAmt) {
		this.merOrderAmt = merOrderAmt;
	}
	public String getMerOrderActPayAmt() {
		return merOrderActPayAmt;
	}
	public void setMerOrderActPayAmt(String merOrderActPayAmt) {
		this.merOrderActPayAmt = merOrderActPayAmt;
	}
	public String getMerOrderPoundage() {
		return merOrderPoundage;
	}
	public void setMerOrderPoundage(String merOrderPoundage) {
		this.merOrderPoundage = merOrderPoundage;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getMerOrderPayState() {
		return merOrderPayState;
	}
	public void setMerOrderPayState(String merOrderPayState) {
		this.merOrderPayState = merOrderPayState;
	}
	public String getSettleFlag() {
		return settleFlag;
	}
	public void setSettleFlag(String settleFlag) {
		this.settleFlag = settleFlag;
	}
	public PayMsgResponse getPayMsg() {
		return payMsg;
	}
	public void setPayMsg(PayMsgResponse payMsg) {
		this.payMsg = payMsg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
