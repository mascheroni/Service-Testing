package com.almundo.automation.entities;

/**
 * Class that defines the airlines on the request parameters using Search service
 * 
 * @author zenen.morales
 *
 */
public class Airline {

	private String catalog_id;

	private String code;

	private String name;

	public Airline(String catalog_id, String code, String name) {
		this.catalog_id = catalog_id;
		this.code = code;
		this.name = name;
	}

	public String getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
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
