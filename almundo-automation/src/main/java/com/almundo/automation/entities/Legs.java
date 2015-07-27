package com.almundo.automation.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legs {

	private Origin origin;
	private Destination destination;

	@JsonProperty("departure_date")
	private Date departureDate;

	// @JsonProperty("departure_time")
	// private DateTime departureTime;

	@JsonProperty("arrival_date")
	private Date arrivalDate;

	// @JsonProperty("arrival_time")
	// private DateTime arrivalTime;

	@JsonProperty("marketing_carrier")
	private MarketingCarrier marketingCarrier;

	@JsonProperty("operating_carrier")
	private OperatingCarrier operatingCarrier;

	private int number;

	@JsonProperty("cabin_type")
	private String cabinType;

	@JsonProperty("flight_class")
	private String flightClass;

	@JsonProperty("technical_stop")
	private String technicalStop;

	// @JsonProperty("flight_duration")
	// private String flightDuration;

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

	public MarketingCarrier getMarketingCarrier() {
		return marketingCarrier;
	}

	public void setMarketingCarrier(MarketingCarrier marketingCarrier) {
		this.marketingCarrier = marketingCarrier;
	}

	public OperatingCarrier getOperatingCarrier() {
		return operatingCarrier;
	}

	public void setOperatingCarrier(OperatingCarrier operatingCarrier) {
		this.operatingCarrier = operatingCarrier;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getTechnicalStop() {
		return technicalStop;
	}

	public void setTechnicalStop(String technicalStop) {
		this.technicalStop = technicalStop;
	}

}
