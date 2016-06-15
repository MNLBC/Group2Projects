package com.oocl.mnlbc.homeworkW1D3;

import junit.framework.TestCase;


public class FactorialTest extends TestCase {

   protected void setUp() throws Exception {
      super.setUp();
   }

   protected void tearDown() throws Exception {
      super.tearDown();
   }

   public void testFactorial() {
      App app = new App();
      assertEquals(120,app.factorial(5));
   }

}
