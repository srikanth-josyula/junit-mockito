package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJListTest {
	private List<String> list = Arrays.asList("Sri", "Kanth");

	@Test
	@DisplayName("Should contain two elements")
	void shouldContainTwoElements() {
		assertThat(list).hasSize(2);
	}

	@Test
	@DisplayName("Should contain the correct elements in the given order")
	void shouldContainCorrectElementsInGivenOrder() {
		assertThat(list).containsExactly("Sri", "Kanth");
	}

	@Test
	@DisplayName("Should contain the correct elements in any order")
	void shouldContainCorrectElementsInAnyOrder() {
		assertThat(list).containsExactlyInAnyOrder("Kanth", "Sri");
	}

	@Test
	@DisplayName("Should contain the correct element once")
	void shouldContainCorrectElementOnce() {
		assertThat(list).containsOnlyOnce("Sri");
	}

	@Test
	@DisplayName("Should not contain an incorrect element")
	void shouldNotContainIncorrectElement() {
		assertThat(list).doesNotContain(new String());
	}

	@Test
	@DisplayName("iteration testing")
	void iterationTest() {
		assertThat(list).contains("Kanth");
		assertThat(list).isNotEmpty();
		assertThat(list).startsWith("Sri");

		assertThat(list)
		  .isNotEmpty()
		  .contains("Kanth")
		  .doesNotContainNull()
		  .containsSequence("Sri", "Kanth");


	}

}
