/**
 * 
 */
package com.mnl.app2.w1d3hw;

import junit.framework.TestCase;


/**
 * @author denoyme
 *
 */
public class AppTest extends TestCase {

   /* (non-Javadoc)
    * @see junit.framework.TestCase#setUp()
    */
   protected void setUp() throws Exception {
      super.setUp();
   }

   /* (non-Javadoc)
    * @see junit.framework.TestCase#tearDown()
    */
   protected void tearDown() throws Exception {
      super.tearDown();
   }

   /**
    * Test method for {@link com.mnl.app2.w1d3hw.App#Factorial(int)}.
    */
   public void testFactorial() {
      App app = new App();
      assertEquals(120, app.Factorial(5));
   }

}
