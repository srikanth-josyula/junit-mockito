package com.sample.mockito.xample.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.sample.mockito.xample.java.Utility;
import com.sample.mockito.xample.java.services.CustomService;

public class UtilityTest {
	
	@Test
    public void processTest() {
		CustomService serviceTest = Mockito.mock(CustomService.class);
        Mockito.when(serviceTest.printSomething()).thenReturn("Hello World Srikanth");
        Utility utilTest = new Utility(serviceTest);
        String returnedValue = utilTest.process();
        Assert.assertEquals(returnedValue, "The Response is: Hello World Srikanth");
    }
}
