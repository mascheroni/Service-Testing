package com.almundo.automation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legs {

	private Origin origin;
	private Destination destination;

	@JsonProperty("departure_date")
	private String departureDate;

	@JsonProperty("departure_time")
	private String departureTime;

	@JsonProperty("arrival_date")
	private String arrivalDate;

	@JsonProperty("arrival_time")
	private String arrivalTime;

	@JsonProperty("marketing_carrier")
	private MarketingCarrier marketingCarrier;

	@JsonProperty("operating_carrier")
	private OperatingCarrier operatingCarrier;

	@JsonProperty("number")
	private Integer number;

	@JsonProperty("cabin_type")
	private String cabinType;

	@JsonProperty("flight_class")
	private String flightClass;

	@JsonProperty("technical_stop")
	private TechnicalStop technicalStop;

	@JsonProperty("flight_duration")
	private String flightDuration;

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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
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
	
	public TechnicalStop getTechnicalStop() {
		return technicalStop;
	}

	public void setTechnicalStop(TechnicalStop technicalStop) {
		this.technicalStop = technicalStop;
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

	public String getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(String flightDuration) {
		this.flightDuration = flightDuration;
	}
	
	

}
