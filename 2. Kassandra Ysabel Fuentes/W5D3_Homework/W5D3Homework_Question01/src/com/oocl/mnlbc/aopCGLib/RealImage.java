package com.oocl.mnlbc.aopCGLib;

public class RealImage {//No implement Image

	   private String fileName;

	   public RealImage(String fileName){
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
