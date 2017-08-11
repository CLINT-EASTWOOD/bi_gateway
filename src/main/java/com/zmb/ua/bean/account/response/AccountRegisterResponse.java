package com.zmb.ua.bean.account.response;

public class AccountRegisterResponse {
	
	private String pid;
	private String uid;
	private String state;
	private String subaccId;
	private String account;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSubacctId() {
		return subaccId;
	}
	public void setSubacctId(String subacctId) {
		this.subaccId = subacctId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
