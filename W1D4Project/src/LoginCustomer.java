import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LoginCustomer 
{
	public static String userName;
	public static String userPassword;
	
	public Customer login(Store store) 
	{
		int choice;
		RegisterCustomer register = new RegisterCustomer();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--------------------Customer Log-In--------------------");
		
		System.out.println("Username: ");
		userName = scanner.next();
		
		System.out.println("Password: ");
		userPassword = scanner.next();
		
		System.out.println("Validating account...");
		
		if(store.getCustomerByLogin(userName, userPassword) == null)
		{
			System.out.println("Account is invalid. Please log-in again.");
			System.out.println("For customers who have not registered yet: enter '0'. To continue: enter '1'");
			choice = scanner.nextInt();
			
			if (choice==0)
			{
				register.signUp(store);
			}
			else if (choice==1)
			{
			   Customer cust = new Customer();
			   MainMenu mm = new MainMenu(store);
			   cust = login(store);
			   if(cust!=null){
		         mm.displayMainMenu(cust);
		      }
				System.out.println();
			}	
		}
		else
		{
		   return store.getCustomerByLogin(userName, userPassword);
//			MainMenu menu = new MainMenu();
		}
      return null;
	}

}
