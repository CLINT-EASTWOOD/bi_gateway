package com.zmb.ua.bean.account.request;

public class AccountTradeRequest {
	
	private String uid;
	private String pid;
	private int tradeMode;
	private int subaccId;
	private String tradeId;
	private int payType;
	private int paySubType;
	private String fundsFrom;
	private String fundsTo;
	private int amount;
	private String remark;
	private String tradeTime;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getTradeMode() {
		return tradeMode;
	}
	public void setTradeMode(int tradeMode) {
		this.tradeMode = tradeMode;
	}
	public int getSubaccId() {
		return subaccId;
	}
	public void setSubaccId(int subaccId) {
		this.subaccId = subaccId;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
	}
	public int getPaySubType() {
		return paySubType;
	}
	public void setPaySubType(int paySubType) {
		this.paySubType = paySubType;
	}
	public String getFundsFrom() {
		return fundsFrom;
	}
	public void setFundsFrom(String fundsFrom) {
		this.fundsFrom = fundsFrom;
	}
	public String getFundsTo() {
		return fundsTo;
	}
	public void setFundsTo(String fundsTo) {
		this.fundsTo = fundsTo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
}
