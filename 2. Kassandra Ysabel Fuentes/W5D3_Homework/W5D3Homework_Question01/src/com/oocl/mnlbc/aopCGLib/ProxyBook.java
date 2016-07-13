package com.oocl.mnlbc.aopCGLib;

import com.oocl.mnlbc.aopJDK.RealBook;

public class ProxyBook implements Book{

	   private RealBook realBook;
	   private String fileName;

	   public ProxyBook(String fileName){
	      this.fileName = fileName;
	   }

	   public void display() {
	      if(realBook == null){
	    	  realBook = new RealBook(fileName);
	      }
	      realBook.display();
	   }
}