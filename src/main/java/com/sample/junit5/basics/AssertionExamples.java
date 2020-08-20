package com.sample.junit5.basics;

/**
 * All JUnit Jupiter assertions are static methods in the org.junit.jupiter.Assertions class.
 * import static org.junit.jupiter.api.Assertions.*;
 * 
 * Assertions.assertEquals() and Assertions.assertNotEquals()
 * Assertions.assertArrayEquals()
 * Assertions.assertIterableEquals()
 * Assertions.assertLinesMatch()
 * Assertions.assertNotNull() and Assertions.assertNull()
 * Assertions.assertNotSame() and Assertions.assertSame()
 * Assertions.assertTimeout() and Assertions.assertTimeoutPreemptively()
 * Assertions.assertTrue() and Assertions.assertFalse()
 * Assertions.assertThrows()
 * Assertions.fail()
 * 
 **/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertionExamples {

	// public static void assertEquals(int expected, int actual)
	@Test
	public void test1() {
		Number a = new Integer(5);
		assertEquals(5, a); // this will pass
		assertNotEquals(2, a, "The Number is 5"); // This will pass
	}
	
	//public static void assertArrayEquals(int[] expected, int[] actual)
	@Test
	public void test2() 
	{
	    assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Array Equal Test");
	    assertArrayEquals(new int[]{1,2,3}, new int[]{1,3,2}, "Array Equal Test");  //Test will fail because element order is different
	    assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3,4}, "Array Equal Test");  //Test will fail because number of elements are different
	}

	// public static void assertIterableEquals(Iterable<?> expected, Iterable> actual)
	@Test
	public void test3() {
		Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		Iterable<Integer> listThree = new ArrayList<>(Arrays.asList(1, 2, 3));
		Iterable<Integer> listFour = new ArrayList<>(Arrays.asList(1, 2, 4, 3));

		assertIterableEquals(listOne, listTwo); // Test will pass
		assertIterableEquals(listOne, listThree, "Array Equal Test"); // Test will fail
		assertIterableEquals(listOne, listFour, "Array Equal Test"); // Test will fail
	}
	
	@Test
	public void test4() {
		String nullString = null;
		String notNullString = "howtodoinjava.com";

		assertNotNull(notNullString); // Test will pass
		assertNotNull(nullString,"test will fail"); // Test will fail
		
		assertNull(nullString); // Test will pass
		assertNull(notNullString); // Test will fail
	}
	
	//assertNotSame() asserts that expected and actual DO NOT refer to the same object.. 
	//Similarly, assertSame() method asserts that expected and actual refer to exactly same object.. Both has three overloaded methods.
	//public static void assertNotSame(Object actual)
	
	@Test
	public void test5() {
		String originalObject = "howtodoinjava.com";
		String cloneObject = originalObject;
		String otherObject = "example.com";

		assertNotSame(originalObject, otherObject); // Test will pass
		assertNotSame(originalObject, cloneObject,"message"); // Test will fail
		assertSame(originalObject, cloneObject); // Test will pass
		assertSame(originalObject, otherObject); // Test will fail
	}
	
	//assertTrue() asserts that the supplied condition is true or boolean condition supplied by Boolean
	//Supplier is true. Similarly, assertFalse() asserts that supplied condition is false.
	@Test
	public void test6() {
	 
	    boolean trueBool = true;
	    boolean falseBool = false;
	 
	    assertTrue(trueBool);
	    assertTrue(falseBool, "test execution message");
	     
	    assertFalse(falseBool);
	    assertFalse(trueBool, "test execution message");
	}
	
	//fail() method simply fails the test
	@Test
	public void testCase() {
		fail("not found good reason to pass");
    }
}
