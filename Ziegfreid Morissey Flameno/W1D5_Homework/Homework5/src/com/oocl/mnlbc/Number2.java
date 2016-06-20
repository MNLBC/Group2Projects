package com.oocl.mnlbc;

import java.math.BigDecimal;
import java.util.Scanner;

public class Number2 {

   public Number2() {
      // TODO Auto-generated constructor stub
   }

   /**
    * Main method
    * 
    * @param args
    */
   @SuppressWarnings("resource")
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      double r = 0;
      Scanner input1 = new Scanner(System.in);

      System.out.print("Enter the radius of the ball: ");
      try {
         r = input1.nextDouble();
      } catch (Exception e) {
         System.out.println("Invalid input");
      }
      System.out.println("The volume of the ball is: " + getVolume(r));
   }

   /**
    * Get volume of the ball
    * 
    * @param r
    * @return volume of the ball
    */
   public static BigDecimal getVolume(double r) {
      BigDecimal pi = new BigDecimal("3.1415926535897932");
      return (pi.multiply(new BigDecimal((4.0 / 3.0)))).multiply(new BigDecimal(Math.pow(r, 3)));

   }

}
