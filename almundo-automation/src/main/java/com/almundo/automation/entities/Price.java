package com.almundo.automation.entities;

/**
 * 
 * @author zenen.morales
 *
 */
public class Price {

	private float total;

	private Detail detail;

	private Currency currency;
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
