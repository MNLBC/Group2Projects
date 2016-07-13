package com.oocl.mnlbc.book.way1;

public class ProxyPattern {
	public static void main(String[] args){
		BookFacade book = new ProxyBook("Harry Potter");
		
		book.addBook();
		System.out.println("");
		book.addBook();
	}

}
