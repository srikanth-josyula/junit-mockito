package com.sample.junit4.basics;
/**
 *Assumption based testcases can be useful in following scenarios:
 *
 *Running testcases for specific application version(s)
 *Running testcases only when certain network resource (or any external service) is available
 *Running testcases in a certain locale only
 *Running testcases only under certain execution environment 
 * 
 **/

import org.junit.Test;
import static org.junit.Assume.*;

public class AssumptionsExample {

	@Test
	void test() {
		String test = "Hello";
		assumeTrue("Hello".equals(test));
	}

	@Test
	void test2() {
		String versionNumber = "7"; // Get it from configuration on runtime
		assumeTrue(Integer.valueOf(versionNumber) == 7);
	}
}
