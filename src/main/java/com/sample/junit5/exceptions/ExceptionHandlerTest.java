package com.sample.junit5.exceptions;

/**
 * The assertThrows() asserts that execution of the supplied executable which
 * throws an exception of the expectedType and returns the exception.
 * 
 * If no exception is thrown in the test, or if an exception of a different type
 * is thrown, assertThrows() method will fail.
 * 
 **/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ExceptionHandlerTest {

	@Test
	public void testExpectedException() {
		
		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One");
		});
		
	}

	// you can expect the parent types of the exception class
	// as well. e.g. above test can be written with Exception also.
	@Test
	void testExpectedExceptionWithSuperType() {

		Assertions.assertThrows(Exception.class, () -> {
			Integer.parseInt("One");
		});

	}

	// If executable code throws any other exception type, then test will FAIL; or
	// even if test does not throw any exception then also test will FAIL.
	@Test
	void testExpectedExceptionFail() {

		Assertions.assertThrows(Exception.class, () -> {
			Integer.parseInt("1");
		});

	}
}
