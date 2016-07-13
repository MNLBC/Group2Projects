package com.oocl.mnlbc.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method; 
import java.lang.reflect.Proxy;

public class ProxyBook implements InvocationHandler {

	private Object obj;
	
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),  
				obj.getClass().getInterfaces(),this); 
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object result=null;  
        System.out.println("Before Invoke");  

        result=method.invoke(obj, args);  
        
        System.out.println("After Invoke");  
        return result;  
    } 
}
