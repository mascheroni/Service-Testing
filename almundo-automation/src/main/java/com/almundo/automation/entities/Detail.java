package com.almundo.automation.entities;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author zenen.morales
 *
 */
public class Detail {

	@SerializedName("adults")
	private float adultPrice;

	@SerializedName("children")
	private float childPrice;

	@SerializedName("infants")
	private float infantPrice;

	@SerializedName("taxes")
	private float taxes;

	@SerializedName("extra_tax")
	private float extra_tax;

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

	public float getExtra_tax() {
		return extra_tax;
	}

	public void setExtra_tax(float extra_tax) {
		this.extra_tax = extra_tax;
	}

}
