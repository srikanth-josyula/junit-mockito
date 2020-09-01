package com.sample.mockito.rules;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MockitoJunitRule {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Test
	public void shouldDoSomething() {
		List<Integer> list = Mockito.mock(List.class);
		list.add(100);
	}
}
