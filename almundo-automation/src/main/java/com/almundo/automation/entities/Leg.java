package com.almundo.automation.entities;

public class Leg {

	private MarketingCarrier marketingCarriers;
	private OperatingCarrier operatingCarrier;
	

	private int number;

	public Leg() {

	}

	public MarketingCarrier getMarketingCarriers() {
		return marketingCarriers;
	}

	public void setMarketingCarriers(MarketingCarrier marketingCarriers) {
		this.marketingCarriers = marketingCarriers;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public OperatingCarrier getOperatingCarrier() {
		return operatingCarrier;
	}

	public void setOperatingCarrier(OperatingCarrier operatingCarrier) {
		this.operatingCarrier = operatingCarrier;
	}

}
