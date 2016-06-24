package com.oocl.mnlbc;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.oocl.mnlbc.models.Client;
import com.oocl.mnlbc.transactions.Chat;
import com.oocl.mnlbc.transactions.DatabaseTransactions;

public class LoginClient 
{
	public static String userName;
	public static String userPassword;
	
	public Client login(Client client) 
	{
		int choice;
		RegisterClient register = new RegisterClient();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--------------------Customer Log-In--------------------");
		
		System.out.println("Username: ");
		userName = scanner.next();
		
		System.out.println("Password: ");
		userPassword = scanner.next();
		
		System.out.println("Validating account...");
		
		if(DatabaseTransactions.getChatUser(userName, userPassword) == null)
		{
			System.out.println("Account is invalid. Please log-in again.");
			System.out.println("For users who have not registered yet: enter '0'. To continue: enter '1'");
			choice = scanner.nextInt();
			
			Client user = new Client();
			
			if (choice==0)
			{
			   user = register.signUp(client);
			}
			else if (choice==1)
			{
			   user = login(client);
			}

         if(user!=null){
//          open chat
         }
         System.out.println();
		}
		
		else
		{
		   return DatabaseTransactions.getChatUser(userName, userPassword);
//			MainMenu menu = new MainMenu();
		}
      return null;
	}

}
