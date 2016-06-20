import junit.framework.TestCase;

public class w1d3_3Test extends TestCase {

   public w1d3_3Test(String name) {
      super(name);
   }

   protected void setUp() throws Exception {
      super.setUp();
   }

   protected void tearDown() throws Exception {
      super.tearDown();
   }
   public void testValidateEmail() {
      assertEquals(true, w1d3_3.validateEmail("ziegmoris@gmail.com"));
   }

   public void testValidatePhone() {
      assertEquals(true, w1d3_3.validatePhone("0906-283-0215"));
   }

   public void testReplaceA() {
      assertEquals("Apple", w1d3_3.replaceA("apple"));
   }

   public void testGetMonth() {
      assertEquals("Jun", w1d3_3.getMonth("Tue Jun 14 21:30:31 CST 2016"));
   }

}
