package com.almundo.automation.entities;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author zenen.morales
 *
 */
public class Value {

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("code")
	private String code;

	@SerializedName("name")
	private String name;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
