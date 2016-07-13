package com.oocl.mnlbc.number1.aopCGLib;


public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
//	     BookFacade book = new ProxyBook("Just One Day");
//
//	      //image will be loaded from disk
//	      book.addBook(); 
//	      System.out.println("");
//	      
//	      //image will not be loaded from disk
//	      book.addBook(); 	
//	      
	      BookCglib cglib=new BookCglib();  
	       BookFacade book=(BookFacade)cglib.getInstance(new RealBook("Just One Day"));  
	       book.addBook();
	   }
}