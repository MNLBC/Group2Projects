package com.oocl.ITA.w1d5Homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {
	   public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
		      Scanner scanner = new Scanner(System.in);
		      StringBuffer sb = new StringBuffer();
		      
		      
		      System.out.println("Enter a secret message: ");
		      String input = scanner.next();
		      
		      MessageDigest hash = MessageDigest.getInstance("MD5");
		      hash.update(input.getBytes());
		      
		      byte byteData[] = hash.digest();
		      
		      for (int i = 0; i < byteData.length; i++) {
		         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		      }
		      
		      System.out.println(sb.toString());
		      
		      BufferedWriter br = new BufferedWriter(new FileWriter("digested-password.txt"));
		      br.write(sb.toString());
		      br.close();
		      
		      System.out.println("digested-password.txt created");
		   }
}
