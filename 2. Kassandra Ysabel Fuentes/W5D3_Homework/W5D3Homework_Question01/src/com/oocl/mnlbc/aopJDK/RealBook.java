package com.oocl.mnlbc.aopJDK;

public class RealBook implements Book {

	   private String fileName;

	   public RealBook(String fileName){
	      this.fileName = fileName;
	      loadFromDisk(fileName);
	   }

	   public void display() {
	      System.out.println("Displaying " + fileName);
	   }

	   private void loadFromDisk(String fileName){
	      System.out.println("Loading " + fileName);
	   }
}
