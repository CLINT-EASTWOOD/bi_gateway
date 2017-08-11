package com.zmb.bi.bean.common;

/**
 * @version		:	1.0
 * @description :	业务系统基类Request
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public class BiRequest {

	// 业务系统基类头部Request
	private BiRequestHead head;
	// 业务系统基类体Request
	private Object body;
	
	public BiRequestHead getHead() {
		return head;
	}
	public void setHead(BiRequestHead head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
