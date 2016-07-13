package com.oocl.mnlbc.aop;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
		   Book book = new ProxyBook("test_10mb.jpg");

	      book.display(); 
	      System.out.println("");
	      
	      book.display(); 	
	   }
}