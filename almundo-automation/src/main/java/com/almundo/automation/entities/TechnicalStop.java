package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TechnicalStop {
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("arrival_date")
	private String arrivalDate;
	
	@JsonProperty("arrival_time")
	private String arrivalTime;
	
	@JsonProperty("departure_date")
	private String departureDate;
	
	@JsonProperty("departure_time")
	private String departureTime;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	
	
}