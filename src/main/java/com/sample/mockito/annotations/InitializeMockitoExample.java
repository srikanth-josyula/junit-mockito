package com.sample.mockito.annotations;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

// Case - 1
//@RunWith(MockitoJUnitRunner.class)
public class InitializeMockitoExample {

	@Mock
	private List<Integer> list;

	// case - 2
	/*@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}*/
	
	// case - 3
	@Rule
    public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void shouldDoSomething() {
		list.add(100);
	}
}
