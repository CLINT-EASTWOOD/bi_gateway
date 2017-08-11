package com.zmb.bi.bean.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zmb.bi.bean.constant.RtnRespEnum;

/**
 * @version		:	1.0
 * @description :	业务系统基类头部Response
 * @author		:	wangyizhuo
 * @updateAuthor:
 * @date		:	2017-06-20 11:30
 * @updateDate	:
 * @comments	:	
 */
public class BiResponseHead {

	// 交易日期
	private String tranDate;
	// 交易时间
	private String tranTime;
	// 渠道编码
	private String channel;
	// 全局流水号
	private String globalSeqNo;
	// 签名
	private String sign;
	// 返回码
	private String rtnCode;
	// 返回信息
	private String rtnMsg;
	
	public BiResponseHead() {
		this.tranDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		this.tranTime = new SimpleDateFormat("HHmmssSSS").format(new Date());
		this.globalSeqNo = "";
		this.rtnCode = RtnRespEnum.FAILURE.getCode();
		this.rtnMsg = RtnRespEnum.FAILURE.getMsg();
	}
	
	public BiResponseHead(String channel) {
		this.tranDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		this.tranTime = new SimpleDateFormat("HHmmssSSS").format(new Date());
		this.channel = channel;
		this.globalSeqNo = "";
		this.rtnCode = RtnRespEnum.FAILURE.getCode();
		this.rtnMsg = RtnRespEnum.FAILURE.getMsg();
	}
	
	public BiResponseHead(String channel, String globalSeqNo) {
		this.tranDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		this.tranTime = new SimpleDateFormat("HHmmssSSS").format(new Date());
		this.channel = channel;
		this.globalSeqNo = globalSeqNo;
		this.rtnCode = RtnRespEnum.FAILURE.getCode();
		this.rtnMsg = RtnRespEnum.FAILURE.getMsg();
	}
	
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
	public String getRtnCode() {
		return rtnCode;
	}
	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}
	public String getRtnMsg() {
		return rtnMsg;
	}
	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}
}
