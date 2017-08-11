package com.zmb.pay.service.base;

import com.zmb.pay.bean.common.PayResponse;

public interface IQryPayRstForCommonBaseService {

	public PayResponse qryPayRstForCommonBaseService(Object biRequestBody, String salt);
}
