package com.oocl.mnlbc.proxy1;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		BookFacade book = new ProxyBook("Harry Potter");

		book.addBook();
		System.out.println("");
		book.addBook();
	}
}
