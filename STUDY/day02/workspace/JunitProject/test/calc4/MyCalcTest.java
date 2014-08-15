package calc4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calc.MyCalc;

public class MyCalcTest {
	private MyCalc c;

	@Before
	public void init() throws Exception {
		c = new MyCalc(4, 2);

	}

	@After
	public void destory() throws Exception {
		c = null;

	}

	@Test
	public void plus() {
//		fail("Not yet implemented");
		assertEquals(6, c.plus());

	}

	@Test
	public void minus() {
//		fail("Not yet implemented");
		assertEquals("빼기 연산 오류...!!", 2, c.minus());

	}

}
