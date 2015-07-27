package com.almundo.automation.tests;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.almundo.automation.entities.SearchFlights;

public class FlightSearchTests extends BaseTest {

	@Test( groups = {"flight-search"})
	public void prueba(){
		String url = "https://apist.almundo.com/api/flights/itineraries?from=BUE&to=MIA&departure=2015-08-01&adults=1&children=1&class=C&site=ARG&language=ES";
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-UOW", "gbl-agustin");
	 	headers.set("X-ApiKey", "5592f8fd99325b40cba48649");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<SearchFlights> response = template.exchange(url, HttpMethod.GET, entity, SearchFlights.class);
		SearchFlights sf =  response.getBody();
		System.out.println("Printing status code");
		System.out.println(response.getStatusCode().toString());
		System.out.println("Printing IDs");
		System.out.println(sf.getId());
		System.out.println("Printing number of clusters");
		System.out.println(sf.getClusters().size());
		System.out.println("Printing number of filters");
		System.out.println(sf.getFilters().size());
		
	}

}