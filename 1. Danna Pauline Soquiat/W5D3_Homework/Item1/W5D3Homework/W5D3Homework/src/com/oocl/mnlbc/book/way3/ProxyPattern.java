package com.oocl.mnlbc.book.way3;

public class ProxyPattern {
	public static void main(String[] args){
		ProxyBook book = new ProxyBook();  
        BookFacade bookProxy = (BookFacade)book.bind(new RealBook("The fault in our stars"));  
        
        bookProxy.addBook();
	}
}


