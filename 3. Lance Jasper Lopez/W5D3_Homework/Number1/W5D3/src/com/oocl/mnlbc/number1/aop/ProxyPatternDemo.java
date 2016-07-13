package com.oocl.mnlbc.number1.aop;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
	     BookFacade book = new ProxyBook("Just One Day");

	      //image will be loaded from disk
	      book.addBook(); 
	      System.out.println("");
	      
	      //image will not be loaded from disk
	      book.addBook(); 	
	   }
}