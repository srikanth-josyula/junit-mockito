package com.sample.junit5.basics;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LifeCycleTest {
	
	@BeforeAll
	public static void setup() {
		System.out.println("@BeforeAll executed");
	}

	@BeforeEach
	public void setupThis() {
		System.out.println("@BeforeEach executed");
	}

	@Test
	public void testCalcOne() {
		System.out.println("======TEST ONE EXECUTED=======");
	}

	@Test
	public void testCalcTwo() {
		System.out.println("======TEST TWO EXECUTED=======");
	}

	@AfterEach
	public void tearThis() {
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	public static void tear() {
		System.out.println("@AfterAll executed");
	}
}
