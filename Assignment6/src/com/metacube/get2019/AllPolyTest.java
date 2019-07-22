package com.metacube.get2019;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite class for all the Junit tests of Poly
 * class
 * @author Kritika
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DegreeTest.class, EvaluateTest.class, AddPolyTest.class, MultiPolyTest.class})
public class AllPolyTest {
	//Suite class to run all the test cases
}