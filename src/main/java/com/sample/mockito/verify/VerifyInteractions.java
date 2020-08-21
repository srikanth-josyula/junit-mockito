package com.sample.mockito.verify;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

/**
 * Mockito.verifyNoMoreInteractions() public static void
 * verifyNoMoreInteractions(Object... mocks) Checks if any of given mocks has
 * any unverified interaction.
 * 
 * We can use this method after calling verify() methods. It is to make sure
 * that no interaction is left for verification.
 * 
 * Mockito.verifyNoInteractions() public static void
 * verifyNoInteractions(Object... mocks) This method verifies that no
 * interactions happened on given mocks.
 * 
 * NOT CLEAR
 * 
 **/

@SuppressWarnings("unchecked")
public class VerifyInteractions {

	// verifyNoMoreInteractions()
	@Test
	public void processTest() {

		List<String> mockList = Mockito.mock(List.class);
		// all interactions are verified, so below will pass
		Mockito.verifyNoMoreInteractions(mockList);
		mockList.isEmpty();

		// isEmpty() is not verified, so below will fail
		Mockito.verifyNoMoreInteractions(mockList);
	}

	// verifyZeroInteractions()
	@Test
	public void processTest2() {
		List<String> mockList = Mockito.mock(List.class);
		Map<String, String> mockMap = Mockito.mock(Map.class);
		Set<String> mockSet = Mockito.mock(Set.class);
		Mockito.verify(mockList).isEmpty();
		Mockito.verifyZeroInteractions(mockList, mockMap, mockSet);
	}

	// Mockito verify only method call
	// If we want to verify that only one method is being called, then we can use
	// only() with verify method.
	@Test
	public void processTest3() {

		Map<String, String> mockMap = Mockito.mock(Map.class);
		mockMap.isEmpty();
		Mockito.verify(mockMap, Mockito.only()).isEmpty();
	}

	// Mockito Verify Order of Invocation
	// We can use InOrder to verify the order of invocation. We can skip any method
	// to verify,
	// but the methods being verified must be invoked in the same order
	@Test
	public void processTest4() {

		List<String> mockList = Mockito.mock(List.class);
		Map<String, String> mockMap = Mockito.mock(Map.class);

		InOrder inOrder = Mockito.inOrder(mockList, mockMap);
		inOrder.verify(mockList).add(Mockito.anyString());
		inOrder.verify(mockList, Mockito.calls(1)).size();
		inOrder.verify(mockList).isEmpty();
		inOrder.verify(mockMap).isEmpty();
	}
}
