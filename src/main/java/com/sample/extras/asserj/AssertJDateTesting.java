package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJDateTesting {

	public void dateTest() {
		long aDay = TimeUnit.DAYS.toMillis(1);
		long now = new Date().getTime();
		Date hundredYearsAgo = new Date(now - aDay * 365 * 100);
		Date tenDaysAgo = new Date(now - aDay * 10);
		Date today = new Date();
		
		assertThat(tenDaysAgo).isBefore(today);
		assertThat(tenDaysAgo).isBetween(hundredYearsAgo, today);
	}
}
