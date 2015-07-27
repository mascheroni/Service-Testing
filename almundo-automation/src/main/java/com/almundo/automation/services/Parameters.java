package com.almundo.automation.services;

public enum Parameters {
	FROM("from", null), TO("to", null), DEPARTURE("departure", null), CABINTYPE(
			"cabinType", null), ADULTS("adults", null), CHILDREN("children",null), PRICE("price",null), AIRLINES("airlines", null), 
			STOPS("stops",null), DEPARTURETIME("departureTime",null), RETURNTIME("returnTime",null), OUTBOUNDARRIVALAIRPORT("outboundArrivalAirport",null), 
			OUTBOUNDDEPARTUREAIRPORT("outboundDepartureAirport",null), INBOUNDDEPARTUREAIRPORT("inboundDepartureAirport",null), 
			INBOUNDARRIVALAIRPORT("InboundArrivalAirport",null), SITE("site",null), LANGUAGE("language",null) , ROUNDTRIP("roundtrip","FALSE");

	private final String parametro;
	private String valor;

	Parameters(String parametro, String valor) {
		this.parametro = parametro;
		this.valor = valor;
	}
	
	
	String parametro (){ return this.parametro;}
	public String valor (){return this.valor;}
	
	public void valor(String valor){this.valor = valor;}

}

