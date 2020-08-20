package com.sample.junit5.exceptions;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class ExceptionsTesting {

	@Test
	public void testReadFile2() {
		try {
			FileReader reader = new FileReader("test.txt");
			reader.read();
			reader.close();
			fail("Expected an IOException to be thrown");
		} catch (IOException e) {
			// assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
		}

	}

}
