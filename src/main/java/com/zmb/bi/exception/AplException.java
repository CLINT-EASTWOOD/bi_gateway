package com.zmb.bi.exception;

/**
 * @version		:	1.0
 * @description :	账户系统控制器
 * @author		:	zhangqiang
 * @updateAuthor:
 * @date		:	2016-06-01 11:30
 * @updateDate	:
 * @comments	:	
 */
public class AplException extends RuntimeException {
	
	private static final long serialVersionUID = 388531213262953478L;

	// 错误代码
	private String errCode = "";
	// 错误信息
	private String errMsg = "";

	public AplException(String errCode) {
		super(errCode);
		this.errCode = errCode;
	}

	public AplException(String errCode, String errMsg) {
		super(errCode);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public AplException() {
	}

	public AplException(String errCode, Throwable cause) {
		super(errCode, cause);
		this.errCode = errCode;
	}

	public AplException(String errCode, String errMsg, Throwable cause) {
		super(errCode, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public AplException(Throwable cause) {
		super(cause);
	}

	public String getErrMsg() {
		return this.errMsg;
	}
}