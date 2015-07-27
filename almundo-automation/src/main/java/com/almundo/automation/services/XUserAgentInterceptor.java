package com.almundo.automation.services;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class XUserAgentInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body,
			ClientHttpRequestExecution execution) throws IOException {
		HttpHeaders headers = request.getHeaders();
		headers.set("X-UOW", "gbl-zenen");
		headers.set("X-ApiKey", "5592f8fd99325b40cba48649");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return execution.execute(request, body);
	}
}