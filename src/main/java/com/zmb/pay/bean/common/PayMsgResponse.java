package com.zmb.pay.bean.common;

public class PayMsgResponse {
	
	private String bankCardNo;
	private String bankCode;
	private String bankName;
	private String bankAcctCdFlag;
	private String payTypeCode;
	
	public String getBankCardNo() {
		return bankCardNo;
	}
	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAcctCdFlag() {
		return bankAcctCdFlag;
	}
	public void setBankAcctCdFlag(String bankAcctCdFlag) {
		this.bankAcctCdFlag = bankAcctCdFlag;
	}
	public String getPayTypeCode() {
		return payTypeCode;
	}
	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}
}
