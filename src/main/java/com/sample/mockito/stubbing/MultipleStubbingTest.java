package com.sample.mockito.stubbing;

/**
 * We can stub a method with multiple return values for the consecutive calls.
 * This can be achieved by passing multiple values to Mockito#thenReturn() method or 
 * by calling it multiple times in chain:. 
 * 
 **/
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class MultipleStubbingTest {

	static List<String> mockList = null;

	@BeforeClass
	public static void init() {
		mockList = Mockito.mock(List.class);
	}

	// CASE - 1 Comma seperated return
	@Test
	public void processTest() {

		Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("Hello", "World");

		String response = mockList.get(Mockito.anyInt());
		assertEquals(response, "Hello");

		String response2 = mockList.get(Mockito.anyInt());
		assertEquals(response2, "World");
	}

	// CASE - 2 Calling thenReturn() in chain:
	@Test
	public void processTest2() {

		Mockito.when(mockList.get(Mockito.anyInt())).thenReturn("Hello").thenReturn("World");

		String response = mockList.get(Mockito.anyInt());
		assertEquals(response, "Hello");

		String response2 = mockList.get(Mockito.anyInt());
		assertEquals(response2, "World");
	}

	// CASE - 3 Iterator style stubbing
	@Test
	public void processTest3() {
		Iterator<String> iterator = Mockito.mock(Iterator.class);
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
