package com.oocl.mnlbc.aopJDK;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
		   
		ProxyBook proxy = new ProxyBook();  
        Book bookProxy = (Book) proxy.bind(new RealBook("The Unbecoming of Mara Dyer"));  
        
        bookProxy.display();
        
	   }
}