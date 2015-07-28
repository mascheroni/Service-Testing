package com.almundo.automation.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.almundo.automation.entities.Cluster;
import com.almundo.automation.entities.FlightResults;
import com.almundo.automation.entities.LowestPricesByAirline;
import com.almundo.automation.services.ResponseData;
import com.almundo.automation.services.SearchService;
import com.almundo.automation.utils.DataProviders;

public class FlightSearchTests extends BaseTest {

	private SearchService searchService;
	
	private static final int OLD_DATE_STATUS_CODE = 400;
	private static final String OLD_DATE_ERROR = "you cannot make a search in the past";

	@BeforeClass(groups = { "flight-search" })
	public void setUp() {
		searchService = new SearchService();
	}

	@Test(	description = "Verify the error message to search flights with old dates",
			groups = { "flight-search" }, dataProvider = "searchOldDates",
			dataProviderClass = DataProviders.class )
	public void verify404ErrorWithOldDates(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertEquals(responseData.getStatusCode(), OLD_DATE_STATUS_CODE);
		String actualErrorMessage = responseData.getErrorMessage();
		if (!actualErrorMessage.contains(OLD_DATE_ERROR))
			Assert.fail("The error message is: " + actualErrorMessage);
	}
	
	@Test(	description = "Verify airline names not null", 
			groups = { "flight-search"}, dataProvider = "searchGenericData",
			dataProviderClass = DataProviders.class )
	public void verifyAirlineNamesNotNull(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertNotNull(responseData.getResponse(), 
				"Error: " + responseData.getStatusCode() + ": "
				+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse().getBody();
		for (LowestPricesByAirline lpba: results.getLowestPricesByAirline()) {
			Assert.assertNotNull(lpba.getAirline().getName(),
					"The airlines " + lpba.getAirline().getCode() + 
					" returns null in its name field");
		}
	}
	
	@Test(	description = "Verify domestic field = false with international flights",
			groups = { "flight-search"}, dataProvider = "searchGenericData",
			dataProviderClass = DataProviders.class )
	public void verifyAirportNameNotNull(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertNotNull(responseData.getResponse(), 
				"Error: " + responseData.getStatusCode() + ": "
				+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse().getBody();
		for (Cluster cluster: results.getClusters()) {
			Assert.assertFalse(cluster.isDomestic(), "The domestic field is true");
		}
	}
	
	
	
	
	

}