package com.oocl.mnlbc.proxy2;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		ImageCglib cglib = new ImageCglib();
		BookFacade book = (BookFacade) cglib.getInstance(new RealBook());
		book.addBook();
	}

}
