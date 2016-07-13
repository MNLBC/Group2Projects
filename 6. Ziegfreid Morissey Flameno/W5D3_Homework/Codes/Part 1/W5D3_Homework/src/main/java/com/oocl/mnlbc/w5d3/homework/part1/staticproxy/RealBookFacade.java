package com.oocl.mnlbc.w5d3.homework.part1.staticproxy;

/**
 * Real Book Facade
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class RealBookFacade implements BookFacade {

	private String bookName;

	public RealBookFacade(String bookName) {
		this.bookName = bookName;
		retrieveBook(bookName);
	}

	private void retrieveBook(String bookName) {
		System.out.println("Loading " + bookName);
	}

	public void addBook() {
		System.out.println("Adding book: " + bookName);

	}
}
