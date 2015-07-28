package com.almundo.automation.services;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HTTPClient {

	private HttpEntity<String> addAlmundoHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-UOW", "gbl-agustin");
	 	headers.set("X-ApiKey", "5592f8fd99325b40cba48649");
	 	return new HttpEntity<String>(headers);
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<Object> get(URI url, Class<?> type){
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = this.addAlmundoHeaders();
		return (ResponseEntity<Object>) template.exchange(url, HttpMethod.GET, entity, type);	
	}
	
}