package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class defines the POJO that contains the response of airlines on the
 * request parameters using Search service
 * 
 * @author zenen.morales
 *
 */
public class LowestPricesByAirline {

	@JsonProperty("airline")
	private Airline airline;

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

}
