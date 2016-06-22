import junit.framework.TestCase;

public class RegexOptTest extends TestCase {
	static RegexOpt regexOpt = new RegexOpt();
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsEmail() {
//		fail("Not yet implemented");
		String email = "lancejasperlopez@gmail.com";
		assertEquals(true, regexOpt.isEmail(email));
	}

	public void testIsMobileNum() {
		String mobileNum = "+639261394254";
		assertEquals(true, regexOpt.isMobileNum(mobileNum));
//		fail("Not yet implemented");
	}

	public void testReplaceCharWithA() {
		String sample = "movarateknuva";
		assertEquals("movArAteknuvA", regexOpt.replaceCharWithA(sample) );
//		fail("Not yet implemented");
	}

	public void testGetMonthFromDate() {
//		fail("Not yet implemented");
		String date = "Tue Jun 14 21:30:31 CST 2016" ;
		assertEquals("Jun", regexOpt.getMonthFromDate(date) );
	}

}
