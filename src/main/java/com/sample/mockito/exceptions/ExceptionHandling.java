package com.sample.mockito.exceptions;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ExceptionHandling {

	@Test(expected = IOException.class)
	public void IOexceptionHandler() throws IOException {

		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		doThrow(new IOException()).when(mock).close();
		osw.close();

	}

	@Test
	public void IOexceptionHandler2() throws IOException {
		
		OutputStream mock = mock(OutputStream.class);
		OutputStreamWriter osw = new OutputStreamWriter(mock);
		osw.close();
		verify(mock).close();
		
	}

}
