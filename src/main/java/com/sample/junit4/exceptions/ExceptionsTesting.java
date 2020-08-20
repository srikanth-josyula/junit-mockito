package com.sample.junit4.exceptions;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionsTesting {
	
	
	// CASE -1 Set the expected parameter @Test(expected = FileNotFoundException.class).

	@Test(expected = FileNotFoundException.class)
	public void testReadFile() throws IOException {
		FileReader reader = new FileReader("test.txt");
		reader.read();
		reader.close();
	}
	
	
	// CASE -2 Using try catch

	@Test
	public void testReadFile2() {
		try {
			FileReader reader = new FileReader("test.txt");
			reader.read();
			reader.close();
			fail("Expected an IOException to be thrown");
		} catch (IOException e) {
			//assertThat(e.getMessage(), is("test.txt (No such file or directory)"));
		}

	}
	
	
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
