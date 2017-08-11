package com.zmb.bi.bean.constant;

/**
 * @version		:	1.0
 * @description :	响应返回枚举值
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public enum RtnRespEnum {

	SUCCESS("00000000", "成功"),
	FAILURE("11111111", "失败"),
	UNKNOW("33333333", "系统异常");

	// 交易返回码
	private String code;
	// 交易返回信息
	private String msg;

	private RtnRespEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String toString() {
		return "{\"code\":\"" + this.getCode() + "\",\"msg\":\"" + this.getMsg() + "\"}";
	}
}
