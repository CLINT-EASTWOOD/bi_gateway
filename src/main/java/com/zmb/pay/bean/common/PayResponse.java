package com.zmb.pay.bean.common;

public class PayResponse {

	private String returnCode;
	private String returnMsg;
	private Object body;
	
	public PayResponse() {
		this.returnCode = "";
		this.returnMsg = "";
	}
	
	public PayResponse(String returnCode, String returnMsg, Object body) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.body = body;
	}
	
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnMsg() {
		return returnMsg;
	}
	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
