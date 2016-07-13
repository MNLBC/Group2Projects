package com.oocl.mnlbc.book.way1;

public class RealBook {
public String bookname;
	
	public RealBook(String bookname){
		this.bookname = bookname;
		addToLibrary(bookname);
	}
	
	public void display(){
		System.out.println("Added " + bookname + " to library");
	}
	
	public void addToLibrary(String bookname){
		System.out.println("Adding " + bookname + " to library");
	}

}
