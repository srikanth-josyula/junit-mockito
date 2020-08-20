package com.sample.mockito.xample.test.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.sample.mockito.xample.java.services.CustomService;
import com.sample.mockito.xample.java.services.impl.CustomServiceImpl;

public class CustomServiceImplTest {

	@Test
    public void testDoSomething2(){
		CustomService mock = Mockito.mock(CustomServiceImpl.class);
        Mockito.when(mock.printSomething()).thenReturn("Hello World Test Value");//stubbing
        String i = mock.printSomething();
        Assert.assertEquals(i, "Hello World Test Value");
    }

}
