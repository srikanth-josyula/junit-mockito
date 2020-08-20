package com.sample.mockito.stubbing;

/**
 * When can use Mockito's when-thenThrow or doThrow-when methods to stub exceptions.
 * 
 **/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.TestCase;

class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}

@SuppressWarnings("unused")
public class ExceptionStubbing {
	
	public String doSomething() {
		return "Hello World";
	}
	
	public String doSomething2() throws CustomException{
		return "Hello World";
	}
	 
	public String doSomething3() {
		try {
			return "Hello World";
		} catch (Exception e) {
			System.out.println("-- exception thrown in doSomething3 method --");
			return "default-value";
		}
	}

	/***** TESTING ******/
	// Testing unchecked exception
	@Test
	public void processTest() {

		ExceptionStubbing stubMock = Mockito.mock(ExceptionStubbing.class);
		Mockito.when(stubMock.doSomething()).thenThrow(new RuntimeException("Cannot process"));
		try {
			String response = stubMock.doSomething();
			TestCase.fail();
		} catch (Exception e) {
			System.out.println("-- runtime exception thrown --");
			assertTrue(e instanceof RuntimeException);
			assertEquals(e.getMessage(), "Cannot process");
		}

		//Note that if we try to throw checked exception in above example i.e.
		//Mockito.when(myService.doSomething()).thenThrow(new Exception("Cannot process"));
					
		/*then we will have following runtime exception:

							org.mockito.exceptions.base.MockitoException: 
							Checked exception is invalid for this method!
							Invalid: java.lang.Exception: Cannot process*/
	}

	// Testing checked exception
	@Test
	public void processTest1() throws CustomException {

		ExceptionStubbing stubMock = Mockito.mock(ExceptionStubbing.class);
		Mockito.when(stubMock.doSomething2()).thenThrow(new CustomException("Cannot process"));
		try {
			String response = stubMock.doSomething2();
			TestCase.fail();
		} catch (Exception e) {
			System.out.println("-- custom exception thrown --");
			assertTrue(e instanceof CustomException);
			assertEquals(e.getMessage(), "Cannot process");
		}

	}
	
	//Testing handled exception
	@Test
	public void processTest2() {
		// NOT WORKING
		ExceptionStubbing stubMock = Mockito.mock(ExceptionStubbing.class);
		Mockito.when(stubMock.doSomething3()).thenThrow(new Exception("Cannot process"));
		//String response = stubMock.doSomething2();
		/*assertEquals(response, "default-value");*/

	}
	
	
	// Testing unchecked exception using doThrow
	@Test
	public void processTest3() {

		ExceptionStubbing stubMock = Mockito.mock(ExceptionStubbing.class);
		Mockito.doThrow(new RuntimeException("Cannot process")).when(stubMock).doSomething();
		try {
			String response = stubMock.doSomething();
			TestCase.fail();
		} catch (Exception e) {
			System.out.println("-- runtime exception thrown using doThrow--");
			assertTrue(e instanceof RuntimeException);
			assertEquals(e.getMessage(), "Cannot process");
		}

	}

}
