package com.sample.junit4.basics;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeOutHandlerTest {
	@Test(timeout = 200)
	public void testMethod() {
		boolean b = true;
		if (b) {
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
