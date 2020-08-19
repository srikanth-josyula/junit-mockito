package com.sample.junit4.inheritence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyBaseClass {

    @BeforeClass
    public static void beforeBaseClassMethod() {
        System.out.println("MyBaseClass: @BeforeClass static method invoked.");
    }

    @Before
    public void beforeBaseMethod() {
        System.out.println("MyBaseClass: @Before method invoked.");
    }

    @After
    public void afterBaseMethod() {
        System.out.println("MyBaseClass: @After method invoked.");
    }

    @Test
    public void testBaseMethod1() {
        System.out.println("MyBaseClass: in testMethod1()");
    }
}