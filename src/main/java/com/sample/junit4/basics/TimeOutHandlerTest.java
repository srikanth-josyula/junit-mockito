package com.sample.junit4.basics;

import org.junit.Test;

public class TimeOutHandlerTest {
	
	@Test(timeout = 200)
	public void testMethod() {
		boolean b = true;
		if (b) {
			try {
				Thread.currentThread();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
