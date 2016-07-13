package com.oocl.mnlbc.number1.aopJDK;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {
		   
		ProxyBook book = new ProxyBook();  
        BookFacade bookProxy = (BookFacade) book.bind(new RealBook("Just One Month"));  
        
        bookProxy.addBook();
        
//	      Image image = new ProxyImage("test_10mb.jpg");
//
//	      //image will be loaded from disk
//	      image.display(); 
//	      System.out.println("");
//	      
//	      //image will not be loaded from disk
//	      image.display(); 	
	   }
}