package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class AssertJMapTest {
	private Map<String, String> map = new HashMap<>();

	@Test
	@DisplayName("Should contain the correct key")
	void shouldContainCorrectKey() {
		map.put("Sri", "Kanth");

		assertThat(map).containsKey("Sri");
		assertThat(map).doesNotContainKey("Srikanth");

		assertThat(map).containsEntry("Sri", "Kanth");
		assertThat(map).doesNotContainEntry("Srikanth", "Josyula");
	}
}
