package com.sample.junit4.rules;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


public class TemporaryFolderTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	public void testWrite() throws IOException {
		
		// Create a temporary file.
		final File tempFile = tempFolder.newFile("tempFile.txt");

		// Write something to it.
		FileUtils.writeStringToFile(tempFile, "hello world");

		// Read it from temp file
		final String s = FileUtils.readFileToString(tempFile);

		// Verify the content
		assertEquals("hello world", s);

		// Note: File is guaranteed to be deleted after the test finishes.
	}
}