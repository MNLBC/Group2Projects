package com.oocl.mnlbc.aopCGLib;

import com.oocl.mnlbc.aopJDK.RealBook;

public class ProxyPatternDemo {
	
	   public static void main(String[] args) {

		   BookCglib cglib=new BookCglib();  
		   Book book=(Book)cglib.getInstance(new RealBook("The Geography of You and Me"));  
	       book.display();
	   }
}