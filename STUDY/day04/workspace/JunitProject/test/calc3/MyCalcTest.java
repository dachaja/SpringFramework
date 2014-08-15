package calc3;

import junit.framework.TestCase;
import calc.MyCalc;

public class MyCalcTest extends TestCase {
	private MyCalc c;

	protected void setUp() throws Exception {
		super.setUp();
		System.out.println("===> setup");
		
		c = new MyCalc(4, 2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("===> tearDown");
		
		c = null;
	}

	public void testPlus() {
		//fail("Not yet implemented");
		System.out.println("===> testPlus");
		
		assertEquals(6, c.plus());
	}

	public void testMinus() {
		//fail("Not yet implemented");
		System.out.println("===> testMinus");
		
		assertEquals("빼기 연산 오류...!!", 2, c.minus());
	}

}
