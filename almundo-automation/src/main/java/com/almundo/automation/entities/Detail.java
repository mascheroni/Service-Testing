package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author zenen.morales
 *
 */
public class Detail {

	@JsonProperty("adults")
	private Float adultPrice;

	@JsonProperty("children")
	private Float childPrice;

	@JsonProperty("infants")
	private Float infantPrice;
	
	@JsonProperty("taxes")
	private Float taxes;
	
	@JsonProperty("charges")
	private Float charges;
	
	@JsonProperty("fee")
	private Float fee;

	@JsonProperty("extra_tax")
	private Float extraTax;

	public Float getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(Float adultPrice) {
		this.adultPrice = adultPrice;
	}

	public Float getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(Float childPrice) {
		this.childPrice = childPrice;
	}

	public Float getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(Float infantPrice) {
		this.infantPrice = infantPrice;
	}

	public Float getTaxes() {
		return taxes;
	}

	public void setTaxes(Float taxes) {
		this.taxes = taxes;
	}

	public Float getExtraTax() {
		return extraTax;
	}

	public void setExtraTax(Float extraTax) {
		this.extraTax = extraTax;
	}

	public Float getCharges() {
		return charges;
	}

	public void setCharges(Float charges) {
		this.charges = charges;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}
	
	

}
