package W1D5Homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class OutputFile 
{

   public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException
   {

      Scanner scanner = new Scanner(System.in);
      String textEncrypt;

      System.out.print("Enter text to encrypt: ");
      textEncrypt = scanner.nextLine();

      PrintStream out = new PrintStream(new FileOutputStream("\\d:/digested-password.txt"));
      out.print("Output: " + encryptText(textEncrypt));
      System.out.println("File created!");
   }

   public static String encryptText(String encrypt) throws NoSuchAlgorithmException {
      MessageDigest msgDigest = MessageDigest.getInstance("MD5");
      StringBuffer stringBuffer = new StringBuffer();
      msgDigest.update(encrypt.getBytes());
      byte byteData[] = msgDigest.digest();

      for (int j = 0; j < byteData.length; j++) {
         stringBuffer.append(Integer.toString((byteData[j] & 0xff) + 0x100, 16).substring(1));
      }

      return stringBuffer.toString();
   }
}
