package com.oocl.mnlbc.book.way3;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

public class ProxyBook implements InvocationHandler{

	private Object target;
    public Object bind(Object target) {  
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this); 
    } 
    
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object result=null;  
        System.out.println("Before Invoke");  

        result=method.invoke(target, args);  
        
        System.out.println("After Invoke");  
        return result;  
    } 
}
