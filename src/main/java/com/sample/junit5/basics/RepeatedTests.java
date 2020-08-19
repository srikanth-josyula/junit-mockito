package com.sample.junit5.basics;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

class Sample {
	public String print() {
		return "Hello World";
	}
}

@RunWith(JUnitPlatform.class)
public class RepeatedTests {

	@BeforeEach
    public void initEach(){
        System.out.println("Before Each initEach() method called");
    }
	
	@DisplayName("RepeatedTest annotation usage")
	@RepeatedTest(5)
	//RepetitionInfo is used to inject information about the current repetition of a repeated test into @RepeatedTest, @BeforeEach, and @AfterEach methods.
	public void test(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println("Running TestCase for -> " + repetitionInfo.getCurrentRepetition());
		Sample hello = new Sample();
		String result = hello.print();
		assertEquals("Hello World", result, "Always True");
	}
	
	/**
	 *{displayName}: display name of the @RepeatedTest method.
	 *{currentRepetition}: the current repetition count.
	 *{totalRepetitions}: the total number of repetitions. 
	 **/
	@DisplayName("Custom Display Test Names")
	@RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
	public void test1(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println("Running TestCase for -> " + repetitionInfo.getCurrentRepetition());
		Sample hello = new Sample();
		String result = hello.print();
		assertEquals("Hello World", result, "Always True");
	}
	
	/**
	 * RepeatedTest.LONG_DISPLAY_NAME and RepeatedTest.SHORT_DISPLAY_NAME. SHORT_DISPLAY_NAME is default format if none specified.
	 * RepeatedTest.LONG_DISPLAY_NAME – {displayName} :: repetition {currentRepetition} of {totalRepetitions}
	 * RepeatedTest.SHORT_DISPLAY_NAME – repetition {currentRepetition} of {totalRepetitions} 
	 * 
	 **/
	@DisplayName("Display names with predefined formats")
	@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
	void addNumber(TestInfo testInfo) {
		Sample hello = new Sample();
		String result = hello.print();
		assertEquals("Hello World", result, "Always True");
	}
	
	@AfterEach
    public void cleanUpEach(){
        System.out.println("After Each cleanUpEach() method called");
        System.out.println();
    }
     

}
