package com.almundo.automation.services;

import org.springframework.http.ResponseEntity;

public class GenericService {

	public GenericService() {
		
	}
	
	public ResponseData createResponse(ResponseEntity<Object> response, int statusCode, String message) {
		return new ResponseData(response, statusCode, message);
	}

}
