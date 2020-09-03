package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJExceptionHandling {

	@Test
	@DisplayName("Should throw the correct exception")
	void shouldThrowCorrectException() {
		assertThatThrownBy(() -> {
			throw new NullPointerException();
		}).isExactlyInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("Should throw an exception that has the correct message")
	void shouldThrowAnExceptionWithCorrectMessage() {
		assertThatThrownBy(() -> {
			throw new NullPointerException("Hello World!");
		}).hasMessage("Hello World!").hasMessageEndingWith("!");
	}
	
	/*
	 assertThat(someFile)
	   .exists()
	   .isFile()
	   .canRead()
	   .canWrite();*/
}
