package com.oocl.mnlbc.book.way2;

public class ProxyPattern {
	
	public static void main(String [] args){
		ImageCglib cglib=new ImageCglib();  
		BookFacade book=(BookFacade)cglib.getInstance(new RealBook("The Fault In Our Stars"));  
	    book.addBook();
	}
	
}



