/**
 * 
 */
package com.mnl.app2.w1d3hw3;

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
    * Test method for {@link com.mnl.app2.w1d3hw3.App#isEmail(java.lang.String)}.
    */
   public void testIsEmail() {
      App app = new App();
      assertTrue(app.isEmail("mrdenoyo@gmail.com"));
   }
   public void testIsPhone() {
      App app = new App();
      assertTrue(app.isPhone("09185385032"));
   }
   public void testReplaceLetterA() {
      App app = new App();
      assertEquals("meynArd", app.replaceLetterA("meynard"));
   }
   public void testGetMonth() {
      App app = new App();
      assertEquals("Jun", app.getMonth("Tue Jun 14 21:30:31 CST 2016"));
   }
}
