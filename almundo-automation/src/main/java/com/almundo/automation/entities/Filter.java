package com.almundo.automation.entities;

import java.util.List;

import com.almundo.automation.entities.Value;

/**
 * 
 * @author zenen.morales
 *
 */
public class Filter {

	private String key;
	private String type;
	private List<Value> values;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

}
