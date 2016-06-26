package com.oocl.mnlbc.test;

import org.junit.Test;

import com.oocl.mnlbc.transactions.LoginClient;

/**
 * Log in Test Class
 * @author Kassandra 
 * @since 2016-06-26
 *
 */
public class LoginClientTest {

   @Test
   public void testLoginClient(String uName, String uPass) {
      LoginClient login = new LoginClient();
      assert(login.testLogin("Username", "Password"));
   }

}
