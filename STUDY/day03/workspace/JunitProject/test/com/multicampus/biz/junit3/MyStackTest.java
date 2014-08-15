package com.multicampus.biz.junit3;

import com.multicampus.biz.junit.MyStack;

import junit.framework.TestCase;

public class MyStackTest extends TestCase {
	private MyStack s;

	public MyStackTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		s = new MyStack();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPush() {
		s.push("abc");
		s.push("def");
		s.push(new Integer(1));
		assertEquals(3,s.size());
	}

	public void testIsEmpty() {
		assertTrue(s.isEmpty());
		s.push("abc");
		assertTrue(!s.isEmpty());
	}

	public void testPop() {
		s.push("abc");
		s.push("def");
		String str = (String)s.pop();
		assertEquals("def", str);	
		assertEquals(1, s.size());
	}

}