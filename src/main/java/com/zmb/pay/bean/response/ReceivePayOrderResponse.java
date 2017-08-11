package com.zmb.pay.bean.response;

public class ReceivePayOrderResponse {
	
	private String platPayFlowNo;
	private String gwPaySubmitBankFormCode;
	private String payUrl;
	
	public String getPlatPayFlowNo() {
		return platPayFlowNo;
	}
	public void setPlatPayFlowNo(String platPayFlowNo) {
		this.platPayFlowNo = platPayFlowNo;
	}
	public String getGwPaySubmitBankFormCode() {
		return gwPaySubmitBankFormCode;
	}
	public void setGwPaySubmitBankFormCode(String gwPaySubmitBankFormCode) {
		this.gwPaySubmitBankFormCode = gwPaySubmitBankFormCode;
	}
	public String getPayUrl() {
		return payUrl;
	}
	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}
}
