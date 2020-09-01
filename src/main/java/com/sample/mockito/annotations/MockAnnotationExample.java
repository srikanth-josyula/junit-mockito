package com.sample.mockito.annotations;

/**
 * The @Mock annotation is used to create and inject mocked instances. We do not
 * create real objects, rather ask mockito to create a mock for the class.
 * The @Mock annotation is alternative to Mockito.mock(classToMock). They both
 * achieve the same result. Using @Mock is usually considered “cleaner“, as we
 * don’t fill up the tests with boilerplate assignments that all look the same.
 * 
 * Using the @Mock annotation –
 * 
 * allows shorthand creation of objects required for testing minimizes
 * repetitive mock creation code. makes the test class more readable. makes the
 * verification error easier to read because field name is used to identify the
 * mock.
 * 
 * 
 * @RunWith: It is a class-level annotation. It is used to keep the test clean
 *           and improves debugging. It also detects the unused stubs available
 *           in the test and initialize mocks annotated with @Mock annotation.
 *           The @RunWith annotation is available in the org.mockito.junit
 *           package.
 * In mockito, we need to create the object of class to be tested and than
 * insert it’s dependencies (mocked) to completely test the behavior. To do
 * this, we use @InjectMocks annotation.
 * 
 * @InjectMocks marks a field on which injection should be performed. Mockito
 *              will try to inject mocks only either by constructor injection,
 *              setter injection, or property injection – in this order. If any
 *              of the given injection strategy fail, then Mockito won’t report
 *              failure.
 **/


import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockAnnotationExample {

	@Mock
	HashMap<String, Integer> mockHashMap;

	@Test
	public void saveTest() {
		mockHashMap.put("A", 1);
		Mockito.verify(mockHashMap, Mockito.times(1)).put("A", 1);
		assertEquals(0, mockHashMap.size());
	}
}
