package com.almundo.automation.services;

import org.springframework.http.ResponseEntity;

public class ResponseData {

	private ResponseEntity<Object> response;
	
	private int statusCode;
	
	private String errorMessage;
	
	public ResponseData() {}
	
	public ResponseData(ResponseEntity<Object> response, int statusCode, String errorMessage) {
		this.response = response;
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}
	
	public ResponseEntity<Object> getResponse() {
		return response;
	}

	public void setResponse(ResponseEntity<Object> response) {
		this.response = response;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
	

}
