import junit.framework.TestCase;


/**
 * 
 */

/**
 * @author flamezi2
 *
 */
public class w1d3_2Test extends TestCase {

   public static w1d3_2 app;
   /**
    * @param name
    */
   public w1d3_2Test(String name) {
      super(name);
   }

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
    * Test method for {@link w1d3_2#getFactorial(int)}.
    */
   public void testGetFactorial() {
      assertEquals(6, w1d3_2.getFactorial(3));
   }

}
