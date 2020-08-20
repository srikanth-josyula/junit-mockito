package com.sample.mockito.stubbing;

/**
 * Stubbing is defining of what values to return when we invoke methods of a mock object.
 * Stubbing is achieved by Mockito's when-thenReturn or doReturn-when methods. 
 * 
 **/

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

public class StubbingTest {
	
	public String doSomething() {
		return "Hello World";
	}

	// CASE - 1 Using when-theReturn
	@Test
	public void processTest1() {
		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		// when(mock.method()).thenReturn(expectedValue);
		Mockito.when(stubMock.doSomething()).thenReturn("Hello");
		String response = stubMock.doSomething();
		assertEquals(response, "Hello");
	}

	@Test
	public void processTest2() {
		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		Mockito.when(stubMock.doSomething()).thenReturn("Hello World");
		String expected = stubMock.doSomething();
		String actual = doSomething();
		assertEquals(actual, expected);
	}

	// CASE -2 Using doReturn-when
	@Test
	public void processTest3() {
		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		// doReturn(expectedValue).when(mock).method());
		Mockito.doReturn("Hello").when(stubMock).doSomething();
		String response = stubMock.doSomething();
		assertEquals(response, "Hello");
	}

	@Test
	public void processTest4() {
		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		Mockito.doReturn("Hello World").when(stubMock).doSomething();
		String expected = stubMock.doSomething();
		String actual = doSomething();
		assertEquals(actual, expected);
	}
}
