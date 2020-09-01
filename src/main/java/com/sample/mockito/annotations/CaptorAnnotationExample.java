package com.sample.mockito.annotations;

/**
 * The @Captor annotation is used to create an ArgumentCaptor instance which is
 * used to capture method argument values for further assertions
 **/

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CaptorAnnotationExample {
	@Mock
	HashMap<String, Integer> hashMap;

	@Captor
	ArgumentCaptor<String> keyCaptor;

	@Captor
	ArgumentCaptor<Integer> valueCaptor;

	@Test
	public void saveTest() {
		hashMap.put("A", 10);

		Mockito.verify(hashMap).put(keyCaptor.capture(), valueCaptor.capture());

		assertEquals("A", keyCaptor.getValue());
		assertEquals(new Integer(10), valueCaptor.getValue());
	}
}
