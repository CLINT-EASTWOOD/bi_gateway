package com.zmb.pay.service.base;

import com.zmb.pay.bean.common.PayResponse;

public interface IReceivePayOrderBaseService {

	public PayResponse receivePayOrderBaseService(Object biRequestBody, String salt);
}
