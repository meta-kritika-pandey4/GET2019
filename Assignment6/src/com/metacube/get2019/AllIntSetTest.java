package com.metacube.get2019;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite class for all the Junit tests of IntSet
 * class
 * @author Kritika
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ GetComplementTest.class, IsMemberTest.class, IsSubsetTest.class, SizeTest.class, UnionTest.class})
public class AllIntSetTest {
	//Suite class to run all the test cases
}