/**
 * 
 */
package com.oocl.mnlbc.test;

import org.junit.Test;

import com.oocl.mnlbc.transactions.RegisterClient;


/**
 * @author Kassandra
 * @since 2016-06-25
 *
 */
public class RegisterClientTest {
   RegisterClient register = new RegisterClient();
   
   @Test
   public void testSignup() {  
      assert(register.testSignUp("First name", "Last name", "Username", "Password"));
   }

}
