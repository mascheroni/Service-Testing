package com.almundo.automation.services;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.almundo.automation.utils.EncryptKey;
import com.almundo.automation.utils.PropertyReader;

public class HTTPClient {
	
	private static final String PROP_FILE = "conf/conf.properties";
	private static final String UOW_KEY = "glbUserName";
	private static final String API_KEY = "API-Key";
	

	private HttpEntity<String> addAlmundoHeaders() {
		PropertyReader propertyReader = new PropertyReader();
		HttpHeaders headers = new HttpHeaders();
		
		String uow = propertyReader.getPropertiesValues(UOW_KEY, PROP_FILE);
		String encryptedKey = propertyReader.getPropertiesValues(API_KEY, PROP_FILE);
		String apiKey = EncryptKey.decryptText(encryptedKey);
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 
		headers.set("X-UOW", uow);
	 	headers.set("X-ApiKey", apiKey);
	 	return new HttpEntity<String>(headers);
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<Object> get(URI url, Class<?> type){
		RestTemplate template = new RestTemplate();
		HttpEntity<String> entity = this.addAlmundoHeaders();
		return (ResponseEntity<Object>) template.exchange(url, HttpMethod.GET, entity, type);	
	}
	
}