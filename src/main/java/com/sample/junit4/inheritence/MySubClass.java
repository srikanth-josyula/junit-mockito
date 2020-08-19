package com.sample.junit4.inheritence;

/**
 * Execute the @Before methods in the superclass
 * Execute the @Before methods in this class
 * Execute a @Test method in this class
 * Execute the @After methods in this class
 * Execute the @After methods in the superclass
 * 
 * 
 **/
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySubClass extends MyBaseClass {

	@BeforeClass
	public static void beforeSubClassMethod() {
		System.out.println("@BeforeClass static method invoked. MySubClass");
		// error will be thrown if we dont put static for the @beforeclass during inheritence
		
		//If we use the same lifecycle and test method names then of course polymorphism will be applied i.e. only overridden methods will be invoked. 
		//The static @BeforeClass will also be invoked only once for the subclass:
	}

	@Before
	public void beforeSubMethod() {
		System.out.println("MySubClass: @Before method invoked.");
	}

	@After
	public void afterSubMethod() {
		System.out.println("MySubClass: @After method invoked.");
	}

	@Test
	public void testMethod2() {
		System.out.println("MySubClass: in testMethod2().");
	}

	// Output

	/*
	 * MyBaseClass: @BeforeClass static method invoked.
	 * 
	 * @BeforeClass static method invoked. MySubClass MyBaseClass: @Before method
	 * invoked. MySubClass: @Before method invoked. MySubClass: in testMethod2().
	 * MySubClass: @After method invoked. MyBaseClass: @After method invoked.
	 * MyBaseClass: @Before method invoked. MySubClass: @Before method invoked.
	 * MyBaseClass: in testMethod1() MySubClass: @After method invoked.
	 * MyBaseClass: @After method invoked.
	 */
}