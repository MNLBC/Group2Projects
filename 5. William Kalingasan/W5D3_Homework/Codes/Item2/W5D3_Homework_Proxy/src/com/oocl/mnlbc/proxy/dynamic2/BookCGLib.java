package com.oocl.mnlbc.proxy.dynamic2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookCGLib implements MethodInterceptor{
	private Object obj;

	public Object getInstance(Object target) {  
        this.obj = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.obj.getClass()); 
        enhancer.setCallback(this);   
        return enhancer.create(new Class[] {String.class}, new Object[] {new String("Playboy")});  
    }

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {    
        proxy.invokeSuper(obj, args);
        return null; 
    }

}
