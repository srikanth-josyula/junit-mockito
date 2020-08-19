package com.sample.junit4.ordered;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//Running test cases in order of method names in ascending order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM) //execute tests with JVM option.
public class OrderedTestCasesExecution {
	@Test
	public void secondTest() {
		System.out.println("Executing second test");
	}

	@Test
	public void firstTest() {
		System.out.println("Executing first test");
	}

	@Test
	public void thirdTest() {
		System.out.println("Executing third test");
	}
	
	// OutPut
	/*	Executing first test
		Executing second test
		Executing third test	*/

}