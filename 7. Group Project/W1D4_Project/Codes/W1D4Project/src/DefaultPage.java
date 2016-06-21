import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultPage {

   public static Store store;

   public DefaultPage(Store store) {
      this.store = store;
   }

   @SuppressWarnings("resource")
   public static void main(String[] args) {
      store = new Store();
     
      RegisterCustomer form1 = new RegisterCustomer();
      LoginCustomer form2 = new LoginCustomer();
 
      boolean validChoice = false;
      Customer cust = new Customer();
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("---------------------------------------------------------");
      System.out.println("----------------------W E L C O M E----------------------");
      System.out.println("---------------------------------------------------------");
      
      while (!validChoice)
    	  {
    	  System.out.print("\nChoose:\n [1] Register [2] Log-In : ");
    	  String choice = scanner.next();
    	  
    	  if (choice.equals("1"))
          {
             cust = form1.signUp(store);
             validChoice=true;
          }
          else if(choice.equals("2"))
          {
             cust= form2.login(store);
             validChoice = true;
          }
          else
          {
             System.out.println("Please select the right choice");
          }
    	 }
   }

   @SuppressWarnings("resource")
   public static Customer displayDefaultPage() {
      RegisterCustomer form1 = new RegisterCustomer();
      LoginCustomer form2 = new LoginCustomer();
      Customer cust = new Customer();

      Scanner scanner = new Scanner(System.in);
      System.out.println("---------------------------------------------------------");
      System.out.println("----------------------W E L C O M E----------------------");
      System.out.println("---------------------------------------------------------");
      boolean validChoice = false;
      System.out.print("\nChoose:\n [1] Register [2] Log-In : ");
      
      while (!validChoice)
	  {
	  String choice = scanner.next();
	  
	  if (choice.equals("1"))
      {
         cust = form1.signUp(store);
         validChoice=true;
      }
      else if(choice.equals("2"))
      {
         cust= form2.login(store);
         validChoice = true;
      }
      else
      {
    	 System.out.print("\nChoose:\n [1] Register [2] Log-In : ");
         System.out.println("Please select the right choice");
      }
	 }
      return cust;
   }

}
