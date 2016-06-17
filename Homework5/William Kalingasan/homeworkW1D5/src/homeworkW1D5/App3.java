package homeworkW1D5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class App3 {

   public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter text: ");
      StringBuffer sb = new StringBuffer(input.next());
      String message = sb.toString();
      
      MessageDigest m = MessageDigest.getInstance("MD5");
      m.reset();
      m.update(message.getBytes());
      byte[] digest = m.digest();
      BigInteger bigInt = new BigInteger(1,digest);
      String hashtext = bigInt.toString(16);
      while(hashtext.length() < 32 ){
        hashtext = "0"+hashtext;
      }
      
      BufferedWriter out = new BufferedWriter(new FileWriter("digested-password.txt"));
      out.write(hashtext);
      out.close();
      System.out.println("Text saved and encrypted in digested-password.txt");
   }

}
