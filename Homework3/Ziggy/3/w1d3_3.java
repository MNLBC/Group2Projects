import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 
3 Use the Java Regular expression to finish the rules. Each item should be a method. [Optional]
1) To check an email if it is valid or not.
2) To check a mobile phone number if it is valid or not.
3) Given a string, replace all the char "a" with "A".
4) Given a string with date time like "Tue Jun 14 21:30:31 CST 2016", to fetch the month like "Jun", and return the value.
Hints: 
1. import java.util.regex.*;
2. Created an object of java.util.regex.Pattern p, then compile p;
3. Use the method matcher(String text) of p to match the given text;
4. Use find() to iterate the results of matching.
 */

public class w1d3_3 {

   public w1d3_3() {
      // TODO Auto-generated constructor stub
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      String email = "ziegmoris@gmail.com";
      String phone = "0906-283-0215";
      String text = "apple apple";
      String date = "Tue Jun 14 21:30:31 CST 2016";
      System.out.println("Is "+ email +" a valid email?: " + validateEmail(email));
      System.out.println("Is "+ phone +" a valid phone number?: " + validatePhone(phone));
      System.out.println("Replace "+ text +" with: " + replaceA(text));
      System.out.println("The month in "+ date +" is: " + getMonth(date));
   }
   
   public static boolean validateEmail(String email){
      Pattern p = Pattern.compile("([A-Za-z0-9_.]+)@([A-Za-z0-9]+).com");
      Matcher m = p.matcher(email);
      if (m.find()) {
        return true;
      } else {
        return false;
      }
   }
   
   public static boolean validatePhone(String phone){
      Pattern p = Pattern.compile("(0)([0-9]{3})-([0-9]{3})-([0-9]{4})");
      Matcher m = p.matcher(phone);
      if (m.find()) {
        return true;
      } else {
        return false;
      }
   }
   
   public static String replaceA(String text){
      return text.replaceAll("a", "A");
   }
   
   public static String getMonth(String date){
      Pattern p = Pattern.compile("([A-Za-z0-9]{3}) ([A-Za-z]{3}) ([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2}) ([A-Za-z]{3}) ([0-9]{4})");
      Matcher m = p.matcher(date);
      if (m.find()) {
         return m.group(2);
       } else {
         return "Invalid format";
       }
   }


}
