package com.example.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int divide(int a, int b) {
		if (b == 0)
			throw new ArithmeticException();
		return a / b;
	}
}

public class CalculatorTest {

	@Test
	public void testAdd() throws Exception {
		int a = 7; // Or any other value
		int b = 3; // Or any other value

		Calculator calMock = mock(Calculator.class);
		when(calMock.add(a, b)).thenReturn(10);
		verify(calMock, atMostOnce()).add(a, b);

		int actual = new Calculator().add(a, b);
		assertEquals(10, actual);

	}

	@Test
	public void testDivide() throws Exception {
		int a = 7; // Or any other value
		int b = 3; // Or any other value

		Calculator calMock = mock(Calculator.class);
		when(calMock.divide(a, b)).thenReturn(2);
		verify(calMock, atMostOnce()).add(a, b);

		int actual = new Calculator().divide(a, b);
		assertEquals(2, actual);

	}

	@Test
	public void testDividewithException() throws Exception {
		int a = 7; // Or any other value
		int b = 0; // Or any other value

		Calculator calMock = mock(Calculator.class);
		when(calMock.divide(a, b)).thenThrow(new ArithmeticException());

		verify(calMock, atMostOnce()).divide(a, b);
		
		try {
			new Calculator().divide(a, b);
		} catch (Exception e) {
			assertTrue(e instanceof ArithmeticException);
			assertEquals(e.getMessage(), null);
		}

	}
}
