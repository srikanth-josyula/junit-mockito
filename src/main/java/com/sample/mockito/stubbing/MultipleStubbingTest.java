package com.sample.mockito.stubbing;

/**
 * We can stub a method with multiple return values for the consecutive calls.
 * This can be achieved by passing multiple values to Mockito#thenReturn() method or 
 * by calling it multiple times in chain:. 
 * 
 **/
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.mockito.Mockito;

public class MultipleStubbingTest {

	public String doSomething() {
		return "Hello World";
	}

	// CASE - 1 Comma seperated return
	@Test
	public void processTest() {

		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		Mockito.when(stubMock.doSomething()).thenReturn("Hello", "World");

		String response = stubMock.doSomething();
		assertEquals(response, "Hello");

		String response2 = stubMock.doSomething();
		assertEquals(response2, "World");
	}

	// CASE - 2 Calling thenReturn() in chain:
	@Test
	public void processTest2() {

		StubbingTest stubMock = Mockito.mock(StubbingTest.class);
		Mockito.when(stubMock.doSomething()).thenReturn("Hello").thenReturn("World");

		String response = stubMock.doSomething();
		assertEquals(response, "Hello");

		String response2 = stubMock.doSomething();
		assertEquals(response2, "World");
	}
	
	// CASE - 3 Iterator style stubbing
	@Test
    public void processTest3() {
        @SuppressWarnings("unchecked")
		Iterator<String> iterator = Mockito.mock(Iterator.class);
        Mockito.when(iterator.hasNext()).thenReturn(true, true, true, false);

        Mockito.when(iterator.next()).thenReturn("Hello", "World");
        for (int i = 0; iterator.hasNext(); i++) {
            String next = iterator.next();
            switch (i) {
                case 0:
                    assertEquals(next, "Hello");
                    break;
                case 1:
                    assertEquals(next, "World");
                    break;
            }
        }
    }
}
