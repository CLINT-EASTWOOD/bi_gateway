package com.zmb.ua.bean.account.request;

public class QryAccountTradeFlowRequest {

	private String uid;
	private String pid;
	private int tranChannel;
	private int payType;
	private int paySubType;
	private String inOrOut;
	private int state;
	private String startTime;
	private String endTime;
	private int startPos;
	private int limit;
	private String orderBy;
	
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
	public int getTranChannel() {
		return tranChannel;
	}
	public void setTranChannel(int tranChannel) {
		this.tranChannel = tranChannel;
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
	public String getInOrOut() {
		return inOrOut;
	}
	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getStartPos() {
		return startPos;
	}
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
}
