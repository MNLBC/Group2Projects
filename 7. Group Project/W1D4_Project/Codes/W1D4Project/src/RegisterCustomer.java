import java.util.List;
import java.util.Scanner;

public class RegisterCustomer {

   public static String firstName;
   public static String lastName;
   public static String userName;
   public static String userPassword;

   @SuppressWarnings("resource")
   public Customer signUp(Store store) {
      Scanner scanner = new Scanner(System.in);
      LoginCustomer form3 = new LoginCustomer();
      System.out.println("-----------------Customer Registration Form-----------------");

      System.out.println("First Name: ");
      firstName = scanner.next();

      System.out.println("Last Name: ");
      lastName = scanner.next();

      System.out.println("Username: ");
      userName = scanner.next();

      System.out.println("Password: ");
      userPassword = scanner.next();

      store.addCustomer(firstName, lastName, userName, userPassword);
      System.out.println("Customer registration successful!");
      return form3.login(store);
   }

}
