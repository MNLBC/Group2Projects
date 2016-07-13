package com.oocl.mnlbc.number1.aopCGLib;

import java.lang.reflect.Method;  

import net.sf.cglib.proxy.Enhancer;  
import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  
  
/** 
 * 使用cglib动态代理 
 *  
 * @author student 
 *  
 */  
public class BookCglib implements MethodInterceptor {  
    private Object target;  
  
    /** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create(new Class[] {String.class}, new Object[] {new String("Just One Month")}) ;
    }  
  
      
    // 回调方法  
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
//        System.out.println("事物开始");  
        proxy.invokeSuper(obj, args);  
//        System.out.println("事物结束");  
        return null;  
  
  
    }  
  
}  