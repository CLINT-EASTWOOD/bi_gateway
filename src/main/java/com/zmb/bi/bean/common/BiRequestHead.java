package com.zmb.bi.bean.common;

/**
 * @version		:	1.0
 * @description :	业务系统基类头部Request
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public class BiRequestHead {

	// 交易日期
	private String tranDate;
	// 交易时间
	private String tranTime;
	// 接口URL
	private String interfaceUrl;
	// 渠道编码
	private String channel;
	// 全局流水号
	private String globalSeqNo;
	// 签名
	private String sign;
	
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranTime() {
		return tranTime;
	}
	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}
	public String getInterfaceUrl() {
		return interfaceUrl;
	}
	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getGlobalSeqNo() {
		return globalSeqNo;
	}
	public void setGlobalSeqNo(String globalSeqNo) {
		this.globalSeqNo = globalSeqNo;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
}
