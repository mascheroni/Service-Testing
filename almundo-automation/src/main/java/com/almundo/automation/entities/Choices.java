package com.almundo.automation.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choices {

	private String id;

	@JsonProperty("departure_date")
	private Date departureDate;

	// @JsonProperty("departure_time")
	// private DateTime departureTime;

	@JsonProperty("arrival_date")
	private Date arrivalDate;

	// @JsonProperty("arrival_time")
	// private DateTime arrivalTime;

	private Origin origin;
	private Destination destination;
	private List<Legs> legs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
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

}
