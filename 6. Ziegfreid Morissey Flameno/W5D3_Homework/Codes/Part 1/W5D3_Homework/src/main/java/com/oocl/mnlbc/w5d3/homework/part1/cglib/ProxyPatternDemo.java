package com.oocl.mnlbc.w5d3.homework.part1.cglib;

/**
 * Proxy Pattern Demo (run this)
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {

		// CGLib
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacade book = (BookFacade) cglib.getInstance(new RealBookFacade());
		book.addBook();
	}
}