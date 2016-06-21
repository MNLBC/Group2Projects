package homeworkW1D5;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App2 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("#,###.0000000000000000");
      
      System.out.print("Input radius of ball: ");
      double r = input.nextDouble();
      double r3 = Math.pow(r, 3);
      double volume = (4 * Math.PI * r3) / 3;
      
      BigDecimal bdVolume = new BigDecimal(volume);
      System.out.println("");
      System.out.println("Volume of the ball is: " + df.format(bdVolume) + " cubic inches");
   }
}
