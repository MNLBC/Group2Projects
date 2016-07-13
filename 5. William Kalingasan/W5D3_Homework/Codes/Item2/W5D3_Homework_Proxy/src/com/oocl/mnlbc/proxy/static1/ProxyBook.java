package com.oocl.mnlbc.proxy.static1;

public class ProxyBook {

	   private Book book;
	   private String bookName;

	   public ProxyBook(String bookName){
	      this.bookName = bookName;
	   }

	   public void addBook() {
	      if(book == null){
	    	  book = new Book(bookName);
	      }
	      book.addBook();
	   }
}
