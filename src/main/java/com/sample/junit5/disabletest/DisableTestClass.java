package com.sample.junit5.disabletest;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

//Ignoring individual test class
@Disabled
public class DisableTestClass {
	
	@Test
    public void printTestClass() {
        System.out.println("in IgnoreTestClass #printTestClass");
    }
	
}
