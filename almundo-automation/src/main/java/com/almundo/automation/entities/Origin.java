package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin {

	@JsonProperty("catalog_id")
	private String catalogId;

	@JsonProperty("code")
	private String code;

	@JsonProperty("name")
	private String name;

	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
