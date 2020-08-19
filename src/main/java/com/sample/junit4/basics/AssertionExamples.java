package com.sample.junit4.basics;

/**
 * void assertEquals(boolean expected,boolean actual): checks that two primitives/objects are equal. It is overloaded. 
 * void assertTrue(boolean condition): checks that a condition is true.
 * void assertFalse(boolean condition): checks that a condition is false. 
 * void assertNull(Object obj): checks that object is null. 
 * void assertNotNull(Object obj): checks that object is not null.
 * 
 * And the org.junit.Assert.assertThat method (available in JUnit4) which uses matchers 
 * and is better than old style assertions because it provides:
 *	Better readability
 *		assertThat(actual, is(equalTo(expected))); is better than assertEquals(expected, actual);
 *		assertThat(actual, is(not(equalTo(expected)))); is better than assertFalse(expected.equals(actual));
 *
 *	Better failiure messages
 *		java.lang.AssertionError: Expected: is "hello" but: was "hello world" is better than
 *		org.junit.ComparisonFailure: expected:<hello[]> but was:<hello[ world]>
 *
 *	Flexbility
 *		Multiple conditions could be asserted using matchers like anyOf or allOf.
 *		eg: assertThat("hello world", anyOf(is("hello world"), containsString("hello"))); In this case, the test will pass if either the actual string is “hello world” or if it contains the word “hello”.
 * 
 **/

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.junit.Assert;
import org.junit.Test;

public class AssertionExamples {
	@Test
	public void test1() {
		String str = "test string";
		Assert.assertTrue("str cannot be empty", str != null && str.length() != 0);
		Assert.assertFalse("str cannot by empty", str == null || str.length() == 0);
	}

	@Test
	public void test2() {
		String str = null;
		Assert.assertTrue("str cannot be empty", str != null && str.length() != 0);
	}

	@Test
	public void test3() {
		Number a = new Integer(5);
		Assert.assertEquals("The number is not 5", a, 5);
	}

	@Test
	public void test4() {
		double d = 2.6;
		Assert.assertEquals("The numbers are not approximately equal", d, 3, 0.5);
	}

	@Test
	public void test5() {
		int[] integers = { 3, 5, 7 };
		Assert.assertArrayEquals("The numbers are not equal", integers, new int[] { 3, 5, 7 });
	}

	@Test
	public void test6() {
		Object[] integers = { 3, 5, new int[] { 7, 9 } };
		Assert.assertArrayEquals("The numbers are not equal", integers, new Object[] { 3, 5, new int[] { 7, 9 } });
	}

	@Test
	public void test7() {
		String str1 = new String("test string");
		String str2 = new String("test string");
		Assert.assertSame("Same objects reference failed", str1, str1);
		Assert.assertNotSame("Different objects not same failed", str2, str1);
		Assert.assertSame("Different objects reference but have same value failed", str2, str1);
	}

	@Test
	public void test8() {
		int i = 22;
		Assert.assertThat("The number is not 22", i, CoreMatchers.is(22));
		Assert.assertThat("The number is 23", i, CoreMatchers.not(23));
	}

	@Test
	public void test9() {
		int i = 22;
		Assert.assertThat(i, createMultipleOfTwoMatcher());
	}

	private BaseMatcher<Integer> createMultipleOfTwoMatcher() {
		return new BaseMatcher<Integer>() {

			public void describeTo(Description description) {
				description.appendText("Not a multiple of 2.");
			}

			public boolean matches(Object item) {
				Integer integer = (Integer) item;
				return integer != null && integer % 2 == 0;
			}
		};
	}

	@Test
	public void test10() {
		int i = 23;
		Assert.assertThat(i, createMultipleOfTwoMatcher());
	}

	@Test
	public void test11() {
		String str = "test string";
		String str2 = null;
		Assert.assertNotNull("The str is null.", str);
		Assert.assertNull("The str is not null.", str2);
	}

	@Test
	public void test12() {
		String str = null;
		if (str == null) {
			Assert.fail("The provided str is null");
		}
	}
}
