package com.sample.mockito.spy;

/**
 * Mockito Spy to partial mock an object. When we spy on an object, the real methods are being called unless it’s stubbed. 
 * 
 * Mockito Spy vs doCallRealMethod()
 * We can also use doCallRealMethod() on a mock object to call the real method, 
 * however, it’s recommended to use Spy to create partial mocks. 
 * Because in Spy, we are instantiating an object, whereas when we create a mock object, 
 * Mockito creates a bare-minimum instance of the object. 
 * Chances are that the required dependencies are not initialized when mock is being created, 
 * leading to erroneous results.
 * 
 **/
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class SpyExample {

	// Notice that add(), get() and size() methods real implementations are being
	// called till they are not stubbed.
	// At later point of time, we have stubbed size() method.
	// From that point onwards, stubbed method will be called.
	@Test
	void test() {
		
		List<String> list = new ArrayList<>();
		List<String> spyOnList = Mockito.spy(list);

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
