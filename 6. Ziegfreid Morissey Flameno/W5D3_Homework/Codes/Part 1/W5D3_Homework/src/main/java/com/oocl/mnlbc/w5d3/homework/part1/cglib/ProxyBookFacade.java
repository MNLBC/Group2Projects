package com.oocl.mnlbc.w5d3.homework.part1.cglib;

/**
 * Book Facade Proxy
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class ProxyBookFacade implements BookFacade {

	private RealBookFacade realBookFacade;
	private String bookName;

	public ProxyBookFacade(String bookName) {
		this.bookName = bookName;
	}

	public void addBook() {
		if (realBookFacade == null) {
			realBookFacade = new RealBookFacade(bookName);
		}
		realBookFacade.addBook();
	}
}