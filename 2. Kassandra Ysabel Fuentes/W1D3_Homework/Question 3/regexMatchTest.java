
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**


/**
 * 
 */

import homework.calculateFactorial;

/**
 * @author fuentka
 *
 */
public class regexMatchTest extends TestCase{

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
   
   public void testEmail() {
      assertEquals("valid", regexMatch.validateEmail("kassysabel@gmail.com"));
   }
   
   public void checkMobileNumber() {
      assertEquals("valid", regexMatch.checkMobileNumber("09265238574"));
   }
   
   public void testString() {
      assertEquals("kAssysAbel", regexMatch.checkString("kassysabel"));
   }
   
}
