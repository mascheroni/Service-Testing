package com.almundo.automation.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choices {

	private String id;

	@JsonProperty("departure_date")
	private String departureDate;

	@JsonProperty("departure_time")
	private String departureTime;

	@JsonProperty("arrival_date")
	private String arrivalDate;

	@JsonProperty("arrival_time")
	private String arrivalTime;

	private Origin origin;
	private Destination destination;
	private List<Legs> legs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Legs> getLegs() {
		return legs;
	}

	public void setLegs(List<Legs> legs) {
		this.legs = legs;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	

}
