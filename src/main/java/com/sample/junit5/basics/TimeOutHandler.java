package com.sample.junit5.basics;

/**
 *assertTimeout() and assertTimeoutPreemptively() both are used to test long running tasks. 
 *If given task inside testcase takes more than specified duration, then test will fail.
 *
 *Only different between both methods is that in assertTimeoutPreemptively(), 
 *execution of the Executable or ThrowingSupplier will be preemptively aborted if the timeout is exceeded. 
 *In case of assertTimeout(), Executable or ThrowingSupplier will NOT be aborted. 
 * 
 **/
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class TimeOutHandler {
	
	@Test
	public void test1() {

		// This will pass
		assertTimeout(Duration.ofMinutes(1), () -> {
			return "result";
		});

	}
	@Test
	public void test2() {

		// This will pass
		assertTimeout(Duration.ofMillis(200), () -> {
			Thread.sleep(200);
			return "result";
		});
	}
	@Test
	public void test3() {

		// This will fail
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(200);
			return "result";
		});
	}
}
