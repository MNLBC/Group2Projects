package com.mnl.app2.w1d5hw;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class hw1 {

   public static void main(String[] args) {
      Calendar date = Calendar.getInstance();
      Date currentdate = date.getTime();
      int dayofweek = date.get(date.DAY_OF_WEEK);
      
      System.out.println(currentdate);
      switch (dayofweek){
         case 1: {
            System.out.println("Today is Sunday");
            System.out.println("Go to Church");
            break;
         }
         case 2: {
            System.out.println("Today is Monday");
            System.out.println("Clean house");
            break;
         }
         case 3: {
            System.out.println("Today is Tuesday");
            System.out.println("Go to school");
            break;
         }
         case 4: {
            System.out.println("Today is Wednesday");
            System.out.println("Do your Homework");
            break;
         }
         case 5: {
            System.out.println("Today is Thursday");
            System.out.println("Do nothing");
            break;
         }
         case 6: {
            System.out.println("Today is Friday");
            System.out.println("Play Video Games");
            break;
         }
         case 7: {
            System.out.println("Today is Saturday");
            System.out.println("Have some rest");
            break;
         }
      }
   }
}
