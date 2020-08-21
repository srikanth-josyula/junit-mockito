package com.sample.mockito.basics;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class ComparatorTest {

	// testing comparator
	@Test
	public void with_arguments() {
		Comparable<String> c = mock(Comparable.class);
		when(c.compareTo("Test")).thenReturn(1);
		assertEquals(1, c.compareTo("Test"));
	}

	@Test
	public void with_unspecified_arguments() {
		Comparable<Integer> c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(5));
	}
}
