package com.zmb.ua.bean.common;

public class UAResponse {

	private UAResponseHead head;
	private Object body;
	
	public UAResponse() {
		this.head = new UAResponseHead();
	}
	
	public UAResponse(UAResponseHead head, Object body) {
		this.head = head;
		this.body = body;
	}
	
	public UAResponseHead getHead() {
		return head;
	}
	public void setHead(UAResponseHead head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
