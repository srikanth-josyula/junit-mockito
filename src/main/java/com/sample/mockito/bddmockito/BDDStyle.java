package com.sample.mockito.bddmockito;

/**
 * BDDMockito provides BDD aliases for various Mockito methods, so we can write our Arrange step using given
 *  (instead of when), likewise, we could write our Assert step using then (instead of verify). 
 * 
 **/
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class BDDStyle {

	/**
	 * CASE - 1 replacing when-thenReturn with given-willReturn
	 **/
	@Test
	public void letsMockListGetWithAny() {
		// Given
		List<String> list = mock(List.class);
		// When
		Mockito.when(list.get(Mockito.anyInt())).thenReturn("Hello");
		// Then - asserts
		assertEquals("Hello", list.get(0));
		assertEquals("Hello", list.get(1));
	}

	// Given - willReturn //BDD Style
	@Test
	public void bddAliases_UsingGivenWillReturn() {
		List<String> list = mock(List.class);
		// given
		given(list.get(Mockito.anyInt())).willReturn("Hello");
		// then use is
		assertThat("Hello", is(list.get(0)));
		assertThat("Hello", is(list.get(0)));
	}

	/**
	 * CASE - 2 verify with then -should
	 **/

	// verify //BDD Style
	@Test
	public void bddverify() {
		List<String> list = mock(List.class);
		Mockito.verify(list, Mockito.atMostOnce()).size();
	}
	
	// then - should
	@Test
	public void bddthenshould() {
		List<String> list = mock(List.class);
		then(list)
		  .should(times(1));
	}
	
	
	/**
	 * CASE - 3 Throwing an Exception 
	 **/
	
	@Test
	public void bddwillthrow() {
		List<String> list = mock(List.class);
		willThrow(new RuntimeException())
		  .given(list).indexOf(23);
	}
}
