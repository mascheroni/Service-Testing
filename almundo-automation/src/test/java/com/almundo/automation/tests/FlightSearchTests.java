package com.almundo.automation.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.almundo.automation.services.ResponseData;
import com.almundo.automation.services.SearchService;
import com.almundo.automation.utils.DataProviders;

public class FlightSearchTests extends BaseTest {
	
	SearchService searchService;

	@BeforeClass
	public void setUp() {
		searchService = new SearchService();
	}
	
	@Test( groups = {"flight-search"}, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void prueba(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		//Test Code

	}

}