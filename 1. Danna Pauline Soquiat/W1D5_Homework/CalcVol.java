package com.oocl.ITA.w1d5Homework;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalcVol {

	public static void main(String[] args) {
	
			    System.out.println("Welcome To Ball Volume Calculator!");
				
				Double radius =30.0 ;
				
				System.out.println("Ball radius is " + radius);
				System.out.println("Calculating radius and volume...");
				
			      Double volume = (4 * Math.PI * radius) / 3;
			      DecimalFormat decimalFormat = new DecimalFormat("#,###.0000000000000000");
			      
			      System.out.println("Radius is: " + radius);
			      System.out.println("Volume is: " + decimalFormat.format(volume));

	}

}
