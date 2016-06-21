package com.oocl.ITA.w1d5Homework;

import java.util.Calendar;
import java.util.Scanner;

public class CurrentDate {


		   public static void main(String[] args) {
			   
			   System.out.println("Welcome to Task Reminder!");
		      Calendar dt = Calendar.getInstance();
		      java.util.Date currentdate =  (dt.getTime());
		      int dayofweek = dt.get(dt.DAY_OF_WEEK);
		      
		      System.out.println(currentdate);
		      switch (dayofweek){
		         case 1: {
		            System.out.println("Today is Sunday");
		            System.out.println("You have no planned activity");
		            break;
		         }
		         case 2: {
		            System.out.println("Today is Monday");
		            System.out.println("Go to work");
		            System.out.println("Go to Gym at 7pm");
		            break;
		         }
		         case 3: {
		            System.out.println("Today is Tuesday");
		            System.out.println("Go to work");
		            System.out.println("Watch Movie at 8pm");
		            break;
		         }
		         case 4: {
		            System.out.println("Today is Wednesday");
		            System.out.println("Go to work");
		            System.out.println("You have a meeting at 3pm");
		            break;
		         }
		         case 5: {
		            System.out.println("Today is Thursday");
		            System.out.println("You have a flight at 10am");
		            break;
		         }
		         case 6: {
		            System.out.println("Today is Friday");
		            System.out.println("Do whatever you want");
		            break;
		         }
		         case 7: {
		            System.out.println("Today is Saturday");
		            System.out.println("Go shopping");
		            break;
		         }
		      }
		   }
		}