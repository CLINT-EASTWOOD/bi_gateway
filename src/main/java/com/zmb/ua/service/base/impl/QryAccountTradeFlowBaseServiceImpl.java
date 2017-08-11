package com.zmb.ua.service.base.impl;

import com.zmb.ua.service.base.IQryAccountTradeFlowBaseService;

public class QryAccountTradeFlowBaseServiceImpl implements IQryAccountTradeFlowBaseService {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<?> clazz = Class.forName("com.zmb.ua.service.base.impl.QryAccountTradeFlowBaseServiceImpl");
		System.out.println(clazz.getClass().getMethods());
		System.out.println(QryAccountTradeFlowBaseServiceImpl.class.getMethods());
	}
}
