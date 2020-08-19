package com.sample.junit4.basics;

import org.junit.Test;
import static org.junit.Assume.*;

public class AssumptionsExample {
	
	@Test
	void test() {
		String test = "Hello";
		assumeTrue("Hello".equals(test));
	}

}
