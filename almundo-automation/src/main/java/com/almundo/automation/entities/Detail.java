package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author zenen.morales
 *
 */
public class Detail {

	private float adultPrice;

	private float childPrice;

	private float infantPrice;

	private float taxes;

	@JsonProperty("extra_tax")
	private float extraTax;

	public float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public float getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}

	public float getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(float infantPrice) {
		this.infantPrice = infantPrice;
	}

	public float getTaxes() {
		return taxes;
	}

	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}

	public float getExtraTax() {
		return extraTax;
	}

	public void setExtraTax(float extraTax) {
		this.extraTax = extraTax;
	}

}
