package com.sample.mockito.basics;

/**
 * Mockito is an open source testing framework which allows to create mock
 * objects.
 * 
 * Mockito can be used to create mock for an interface or a class.
 * 
 * A mock can be thought as a dummy implementation of an interface or a class
 * which is used to define/change its behavior.
 * 
 **/
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

interface ServiceClass {
	public int doSomething();
}

// Mocking the interface in a test
public class SampleTest {

	@Test
	public void testDoSomething() {
		ServiceClass mock = Mockito.mock(ServiceClass.class);
		int i = mock.doSomething();
		assertEquals(i, 0);
	}

	// Subbing is defining of what values to return when we invoke methods of a mock
	// object.
	// Stubbing is achieved by Mockito's when-thenReturn methods.
	@Test
	public void testDoSomething2() {
		ServiceClass mock = Mockito.mock(ServiceClass.class);
		Mockito.when(mock.doSomething()).thenReturn(10);// stubbing
		int i = mock.doSomething();
		assertEquals(i, 10);
	}
}
