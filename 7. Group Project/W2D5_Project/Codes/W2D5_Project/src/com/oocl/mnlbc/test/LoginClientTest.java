package com.oocl.mnlbc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oocl.mnlbc.transactions.LoginClient;
import com.oocl.mnlbc.utils.DatabaseTransactions;


public class LoginClientTest {

   @Test
   public void testLoginClient(String uName, String uPass) {
      LoginClient login = new LoginClient();
      assert(login.testLogin("Username", "Password"));
   }

}
