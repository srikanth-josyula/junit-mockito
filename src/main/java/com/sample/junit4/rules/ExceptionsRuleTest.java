package com.sample.junit4.rules;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionsRuleTest {
	
	// CASE -3 Testing with ExpectedException Rule.

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testReadFile3() throws IOException {
		thrown.expect(IOException.class);
		FileReader reader = new FileReader("test.txt");
		reader.read();
		reader.close();
	}
}
