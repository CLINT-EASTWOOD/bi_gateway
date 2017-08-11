package com.zmb.pay.bean.request;

public class QryPayRstForCommonRequest {
	
	private String apiVersion;
	private String fromSysCode;
	private String merId;
	private String merOrderId;
	private String reqTime;
	private String sign;
	
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getFromSysCode() {
		return fromSysCode;
	}
	public void setFromSysCode(String fromSysCode) {
		this.fromSysCode = fromSysCode;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getMerOrderId() {
		return merOrderId;
	}
	public void setMerOrderId(String merOrderId) {
		this.merOrderId = merOrderId;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
