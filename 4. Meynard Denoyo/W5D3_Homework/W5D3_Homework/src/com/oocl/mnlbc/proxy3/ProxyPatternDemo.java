package com.oocl.mnlbc.proxy3;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		ProxyBook book = new ProxyBook();
		BookFacade bookProxy = (BookFacade) book.bind(new RealBook("Twilight"));

		bookProxy.addBook();
	}
}
