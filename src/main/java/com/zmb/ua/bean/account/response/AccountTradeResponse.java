package com.zmb.ua.bean.account.response;

public class AccountTradeResponse {
	
	private String uid;
	private String pid;
	private int amount;
	private String tranSeqNo;
	private String globalSeqNo;
	
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTranSeqNo() {
		return tranSeqNo;
	}
	public void setTranSeqNo(String tranSeqNo) {
		this.tranSeqNo = tranSeqNo;
	}
	public String getGlobalSeqNo() {
		return globalSeqNo;
	}
	public void setGlobalSeqNo(String globalSeqNo) {
		this.globalSeqNo = globalSeqNo;
	}
}
