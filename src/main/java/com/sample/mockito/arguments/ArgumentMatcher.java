package com.sample.mockito.arguments;

/**
 *Which one should we use any() or anyString()?
 *It's preferable to more specific methods (e.g. anyString()) than any() method, 
 *that's because it's more readable and secondly any() method can throw NullPointerException in some cases. 
 * 
 **/
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class ArgumentMatcher {

	@Test
	public void processTestList() {

		List<String> mocklist = Mockito.mock(List.class);
		Mockito.when(mocklist.get(ArgumentMatchers.anyInt())).thenReturn("Mockito");

		assertEquals("Mockito", mocklist.get(0));
		assertEquals("Mockito", mocklist.get(1));
		assertEquals("Mockito", mocklist.get(2));
	}

}
