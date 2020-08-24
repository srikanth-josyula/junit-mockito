package com.sample.junit4.basics;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

class Simple {

	public Boolean printSomething(String msg) {
		if ("Hello World".equalsIgnoreCase(msg)) {
			return true;
		} else {
			return false;
		}

	}

}

@RunWith(Parameterized.class)
public class ParameterizedTests {
	
	Simple simple = new Simple();
	
	private String input;
	private Boolean expectedOutput;
	
	public ParameterizedTests(String input, Boolean expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	// in the collection we have defined the expected input and output as a series of conditions.
	@Parameters
	public static Collection<Object[]>  testConditions() {
		 return Arrays.asList(new Object[][] {
	         { "Hello World", true },
	         { "Hello World Srikanth", false },
	      });
	}
	
	
	// This test will run 2 times since we have 2 parameters defined
	   @Test
	   public void testMethod() {
	      System.out.println("Parameterized Value is : " + input);
	      assertEquals(expectedOutput, 
	    		  simple.printSomething(input));
	   }
}
