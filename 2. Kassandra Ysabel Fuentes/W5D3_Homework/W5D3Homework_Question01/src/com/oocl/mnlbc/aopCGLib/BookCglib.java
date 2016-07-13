package com.oocl.mnlbc.aopCGLib;

import java.lang.reflect.Method;  

import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  
  
/** 
 *  
 * @author student 
 *  
 */  
public class BookCglib implements MethodInterceptor {  
    private Object target;  
  
    /** 
     * 
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
     
        enhancer.setCallback(this);  

        return enhancer.create();  
    }  
  
      
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("Output 1");  
        proxy.invokeSuper(obj, args);  
        System.out.println("Output 2");  
        return null;  
  
  
    }  
  
}  