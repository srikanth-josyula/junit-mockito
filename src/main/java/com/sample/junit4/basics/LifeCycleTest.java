package com.sample.junit4.basics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;

/**
 * A JUnit test is a method contained in a class which is only used for testing.
 * This is called a Test class. To define that a certain method is a test
 * method, annotate it with the @Test annotation.
 * 
 * @BeforeClass: This annotation must be used on public static void no-arg
 *               method. The method is invoked before an instance of this test
 *               class is created and any tests are invoked. This life cycle
 *               callback is not related to JVM class loading. JUnit framework
 *               calls this method explicitly before calling constructor/other
 *               methods. This method is called only once, whereas, other
 *               instance lifecycle methods are called every time before calling
 *               each test method. This annotation is useful for initializing
 *               static resources which would, otherwise, be expensive to create
 *               during each test invocation.
 * @AfterClass: Similar to @BeforeClass but is called at the very end of all
 *              test/other lifecycle methods. It is called only once. Useful for
 *              static resource clean up.
 * @Before: It should be used on public void no-arg instance method. It is
 *          invoked every time before each test method invocation. Used to setup
 *          instance variables/resources which can be used during a test method
 *          execution. Useful to avoid code duplication and/or when there are
 *          many indirection of method calls starting from the target test
 *          method.
 * @After: Similar to @Before but runs after target test method execution.
 *         Useful for cleaning up instance resources.
 * @Test: public void methods to perform tests. This is where we perform one or
 *        more assertions by using static methods of org.junit.Assert. Assert
 *        methods throw org.junit.AssertionError on assertion failure. This
 *        exception or any other exception is reported as test failure. If no
 *        exceptions are thrown then the test will pass.
 * 
 *        allocation (setup) de-allocation (teardown).
 **/

class Sample {
	public String print() {
		return "Hello World";
	}
}

public class LifeCycleTest {

	public LifeCycleTest() {
        System.out.printf("Constructor invoked");
    }
	
	@BeforeClass //static
	public static void setUpBeforeClass() throws Exception {

		System.out.println("Called Before Start of the Class");

		// Method annotated with `@BeforeClass` will execute once before any of the test
		// methods in this class.

		// This method could be used to set up any test fixtures that are
		// computationally expensive and shared by several test methods.
		// e.g.(establishing database connections)

	}

	@Before
	public void setUp() throws Exception {

		System.out.println();
		System.out.println("Called Before Start of the Each Test Method");

		// Method annotated with `@Before` will execute before each test method in this
		// class is executed.

		// If you find that several tests need similar objects created before they can
		// run this method could be used to do set up those objects (aka test-fixtures).
	}

	@Test
	public void test1() {

		// A public void method annotated with @Test will be executed as a test case

		System.out.println("Calling Method test1()");
		Sample hello = new Sample();
		String result = hello.print();
		assertEquals("Hello World", result);
	}

	@Test
	public void test2() {

		// A public void method annotated with @Test will be executed as a test case

		System.out.println("Calling Method test2()");
		Sample hello = new Sample();
		String result = hello.print();
		assertEquals("Hello World !", result);
	}

	@After
	public void tearDown() throws Exception {

		System.out.println("Called After End of the Each Test Method");
		System.out.println();

		// Method annotated with `@After` will execute after each test method in this
		// class is executed.

		// If you allocate external resources in a Before method you must release them
		// in this method.
	}

	@AfterClass //static
	public static void tearDownAfterClass() throws Exception {

		System.out.println("Called After End of the Complete Class");

		// Method annotated with `@AfterClass` will execute once after all of the test
		// methods are executed in this class.

		// If you allocate expensive external resources in a BeforeClass method you need
		// to release them after all the tests in the class have run. Annotating a

		// public static void method with @AfterClass causes that method to be run after
		// all the tests in the class have been run. All @AfterClass methods are
		// guaranteed to run even if a BeforeClass method throws an exception.
	}

	// Output ::

	/*
	 * Called Before Start of the Class
	 * 
	 *Constructor invoked
	 *Called Before Start of the Each Test Method
	 *Calling Method test1()
	 *Called After End of the Each Test Method
	 *
	 *Constructor invoked
	 *Called Before Start of the Each Test Method
	 *Calling Method test2()
	 *Called After End of the Each Test Method
	 * 
	 * Called After End of the Complete Class
	 */

}
