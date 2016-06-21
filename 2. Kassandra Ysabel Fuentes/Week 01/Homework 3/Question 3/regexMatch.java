import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexMatch {

   private Pattern pattern;
   private Matcher matcher;
   
   private static final String EMAIL_PATTERN = 
      "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
   
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
      String email;
      String mobileNumber;
      String inputString;
      String dateString;
      
      System.out.println("Enter an email:");
      email = scanner.next();
      
      System.out.println("Email " + email  + " is " + validateEmail(email));
      
      System.out.println("Enter a mobile number:");
      mobileNumber = scanner.next();
      
      System.out.println("Mobile number " + mobileNumber  + " is " + checkMobileNumber(mobileNumber));
      
      System.out.println("Enter a text:");
      inputString = scanner.next();
      
      System.out.println(checkString(inputString));
      
      System.out.println("Enter a date time:");
      dateString = scanner.next();
      
      
   }
   
   public static String validateEmail(String email){
      Pattern p = Pattern.compile("[a-zA-Z0-9_.]+@[a-zA-Z0-9]+[.][a-z]+");
      Matcher m = p.matcher(email);
      if (m.find()) {
        return "valid";
      } else {
        return "invalid";
      }
   }
  
   public static String checkMobileNumber(String j)
   {
      Pattern p = Pattern.compile("^[0-9]{11,11}$");
      Matcher m = p.matcher(j);
      if (m.find()) {
        return "valid";
      } else {
        return "invalid";
      }
   }

   public static String checkString(String j)
   {
      return  j.replaceAll("a", "A");
      
   }

//   public static String checkDate(String j)
//   {
// 
//   }

}
