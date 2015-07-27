package com.almundo.automation.services;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.almundo.automation.entities.Pagination;

public class OneKeyController {

	private final String URL = "https://apist.almundo.com/api/flights/itineraries?from=BUE&to=MIA&departure=2015-07-26&adults=2&children=1&infants=1&airlines=AA,LA,DL,AR,CM,OB&site=ARG&language=ES&offset=0&limit=100";

	public void template() {
		System.out.println("OneKeyController");
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("X-UOW", "gbl-zenen");
		headers.set("X-ApiKey", "5592f8fd99325b40cba48649");

		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);

		Pagination pagination = restTemplate.getForObject(URL,
				Pagination.class, entity);

		System.out.println(pagination.getLimit());

		// ResponseEntity<String> response = restTemplate
		// .getForEntity(
		// "https://apist.almundo.com/api/flights/itineraries?from=BUE&to=MIA&departure=2015-07-26&adults=2&children=1&infants=1&airlines=AA,LA,DL,AR,CM,OB&site=ARG&language=ES&offset=0&limit=100",
		// String.class);
		//
		// System.out.println(response);
	}

	public void getPositions() {
		System.out.println("getPositions");

		ConfigRestTemplate myApp = new ConfigRestTemplate();
		RestTemplate restTemplate = myApp.restTemplate();

		/* restTemplate > POST - GET */

		// POST restTemplate.postForLocation(String, Object, String...)
		// restTemplate.getForObjtec

		ResponseEntity<String> response = restTemplate.getForEntity(URL,
				String.class);

		System.out.println(response);
		Pagination pagination = restTemplate
				.getForObject(URL, Pagination.class);

		// ResponseEntity<Pagination> responseEntity=restTemplate.exchange(URL,
		// Pagination.class);

		System.out.println("Limit: " + pagination.getLimit());
		System.out.println("offset: " + pagination.getOffset());
		System.out.println("total: " + pagination.getTotal());
	}

}
