package com.metacube.get2019;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * It is class to run all the test cases.
 * @author Kritika
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AddSparseMatrixTest.class, MultiTest.class,
		SymmetricTest.class, TransposeTest.class })
public class AllSparseTest {

}
