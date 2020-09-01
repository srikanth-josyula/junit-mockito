package com.sample.mockito.arguments;

/**
 *Which one should we use any() or anyString()?
 *It's preferable to more specific methods (e.g. anyString()) than any() method, 
 *that's because it's more readable and secondly any() method can throw NullPointerException in some cases. 
 * 
 **/
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class ArgumentMatcher {

	@Test
	public void processTestList() {
		
		// ArgumentMatcher.anyInt()  these are present in mokito-core 2.25v

		List<String> mocklist = mock(List.class);
		when(mocklist.get(anyInt())).thenReturn("Mockito");

		assertEquals("Mockito", mocklist.get(0));
		assertEquals("Mockito", mocklist.get(1));
		assertEquals("Mockito", mocklist.get(2));
	}

}
