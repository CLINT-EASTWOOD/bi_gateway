package com.zmb.bi.exception;

public class BaseResBean {

	private String respCode;
	private String respMsg;
	private String respData;
	private String reqData;
	private String resTransId;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public String getRespData() {
		return respData;
	}
	public void setRespData(String respData) {
		this.respData = respData;
	}
	public String getReqData() {
		return reqData;
	}
	public void setReqData(String reqData) {
		this.reqData = reqData;
	}
	public String getResTransId() {
		return resTransId;
	}
	public void setResTransId(String resTransId) {
		this.resTransId = resTransId;
	}
}
