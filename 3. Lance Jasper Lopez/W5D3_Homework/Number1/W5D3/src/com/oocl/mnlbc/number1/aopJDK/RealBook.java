package com.oocl.mnlbc.number1.aopJDK;

public class RealBook implements BookFacade {

	private String title;
	
	  public RealBook(String title){
	      this.title = title;
	      putIntoLibrary(title);
	   }
	
	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		  System.out.println("Added " + title);
	}

	

	   private void putIntoLibrary(String title){
	      System.out.println("Putting into Library " + title);
	   }
}
