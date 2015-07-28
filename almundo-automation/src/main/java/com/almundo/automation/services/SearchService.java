package com.almundo.automation.services;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.almundo.automation.entities.FlightResults;
import com.almundo.automation.utils.PropertyReader;

public class SearchService extends GenericService {

	private PropertyReader pr = new PropertyReader();
	
	public SearchService() {
		
	}
	
	public ResponseData retrieveFlights(Map<String, String> data) {
		URI uri = this.getURIPath(data);
		HTTPClient client = new HTTPClient();
		try {
			ResponseEntity<Object> response =  client.get(uri, FlightResults.class);
			return createResponse(response, response.getStatusCode().value(), "Success!");
		} catch (HttpClientErrorException e) {
			return createResponse(null, e.getStatusCode().value(), e.getResponseBodyAsString());
		} catch (Exception e) {
			e.printStackTrace();
			return createResponse(null, 0, "Generic Exception");
		}
		 
	}
	
	public URI getURIPath(Map<String, String> data) {
		Iterator<Entry<String, String>> it = data.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		sb.append(pr.getPropertiesValues("ITINERARI_SERVICE",
				"conf/conf.properties"));
		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Map.Entry<String, String>) it
					.next();
			sb.append(pair.getKey());
			sb.append("=");
			sb.append(pair.getValue());
			sb.append("&");
		}

		String url = sb.toString().substring(0, sb.length() - 1);
		
		try {
			URI uri = new URI(url);
			return uri;
		} catch (URISyntaxException e) {
			return null;
		}
	}

}
