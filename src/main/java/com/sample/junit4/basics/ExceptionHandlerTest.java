package com.sample.junit4.basics;

import org.junit.Test;

public class ExceptionHandlerTest {

	// Following test fails because it's throwing ArithmeticException and we are not
	// using 'expected' element.
	@Test
	public void testMethod1() {
		int i = 1 / 0;
		System.out.println(i);
	}

	// Following test passes because it's throwing ArithmeticException and we are
	// using 'expected' with the same exception class value.
	@Test(expected = ArithmeticException.class)
	public void testMethod2() {
		int i = 1 / 0;
		System.out.println("Using @Test(expected) ,it will check for specified exception during its execution");
		System.out.println(i);
	}

	// Following test fails because it's not throwing the exception which we have
	// specified with 'expected' element.
	@Test(expected = ArithmeticException.class)
	public void testMethod3() {
		System.out.println("running testMethod3");
	}
		
}
