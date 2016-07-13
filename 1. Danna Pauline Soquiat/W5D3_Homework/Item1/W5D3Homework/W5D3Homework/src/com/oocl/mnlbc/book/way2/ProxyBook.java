package com.oocl.mnlbc.book.way2;

public class ProxyBook implements BookFacade{

	public RealBook realbook;
	public String bookname;
	
	public ProxyBook(String bookname){
		this.bookname = bookname;
	}

	@Override
	public void addBook() {
		if(realbook == null){
			realbook = new RealBook(bookname);
		}
		realbook.display();
	}
	
}

