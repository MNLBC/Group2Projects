package com.oocl.mnlbc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oocl.mnlbc.models.Message;
import com.oocl.mnlbc.models.Session;
import com.oocl.mnlbc.utils.FileTransactions;

/**
 * Unit Test for FileTransactions
 * @author flamezi2
 * @since 2016-06-26
 */
public class FileTransactionsTest {

   @Before
   public void setUp() throws Exception {
      System.out.println("Testing...");
   }

   @After
   public void tearDown() throws Exception {
      System.out.println("Testing Complete!");
   }

   /**
    * Testing file writing
    */
   @Test
   public void testWrite() {
      System.out.println("Testing file writing");
      Message message = FileTransactions.generateTestMessage();
      Session session = FileTransactions.generateTestSession();
      assertTrue(FileTransactions.write(message, session));
   }

   /**
    * Testing config getting
    */
   @Test
   public void testGetConfigValue() {
      System.out.println("Testing config getting");
      assertEquals("7777",FileTransactions.getConfigValue("port"));
   }

}
