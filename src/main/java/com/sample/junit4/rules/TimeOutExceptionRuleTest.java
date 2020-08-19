package com.sample.junit4.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeOutExceptionRuleTest {

	// Rather than specifying timeout attribute for all tests separately, we can
	// define JUnit Rule for all tests in a class.
	
	@Rule
	public Timeout globalTimeout = Timeout.millis(2000);

	@Test // Pass
	public void testInfiniteTametakingLoop1() throws InterruptedException {
		while (true) {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Test // Fail
	public void testInfiniteTametakingLoop2() throws InterruptedException {
		while (true) {
			try {
				Thread.currentThread();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
