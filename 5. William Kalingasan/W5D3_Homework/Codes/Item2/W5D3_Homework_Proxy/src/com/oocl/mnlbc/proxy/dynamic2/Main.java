package com.oocl.mnlbc.proxy.dynamic2;

public class Main {

	public static void main(String[] args) {
		BookCGLib cglib = new BookCGLib();
		BookFacade book = (BookFacade) cglib.getInstance(new Book("FHM"));
		book.addBook();
		BookFacade book2 = (BookFacade) cglib.getInstance(new Book("Hustler"));
		book.addBook();
	}
}
