package com.sample.mockito.verify;

/**
 * Mockito verify() method can be used to test number of method invocations too. We can test exact number of times, at least once, at least, at most number of invocation times for a mocked method.
 * We can use verifyNoMoreInteractions() after all the verify() method calls to make sure everything is verified. If any method verification is still left, it will fail and provide proper message.
 * 
 * verifyZeroInteractions() behavior is same as verifyNoMoreInteractions() method.
 * We can use inOrder() method to verify the order of method invocation. We can skip a method invocation but the methods being verified must be in the same order. 
 * 
 *  public static <T> T verify(T mock, VerificationMode mode) 
 *  public static VerificationMode times(int wantedNumberOfInvocations) 
 *  public static VerificationMode never()
 *  public static VerificationMode atLeastOnce()
 *  public static VerificationMode atLeast(int minNumberOfInvocations) 
 *  public static VerificationMode atMostOnce()
 *  public static VerificationMode atMost(int maxNumberOfInvocations)
 **/
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class BehaviourTest {

	//Using argument matcher with verify()
	@Test
	public void processTest() {

		List<String> mockList = Mockito.mock(List.class);
		mockList.add(Mockito.anyString()); // verifying .add() method
		Mockito.verify(mockList).add(Mockito.anyString());
	}

	@Test
	public void processTest2() {
		List<String> mockList = Mockito.mock(List.class);
		mockList.add(Mockito.anyString());
		mockList.size(); // verifying .size() method
		
		Mockito.verify(mockList, Mockito.atLeastOnce()).size();
		Mockito.verify(mockList, Mockito.times(1)).size(); //same as normal verify method
		Mockito.verify(mockList, Mockito.atLeastOnce()).size(); // must be called at least once
		Mockito.verify(mockList, Mockito.atMost(2)).size(); // must be called at most 2 times
		Mockito.verify(mockList, Mockito.atLeast(1)).size(); // must be called at least once
		Mockito.verify(mockList, Mockito.never()).clear(); // must never be called
	}
}
