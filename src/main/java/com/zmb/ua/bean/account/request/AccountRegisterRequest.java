package com.zmb.ua.bean.account.request;

public class AccountRegisterRequest {

	private String subaccId;
	private String account;
	private String state;
	private String uid;
	private String belongOrg;
	private String belongType;
	private String openDate;
	
	public String getSubaccId() {
		return subaccId;
	}
	public void setSubaccId(String subaccId) {
		this.subaccId = subaccId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBelongOrg() {
		return belongOrg;
	}
	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}
	public String getBelongType() {
		return belongType;
	}
	public void setBelongType(String belongType) {
		this.belongType = belongType;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
}
