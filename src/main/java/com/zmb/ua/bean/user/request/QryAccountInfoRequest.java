package com.zmb.ua.bean.user.request;

public class QryAccountInfoRequest {

	private String pid;
	private String uid;
	private String subaccId;
	private String belongOrg;
	private String belongType;
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
	public String getSubaccId() {
		return subaccId;
	}
	public void setSubaccId(String subaccId) {
		this.subaccId = subaccId;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
}
