package com.oocl.mnlbc.proxy3;

public class RealBook implements BookFacade {

	public String bookname;

	public RealBook(String bookname) {
		this.bookname = bookname;
		addToLibrary(bookname);
	}

	public void addBook() {
		System.out.println("Added " + bookname + " to library");
	}

	public void addToLibrary(String bookname) {
		System.out.println("Adding " + bookname + " to library");
	}
}
