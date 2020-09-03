package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJava8Examples {

	@Test
	@DisplayName("Should be empty")
	void shouldBeEmpty() {
		assertThat(Optional.empty()).isEmpty();
	}
	
	@Test
    @DisplayName("Should not be empty")
    void shouldNotBeEmpty() {
        assertThat(Optional.of(new Object())).isNotEmpty();
    }
	
	@Test
    @DisplayName("Should contain the correct object")
    void shouldContainCorrectObject() {
		Object OBJECT = new Object();
        assertThat(Optional.of(OBJECT)).contains(OBJECT);
    }
}
