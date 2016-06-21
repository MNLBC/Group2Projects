package com.mnl.app2.w1d3hw;

import java.util.Scanner;

public class App {
   public static int finalvalue = 1;
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter int value: ");
      int value = input.nextInt();
      System.out.println(value + "! is " + Factorial(value));
   }
   
   public static int Factorial(int factorialvalue){
      for(int i = 1; i <= factorialvalue; i++){
         finalvalue = finalvalue * i;
      }
      return finalvalue;
   }

}
