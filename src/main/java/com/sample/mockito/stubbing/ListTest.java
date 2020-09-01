package com.sample.mockito.stubbing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class ListTest {

	List<String> mock = mock(List.class);

	@Test
	public void letsMockListSize() {

		List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());
	}

	@Test
	public void letsMockListSizeWithMultipleReturnValues() {
		List<Integer> list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size()); // First Call
		assertEquals(20, list.size()); // Second Call
	}

	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("Hello");
		assertEquals("Hello", list.get(0));
		assertNull(list.get(1));
	}

	@Test(expected = RuntimeException.class)
	public void letsMockListGetToThrowException() {
		List<String> list = mock(List.class);
		when(list.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		list.get(0);
	}

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("Hello");
		assertEquals("Hello", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("Hello");

		assertEquals("Hello", mock.get(0));
		assertEquals("Hello", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing() {

		// SUT
		mock.add("SomeString");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("SomeString", captor.getValue());

	}

	@Test
	public void multipleArgumentCapturing() {

		// SUT
		mock.add("SomeString1");
		mock.add("SomeString2");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();

		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));

	}

	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));// null
		System.out.println(arrayListMock.size());// 0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());// 0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());// 5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));// Test0
		System.out.println(arrayListSpy.size());// 1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());// 3

		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());// 5

		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());// 5

		verify(arrayListSpy).add("Test4");
	}
}