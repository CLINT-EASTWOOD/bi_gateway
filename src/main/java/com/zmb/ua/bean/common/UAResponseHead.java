package com.zmb.ua.bean.common;

public class UAResponseHead {

	private String tranDate;
	private String tranTime;
	private String backSeqNo;
	private String backSysId;
	private String returnCode;
	private String returnMsg;
	private String externalSeqNo;
	
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getBackSeqNo() {
		return backSeqNo;
	}
	public void setBackSeqNo(String backSeqNo) {
		this.backSeqNo = backSeqNo;
	}
	public String getBackSysId() {
		return backSysId;
	}
	public void setBackSysId(String backSysId) {
		this.backSysId = backSysId;
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
	public String getExternalSeqNo() {
		return externalSeqNo;
	}
	public void setExternalSeqNo(String externalSeqNo) {
		this.externalSeqNo = externalSeqNo;
	}
}
