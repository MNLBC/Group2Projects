package com.oocl.mnlbc.w5d3.homework.part1.staticproxy;

/**
 * Proxy Pattern Demo (run this)
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {
		BookFacade book = new ProxyBookFacade("Book Sample");

		// image will be loaded from disk
		book.addBook();
		System.out.println("");

		// image will not be loaded from disk
		book.addBook();
	}
}