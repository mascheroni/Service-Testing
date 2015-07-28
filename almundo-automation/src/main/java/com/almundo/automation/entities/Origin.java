package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Origin {

	@JsonProperty("catalog_id")
	private Integer catalogId;

	@JsonProperty("code")
	private String code;

	@JsonProperty("name")
	private String name;

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
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
