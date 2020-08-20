package com.sample.junit5.basics;
/**
 *Assumption based testcases can be useful in following scenarios:
 *
 *Running testcases for specific application version(s)
 *Running testcases only when certain network resource (or any external service) is available
 *Running testcases in a certain locale only
 *Running testcases only under certain execution environment 
 * 
 **/
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssumptionsExample {

	@Test
	void test() {
		String test = "Hello";
		assumeTrue("Hello".equals(test));
	}
	
	@Test
	void test2() {
		String test = "Hello";
		assumeFalse("Hello !".equals(test));
	}

	@Test
	void test3() {
		String versionNumber = "7"; // Get it from configuration on runtime
		assumeTrue(Integer.valueOf(versionNumber) == 7);
	}
}
