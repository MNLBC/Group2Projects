package com.oocl.mnlbc.proxy.dynamic2;

public class Book implements BookFacade{
	
	private String bookName;

	public Book(String bookName) {
		this.bookName = bookName;
		getBook(bookName);
	}

	@Override
	public void addBook() {
		System.out.println("Adding book: " + bookName);
	}
	
	private void getBook(String bookName){
		System.out.print("Retrieved Book: " + bookName + "\n");
	}

}
