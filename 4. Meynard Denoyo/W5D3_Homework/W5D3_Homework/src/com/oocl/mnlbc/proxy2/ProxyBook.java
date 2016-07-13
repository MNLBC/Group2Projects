package com.oocl.mnlbc.proxy2;

import com.oocl.mnlbc.proxy2.BookFacade;
import com.oocl.mnlbc.proxy2.RealBook;

public class ProxyBook implements BookFacade {

	public RealBook realbook;
	public String bookname;

	public ProxyBook(String bookname) {
		this.bookname = bookname;
	}

	@Override
	public void addBook() {
		if (realbook == null) {
			realbook = new RealBook(bookname);
		}
		realbook.addBook();
	}

}
