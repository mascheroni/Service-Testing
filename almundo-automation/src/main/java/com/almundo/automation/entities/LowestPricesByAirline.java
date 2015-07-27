package com.almundo.automation.entities;

import java.util.List;

/**
 * This class defines the POJO that contains the response of airlines on the
 * request parameters using Search service
 * 
 * @author zenen.morales
 *
 */
public class LowestPricesByAirline {

	private List<Airline> airlines;

	public List<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}

}
