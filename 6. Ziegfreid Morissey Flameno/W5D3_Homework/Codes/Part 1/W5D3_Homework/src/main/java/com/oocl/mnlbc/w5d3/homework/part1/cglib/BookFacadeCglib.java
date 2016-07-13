package com.oocl.mnlbc.w5d3.homework.part1.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Book Facade CGLib Proxy
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class BookFacadeCglib implements MethodInterceptor {
	private Object target;

	/**
	 * Get Instance method
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());

		enhancer.setCallback(this);

		return enhancer.create(new Class[] { String.class }, new Object[] { new String("Book Sample 2") });
	}

	/**
	 * interceptor method
	 */
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Before Invoke");
		proxy.invokeSuper(obj, args);
		System.out.println("After Invoke");
		return null;

	}

}