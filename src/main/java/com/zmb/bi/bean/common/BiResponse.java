package com.zmb.bi.bean.common;

/**
 * @version		:	1.0
 * @description :	业务系统基类Response
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public class BiResponse {

	// 业务系统基类头部Response
	private BiResponseHead head;
	// 业务系统基类体Response
	private Object body;
	
	public BiResponse(BiRequest biRequest) {
		this.head = new BiResponseHead(biRequest.getHead().getChannel());
	}
	
	public BiResponseHead getHead() {
		return head;
	}
	public void setHead(BiResponseHead head) {
		this.head = head;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
