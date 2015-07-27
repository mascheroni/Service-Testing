package com.almundo.automation.services;

import java.util.List;

public class SearchParameters {

	public SearchParameters() {
	}

	public List<Parameters> concatenateParametersRoundtrip(
			List<Parameters> params) {
//		Parameters from = null;
//		Parameters to = null;
//		Parameters departureDate = null;
//		Parameters returnDate = null;
//
//		int fromIndex = -1;
//		int toIndex = -1;
//		int departureIndex = -1;
//		int returnIndex = -1;
//		
//		for(int i = 0; i < params.size(); i++){
//			String value = params.get(i).valor();
//			switch (value){
//			case"from":
//				from = params.get(i);
//				fromIndex = i;
//				break;
//			case "to":
//				to = params.get(i);
//				toIndex = i;
//				break;
//			case "departure":
//				departureDate = params.get(i);
//				departureIndex = i;
//				break;
//			case "return":
//				returnDate = params.get(i);
//				returnIndex = i;
//				break;
//			case "roundtrip":
//				if(params.get(i).valor().equalsIgnoreCase("true")){
//					params.get(fromIndex).valor(appendParams(from, to));
//					params.get(toIndex).valor(appendParams(to, from));
//					params.get(departureIndex).valor(appendParams(departureDate, returnDate));
//					params.get(returnIndex).valor(appendParams(returnDate, departureDate));
//				}
//			
//			}
//		}

		return params;

	}
	
	public String appendParams(Parameters from, Parameters to){
		StringBuffer sb = new StringBuffer();
		sb.append(from.valor());
		sb.append(",");
		sb.append(to.valor());
		return sb.toString();
	}

}
