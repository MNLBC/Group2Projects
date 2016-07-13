package com.oocl.mnlbc.aop;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodTimeCostInterceptor implements MethodInterceptor, Serializable {
//	protected static final Log logger = LogFactory.getLog(MethodTimeCostInterceptor.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		long time = System.currentTimeMillis();
		Object rval = invocation.proceed();
		time = System.currentTimeMillis() - time;
//		logger.info("Method Cost Time => " + time + " ms");
		return rval;
	}
}