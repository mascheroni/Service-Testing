package com.almundo.automation.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Class that represent the response of search flights using Search service
 * 
 * @author zenen.morales
 *
 */
public class SearchFlights implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private List<LowestPricesByAirline> lowest_prices_by_airline;
	private List<Cluster> clusters;
	private List<Filter> filters;

	public SearchFlights() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public List<LowestPricesByAirline> getLowestPricesByAirline() {
		return lowest_prices_by_airline;
	}

	public void setLowestPricesByAirline(
			List<LowestPricesByAirline> lowest_prices_by_airline) {
		this.lowest_prices_by_airline = lowest_prices_by_airline;
	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

}
