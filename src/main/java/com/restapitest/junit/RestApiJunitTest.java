package com.restapitest.junit;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

public class RestApiJunitTest {

	/** Testing the Status Code **/
	@Test
	public void givenUserDoesNotExistsTest() throws Exception {

		// Given
		String name = RandomStringUtils.randomAlphabetic(8);
		HttpUriRequest request = new HttpGet("https://api.github.com/users/" + name);

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NOT_FOUND);
	}

	/** Testing the Media Type **/
	@Test
	public void givenRequestWithNoAcceptHeaderTest() throws Exception {

		// Given
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet("https://api.github.com/users/eugenp");

		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		// Then
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals(jsonMimeType, mimeType);
	}

}
