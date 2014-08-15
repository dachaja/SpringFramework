package com.multicampus.biz.junit4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.multicampus.biz.junit.MyStack;

public class MyStackTest {
	private MyStack s;

	@Before
	public void setUp() throws Exception {
		s = new MyStack();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {
		s.push("abc");
		s.push("def");
		s.push(new Integer(1));
		assertEquals(3, s.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(s.isEmpty());
		s.push("abc");
		assertTrue(!s.isEmpty());
	}

	@Test
	public void testPop() {
		s.push("abc");
		s.push("def");
		String str = (String) s.pop();
		assertEquals("def", str);
		assertEquals(1, s.size());
	}

}
