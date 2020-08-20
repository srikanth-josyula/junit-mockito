package com.sample.junit5.disabletest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

//Ignoring individual test methods
public class DisableTestCase {

	@Test
	public void printTest() {
		System.out.println("in IgnoreTestCase #printTest");
	}

	@Disabled("Do not run this")
	@Test
	public void ignoreTest() {
		System.out.println("in IgnoreTestCase #ignoreTest");
	}

}
