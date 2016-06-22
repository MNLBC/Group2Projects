import junit.framework.TestCase;

public class FactorialTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFactorial() {
//		fail("Not yet implemented");
		Factorial factorial = new Factorial();
		assertEquals(24, factorial.Factorial(4));
	}

}
