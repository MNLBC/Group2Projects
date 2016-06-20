package com.oocl.mnlbc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Number1 {

   public Number1() {
      // TODO Auto-generated constructor stub
   }

   /**
    * Main transaction
    * 
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // "2016.06.17 Fri 13:49:05".

      Date today = new Date();
      String date = "";
      String day = "";
      SimpleDateFormat formatter;
      Calendar cal = Calendar.getInstance();
      String pattern = "yyyy.MM.dd EEE HH:mm:ss";

      // Date Implementation
      formatter = new SimpleDateFormat(pattern);
      date = formatter.format(today);

      // Calendar Implementation
      day = new SimpleDateFormat("EEE").format(cal.getTime());
      System.out.println("Time of log in: " + date);
      System.out.println("====================");
      System.out.print("Day: " + day);
      System.out.println(" || Appointments for today: " + checkSchedule(day));
   }

   /**
    * Check your schedule
    * 
    * @param day
    * @return appointment for that day
    */
   public static String checkSchedule(String day) {
      switch (day) {
         case "Mon":
            return "No appointment has been made";
         case "Tue":
            return "Attending a conference";
         case "Wed":
            return "No appointment has been made";
         case "Thu":
            return "No appointment has been made";
         case "Fri":
            return "Attending a conference";
         case "Sat":
            return "No appointment has been made";
         case "Sun":
            return "No appointment has been made";
         default:
            return "";
      }
   }
}
