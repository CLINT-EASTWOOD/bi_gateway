package com.zmb.ua.bean.common;

public class UARequest {

	private UARequestHead head;
	private Object body;
	
	public UARequest() {
		this.head = new UARequestHead();
	}
	
	public UARequestHead getHead() {
		return head;
	}
	public void setHead(UARequestHead head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
