package com.mnl.app2.w1d5hw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class hw3 {

   public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
      Scanner scanner = new Scanner(System.in);
      StringBuffer sb = new StringBuffer();
      
      
      System.out.println("Enter a text");
      String input = scanner.next();
      
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(input.getBytes());
      
      byte byteData[] = md.digest();
      
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
