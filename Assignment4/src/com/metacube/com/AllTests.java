package com.metacube.com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite class for all the Junit tests
 * @author Kritika
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CountClumpsTest.class, FixXYTest.class, MaxMirrorTest.class,
		SplitArrayTest.class })
public class AllTests {
	//Suite class to run all the test cases
}
