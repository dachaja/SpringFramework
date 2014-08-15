package com.multicampus.biz.junit3;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(MyStackTest.class);
		suite.addTestSuite(MyVectorTest.class);
		suite.addTestSuite(BoardDAOTest.class);
		//$JUnit-END$
		return suite;
	}

}
