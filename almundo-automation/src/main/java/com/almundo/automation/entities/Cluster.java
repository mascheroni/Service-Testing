package com.almundo.automation.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author zenen.morales
 *
 */
public class Cluster {

	private List<Segments> segments;
	private Price price;

	private boolean domestic;

	@JsonProperty("validating_carrier")
	private String validatingCarrier;

	public List<Segments> getSegments() {
		return segments;
	}

	public void setSegments(List<Segments> segments) {
		this.segments = segments;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public boolean isDomestic() {
		return domestic;
	}

	public void setDomestic(boolean domestic) {
		this.domestic = domestic;
	}

	public String getValidatingCarrier() {
		return validatingCarrier;
	}

	public void setValidatingCarrier(String validatingCarrier) {
		this.validatingCarrier = validatingCarrier;
	}

}
