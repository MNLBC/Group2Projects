package com.oocl.mnlbc.proxy.static1;

public class Main {
	public static void main(String[] args) {
	      BookFacade image = new Book("Literotica");

	      //image will be loaded from disk
	      image.addBook(); 
	      System.out.println("");
	      
	      //image will not be loaded from disk
	      image.addBook(); 	
	   }
}
