package com.sample.extras.asserj;

/**
 * AssertJ provides a set of classes and utility methods that allow us to write fluent and beautiful assertions
 * 
 * AssertJ provides a rich set of assertions, truly helpful error messages,
 * improves test code readability and is designed to be super easy to use within your favorite IDE
 * 
 * Provides assertions for Joda Time types like DateTime and LocalDateTime and JAVA8
 **/
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJTestExamples {

	@Test
	@DisplayName("Should be true")
	public void shouldBeTrue() {
		assertThat(true).isTrue();
	}

	@Test
	@DisplayName("Should be false")
	public void shouldBeFalse() {
		assertThat(false).isFalse();
	}

	@Test
	@DisplayName("Should be null")
	public void shouldBeNull() {
		Object nullObject = null;
		assertThat(nullObject).isNull();
	}

	@Test
	@DisplayName("Should be equal")
	public void shouldBeEqual() {
		assertThat(9).isEqualByComparingTo(9);
	}

	@Test
	@DisplayName("Should not be equal")
	public void shouldNotBeEqual() {
		assertThat(9).isNotEqualByComparingTo(12);
	}

	@Test
	@DisplayName("Should refer to the same object")
	void shouldReferToSameObject() {
		Object ACTUAL = new Object();
		Object EXPECTED = ACTUAL;
		assertThat(ACTUAL).isSameAs(EXPECTED);
	}

	@Test
	@DisplayName("Should not refer to the same object")
	void shouldNotReferToSameObject() {
		Object ACTUAL = new Object();
		Object EXPECTED = new Object();
		assertThat(ACTUAL).isNotSameAs(EXPECTED);
	}

	@Test
	@DisplayName("Should contain the same integers")
	void shouldContainSameIntegers() {
		int[] ACTUAL = new int[] { 2, 5, 7 };
		int[] EXPECTED = new int[] { 2, 5, 7 };
		assertThat(ACTUAL).isEqualTo(EXPECTED);
	}

	@Test
	@DisplayName("Should not contain the same integers")
	void shouldNotContainSameIntegers() {
		int[] ACTUAL = new int[] { 2, 6, 7 };
		int[] EXPECTED = new int[] { 2, 5, 7 };
		assertThat(ACTUAL).isNotEqualTo(EXPECTED);
	}

	@Test
	@DisplayName("Provide a custom error message Should override only the description")
	void shouldBeFalseWithCustomErrorMessage() {
		assertThat(false).describedAs("The boolean is not false").isFalse();
	}

	@Test
	@DisplayName("Should override entire error message")
	void shouldBeFalseWithCustomErrorMessage2() {
		assertThat(false).overridingErrorMessage("The boolean is not false").isFalse();
	}

}
