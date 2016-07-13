package com.oocl.mnlbc.proxy.dynamic2;

public class ProxyBook implements BookFacade {

	private Book book;
	private String bookName;

	public ProxyBook(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public void addBook() {
		if (book == null) {
			book = new Book(bookName);
		}
		book.addBook();
	}

}
