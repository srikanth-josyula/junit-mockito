package com.sample.mockito.xample.test.services;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.sample.mockito.xample.java.services.CustomService;

public class  CustomServiceTest {
	@Test
    public void testDoSomething(){
		CustomService mock = Mockito.mock(CustomService.class);
        String i = mock.printSomething();
        Assert.assertEquals(i, null);
    }
}
