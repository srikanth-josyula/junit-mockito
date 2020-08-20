package com.sample.junit5.basics;

/**
 * JUnit 5 is composed of several different modules:
 * JUnit Platform: It is JUnit core which allows test execution.
 * JUnit Jupiter: JUnit 5 API (new) and a combination of new programming model and extension model for writing tests.
 * JUnit Vintage: It provides a TestEngine which bridges JUnit 3/JUnit 4 tests to JUnit 5 platform. This means previous versions of JUnit can coexist with JUnit 5.
 * 
 **/
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@RunWith(JUnitPlatform.class)
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
