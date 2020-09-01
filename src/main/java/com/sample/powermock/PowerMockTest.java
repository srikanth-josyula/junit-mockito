package com.sample.powermock;

/**
 * PowerMockito is a PowerMock's extension API to support Mockito. It provides
 * capabilities to work with the Java Reflection API in a simple way to overcome
 * the problems of Mockito, such as the lack of ability to mock final, static or
 * private methods.
 * 
 * 
 * PowerMock is an open-source Java framework used for creating a mock object in
 * unit testing. It extends other mocking frameworks such as EasyMock and
 * Mockito to enhance the capabilities. The PowerMock framework uses a custom
 * classloader and bytecode manipulation techniques to enable the mocking of
 * static methods, final classes, final methods, private methods, constructor,
 * and removal of static initializers. The main aim of PowerMock is to extend
 * the existing APIs with some methods and annotations to provide extra features
 * that make unit testing quite easy.
 **/

import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

class Utility {

	public static String staticMethod(String call) {
		return call;
	}

	private String privateMethod(String message) {
		return message;
	}

	public String callPrivateMethod(String message) {
		return privateMethod(message);
	}

	public final String finalMethod(String message) {
		return message;
	}
}

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class PowerMockTest {

	// Mocking static methods
	@Test
	public void TestStaticMethod_WithPowerMockito() {

		String call = " Hi there, I'm using PowerMock with Mockito ";
		String callexpectation = " Call Expectation for you. ";

		PowerMockito.mockStatic(Utility.class);
		PowerMockito.when(Utility.staticMethod(call)).thenReturn(callexpectation);

		String actualcall = Utility.staticMethod(call);
		assertEquals(callexpectation, actualcall);
	}

	// Mocking private methods
	@Test
	public void TestPrivateMethod_WithPowerMock() throws Exception {

		String message = " PowerMock with Mockito and JUnit ";
		String expectedmessage = " Using with EasyMock ";

		Utility mock = PowerMockito.spy(new Utility());
		PowerMockito.doReturn(expectedmessage).when(mock, "privateMethod", message);

		String actualmessage = mock.callPrivateMethod(message);
		assertEquals(expectedmessage, actualmessage);

		System.out.println(PowerMockito.verifyPrivate(getClass()));
	}

	// Mocking final methods
	@Test
	public void TestFinalMethod_WithPowerMock() throws Exception {

		String message = " PowerMock with Mockito and JUnit ";
		Utility uti = PowerMockito.mock(Utility.class);
		PowerMockito.whenNew(Utility.class).withNoArguments().thenReturn(uti);

		Utility uti2 = new Utility();
		PowerMockito.verifyNew(Utility.class).withNoArguments();

		PowerMockito.when(uti2.finalMethod(message)).thenReturn(message);

		String message2 = uti2.finalMethod(message);
		Mockito.verify(uti2).finalMethod(message);
		assertEquals(message, message2);
	}
}

/*
Mockito                     | PowerMock
------------------------------------------------------------------------------
2.0.0-beta - 2.0.42-beta    |   1.6.5+
------------------------------------------------------------------------------
1.10.19                     |   1.6.4
1.10.8 - 1.10.x             |   1.6.2+
1.9.5-rc1 - 1.9.5           |   1.5.0 - 1.5.6
1.9.0-rc1 & 1.9.0           |   1.4.10 - 1.4.12
1.8.5                       |   1.3.9 - 1.4.9
1.8.4                       |   1.3.7 & 1.3.8
1.8.3                       |   1.3.6
1.8.1 & 1.8.2               |   1.3.5
1.8                         |   1.3
1.7                         |   1.2.5
 */
