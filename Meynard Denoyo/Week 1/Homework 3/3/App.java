package com.mnl.app2.w1d3hw3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
   static String regex;
   public static void main(String[] args) {
      System.out.println(isEmail("a@y.com"));
   }
   public static boolean isEmail(String emailadd){
      regex = "^([A-Za-z0-9_.]+)@([A-Za-z0-9]+).([A-Za-z0-9]+)$";
      
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(emailadd);
      if(m.find()){
         return true;
      }else{
         return false;
      }
   }
   
   public static boolean isPhone(String phonenum){
      regex = "^09[0-9]{9}$";
      
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(phonenum);
      if(m.find()){
         return true;
      }else{
         return false;
      }
   }
   
   public static String replaceLetterA(String word){
      regex = "[a,A]";
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(word);
      if(m.find()){
         word = word.replaceAll("a", "A");
      }
      return word;
//      String newword = word.replaceAll("a", "A");
//      return newword;
   }
   
   public static String getMonth(String time){
      regex = "^[A-Za-z]{3}\\s((Jan)|(Feb)|(Mar)|(Apr)|(May)|(Jun)|(Jul)|(Aug)|(Sep)|(Oct)|(Nov)|(Dec))\\s[0-9]{2}\\s[0-9]{2}:[0-9]{2}:[0-9]{2}\\sCST\\s[0-9]{4}$";
      
      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(time);
      if(m.find()){
         time = time.split(" ")[1];
      }
      return time;
   }
}
