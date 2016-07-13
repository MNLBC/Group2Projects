package com.oocl.mnlbc.number1.aopCGLib;

public class ProxyBook implements BookFacade{

	   private RealBook realBook;
	   private String title;

	   public ProxyBook(String title){
	      this.title = title;
	   }


	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		 if(realBook == null){
	         realBook = new RealBook(title);
	      }
	      realBook.addBook();
	}
}