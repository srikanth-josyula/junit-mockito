package com.sample.junit4.ignoretest;

import org.junit.Ignore;
import org.junit.Test;

//Ignoring individual test methods
public class IgnoreTestCase {
	
	@Test
    public void printTest() {
        System.out.println("in IgnoreTestCase #printTest");
    }
	
    @Ignore
    @Test
    public void ignoreTest() {
        System.out.println("in IgnoreTestCase #ignoreTest");
    }

}

//OutPut
//in IgnoreTestCase #printTest