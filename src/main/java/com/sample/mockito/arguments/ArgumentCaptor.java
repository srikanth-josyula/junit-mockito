package com.sample.mockito.arguments;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ArgumentCaptor {
	@Test
	public void saveTest() {
		
		// ArgumentCaptor.getAllValues() these are present in mokito-core 2.25v
		
		List<String> mocklist = mock(List.class);
		when(mocklist.get(anyInt())).thenReturn("Mockito");

		assertEquals("Mockito", mocklist.get(0));
		assertEquals("Mockito", mocklist.get(1));
		assertEquals("Mockito", mocklist.get(2));
	}
}
