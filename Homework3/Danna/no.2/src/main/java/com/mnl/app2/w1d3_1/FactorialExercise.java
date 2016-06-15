package com.mnl.app2.w1d3_1;

import java.util.Scanner;

public class FactorialExercise {

   public static int fact;
   public static int finalnum = 1;

   public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in);

      System.out.println("Enter an integer: ");
      int UserInput = input.nextInt();
      System.out.println(UserInput + "! of is " + Factorial(UserInput));
   }

   public static int Factorial(int fact) {
      FactorialExercise.fact = fact;
      for (int i = 1; i <= fact; i++) {
         finalnum = finalnum * i;
      }
      return finalnum;
   }

}