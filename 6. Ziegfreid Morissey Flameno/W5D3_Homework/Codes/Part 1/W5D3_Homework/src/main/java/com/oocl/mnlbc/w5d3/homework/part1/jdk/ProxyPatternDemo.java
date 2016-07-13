package com.oocl.mnlbc.w5d3.homework.part1.jdk;

/**
 * Proxy Pattern Demo (run this)
 * 
 * @author FLAMEZI2
 * @since 2016-07-13
 */
public class ProxyPatternDemo {

	public static void main(String[] args) {

		ProxyBookFacade proxy = new ProxyBookFacade();
		BookFacade bookProxy = (BookFacade) proxy.bind(new RealBookFacade("Book Sample 3"));

		bookProxy.addBook();

	}
}