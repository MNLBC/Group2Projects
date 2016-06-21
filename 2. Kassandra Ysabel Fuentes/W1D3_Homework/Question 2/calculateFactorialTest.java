package test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 */

import homework.calculateFactorial;
/**
 * @author fuentka
 *
 */
public class calculateFactorialTest  extends TestCase{

   /**
    * @throws java.lang.Exception
    */
   @Before
   public void setUp() throws Exception {
   }

   /**
    * @throws java.lang.Exception
    */
   @After
   public void tearDown() throws Exception {
   }
   
   public void testFactorial() {
      assertEquals(120, calculateFactorial.factorial(5));
   }
   

}
