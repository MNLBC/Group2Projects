package W1D5Homework;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculateVolume 
{

   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      BigDecimal radius = new BigDecimal(0);
      BigDecimal  pi = new BigDecimal(3.1415926535897932);
      BigDecimal  fraction = new BigDecimal(1.3333333333333333);
      
      System.out.println("Enter radius of sphere: ");
      radius = scanner.nextBigDecimal();
      
      BigDecimal answer = pi.multiply(radius.pow(3));
      BigDecimal finalAnswer = fraction.multiply(answer);
      BigDecimal formatAnswer = finalAnswer.setScale(16, BigDecimal.ROUND_DOWN);
      System.out.println("\nVolume is " + formatAnswer);
      
   }

}
