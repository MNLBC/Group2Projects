package com.oocl.mnlbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Number3 {

   public Number3() {
      // TODO Auto-generated constructor stub
   }

   /**
    * Main method
    * 
    * @param args
    * @throws NoSuchAlgorithmException
    * @throws FileNotFoundException
    */
   @SuppressWarnings("resource")
   public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
      // TODO Auto-generated method stub
      Scanner input1 = new Scanner(System.in);

      String text = "";

      System.out.print("Input text to be encrypted: ");
      text = input1.nextLine();

      PrintStream out = new PrintStream(new FileOutputStream("\\d:/digested-password.txt"));
      out.print("Output: " + encryptText(text));
      System.out.println("File created!");
   }

   /**
    * Encrypt text using MD5
    * 
    * @param text
    * @return Encrypted text
    * @throws NoSuchAlgorithmException
    */
   public static String encryptText(String text) throws NoSuchAlgorithmException {
      MessageDigest msgDigest = MessageDigest.getInstance("MD5");
      StringBuffer strBuffer = new StringBuffer();
      msgDigest.update(text.getBytes());
      byte byteData[] = msgDigest.digest();

      for (int i = 0; i < byteData.length; i++) {
         strBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
      }

      return strBuffer.toString();
   }
}
