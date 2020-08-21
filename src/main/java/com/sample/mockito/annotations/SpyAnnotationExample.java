package com.sample.mockito.annotations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class SpyAnnotationExample {
	
	/*@Spy 
	List<String> spyOnList = new ArrayList<>();*/
	@Spy 
	List<String> spyOnList; // both works
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void test() {
		spyOnList.add("A");
		assertEquals(1, spyOnList.size());
		assertEquals("A", spyOnList.get(0));
		
		spyOnList.add("E");
		assertEquals(2, spyOnList.size());
		assertEquals("E", spyOnList.get(1));

		Mockito.when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());
	}
}
