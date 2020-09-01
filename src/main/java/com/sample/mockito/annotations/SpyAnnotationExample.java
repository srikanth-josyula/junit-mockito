package com.sample.mockito.annotations;

/**
 * The @Spy annotation is used to create a real object and spy on that real
 * object. A spy helps to call all the normal methods of the object while still
 * tracking every interaction, just as we would with a mock.
 * 
 * 
 * Difference between @Mock and @Spy When using @Mock, mockito creates a
 * bare-bones shell instance of the Class, entirely instrumented to track
 * interactions with it. This is not a real object and does not maintain the
 * state changes to it. When using @Spy, mockito creates a real instance of the
 * class and track every interactions with it. It maintains the state changes to
 * it.
 * 
 **/

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)  
public class SpyAnnotationExample {
	
	@Spy
	HashMap<String, Integer> hashMap;
	 
	@Test
	public void saveTest()
	{
	    hashMap.put("A", 10);
	     
	    Mockito.verify(hashMap, Mockito.times(1)).put("A", 10);
	    Mockito.verify(hashMap, Mockito.times(0)).get("A");
	     
	    assertEquals(1, hashMap.size());
	    assertEquals(new Integer(10), (Integer) hashMap.get("A"));
	}
}
