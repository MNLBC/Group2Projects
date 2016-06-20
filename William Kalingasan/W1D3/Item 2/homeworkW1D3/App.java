package com.oocl.mnlbc.homeworkW1D3;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter int value: ");
        int value = input.nextInt();
        System.out.println(value + "! is " + factorial(value));
        
    }
    
    public static int factorial(int x){
       int value = 1;
       for(int i =1; i <= x; i++){
          value = value * i;
       }
       return value;
    }
}
