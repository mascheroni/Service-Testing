package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
	
	@JsonProperty("code")
	private String code;

	@JsonProperty("mask")
	private String mask;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

}
