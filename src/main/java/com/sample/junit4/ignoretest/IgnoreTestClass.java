package com.sample.junit4.ignoretest;

import org.junit.Ignore;
import org.junit.Test;

//Ignoring individual test class
@Ignore
public class IgnoreTestClass {
	
	@Test
    public void printTestClass() {
        System.out.println("in IgnoreTestClass #printTestClass");
    }
	
}
