package com.garyhu.intercept;

import java.util.Date;

import com.garyhu.action.ProductAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DateInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ProductAction action = (ProductAction)invocation.getAction();
		action.setDate(new Date());
		return invocation.invoke();
	}

}
