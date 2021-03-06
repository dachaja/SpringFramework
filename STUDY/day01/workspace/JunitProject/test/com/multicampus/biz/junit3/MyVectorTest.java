package com.multicampus.biz.junit3;

import com.multicampus.biz.junit.MyVector;

import junit.framework.TestCase;

public class MyVectorTest extends TestCase {
	private MyVector v;

	protected void setUp() throws Exception {
		super.setUp();
		v = new MyVector();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		v = null;
	}

	public void testIsEmpty() {
		assertTrue(v.isEmpty());
		v.addElement("abc");
		assertTrue(!v.isEmpty());
	}

	public void testContains() {
		String str1 = new String("abc");
		v.addElement(str1);
		assertTrue(v.contains(str1));	
	}

	public void testIndexOf() {
		String str1 = new String("abc");
		String str2 = new String("def");
		v.addElement(str1);
		v.addElement(str2);	
		assertEquals(1, v.indexOf(str2));
	}

	public void testElementAt() {
		String str1 = new String("abc");
		String str2 = new String("def");
		v.addElement(str1);
		v.addElement(str2);
		assertSame(str1, v.elementAt(0));
		assertSame(str2, v.elementAt(1));
	}
	public void testAddElement() {
		v.addElement("abc");
		v.addElement(new Integer(1));
		assertEquals(2, v.size());
	}

}
