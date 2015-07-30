package com.almundo.automation.tests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.almundo.automation.entities.Choices;
import com.almundo.automation.entities.Cluster;
import com.almundo.automation.entities.FlightResults;
import com.almundo.automation.entities.Legs;
import com.almundo.automation.entities.LowestPricesByAirline;
import com.almundo.automation.entities.Segments;
import com.almundo.automation.services.ResponseData;
import com.almundo.automation.services.SearchService;
import com.almundo.automation.utils.DataProviders;
import com.almundo.automation.utils.Utils;

public class FlightSearchTests extends BaseTest {

	private SearchService searchService;

	private static final int OLD_DATE_STATUS_CODE = 400;
	private static final String OLD_DATE_ERROR = "you cannot make a search in the past";

	@BeforeClass(groups = { "flight-search" })
	public void setUp() {
		searchService = new SearchService();
	}

	@Test(description = "Verify the error message to search flights with old dates", groups = { "flight-search" }, dataProvider = "searchOldDates", dataProviderClass = DataProviders.class)
	public void verify404ErrorWithOldDates(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertEquals(responseData.getStatusCode(), OLD_DATE_STATUS_CODE);
		String actualErrorMessage = responseData.getErrorMessage();
		if (!actualErrorMessage.contains(OLD_DATE_ERROR))
			Assert.fail("The error message is: " + actualErrorMessage);
	}

	@Test(description = "Verify airline names not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyAirlineNamesNotNull(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();
		for (LowestPricesByAirline lpba : results.getLowestPricesByAirline()) {
			Assert.assertNotNull(lpba.getAirline().getName(), "The airlines "
					+ lpba.getAirline().getCode()
					+ " returns null in its name field");
		}
	}

	@Test(description = "Verify domestic field = false with international flights", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyDomesticFieldFalseForInternationalItinerary(Map<String, String> data) {
		ResponseData responseData = searchService.retrieveFlights(data);
		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();
		for (Cluster cluster : results.getClusters()) {
			Assert.assertFalse(cluster.isDomestic(),
					"The domestic field is true");
		}
	}

	@Test(description = "Verifies that given a number of passengers, "
			+ "the total amount is equal to the detailed amount per passenger", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyPricesAcordingToNumberOfPax(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);
		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();
		for (Cluster cluster : results.getClusters()) {
			float adultPrice = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getAdultPrice())
					* Float.parseFloat(data.get("adults"));
			float childPrice = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getChildPrice());
			if (childPrice != 0) childPrice = childPrice
					* Float.parseFloat(data.get("children"));
			float infantPrice = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getInfantPrice());
			if (infantPrice != 0) infantPrice = infantPrice
					* Float.parseFloat(data.get("infants"));
			float taxPrice = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getTaxes());
			float charges = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getCharges());
			float extraTax = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getExtraTax());
			float fees = Utils.getNonNullValueOf(
					cluster.getPrice().getDetail().getFee());
			float total = Math.round(cluster.getPrice().getTotal());
			float sum = Math.round(adultPrice + childPrice + infantPrice
					+ taxPrice + extraTax + charges + fees);
			if (total != sum) {
				Assert.fail("The carrier " + cluster.getValidatingCarrier()
						+ " should have an amount of " + total
						+ ", but it has " + sum);
			}

		}
	}

	@Test(description = "Verify airport names not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyAirportsInClustersNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			Assert.assertNotNull(cluster.getValidatingCarrier(),
					"The are no airlines for this cluster " + cluster);
		}
	}

	@Test(description = "Verify not charging extra tax", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyExtraTax(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			if (cluster.isDomestic()) {
				Assert.assertEquals(cluster.getPrice().getDetail().getExtraTax(),
						0, "The Carrier " + cluster.getValidatingCarrier()
								+ " has extra tax: "
								+ cluster.getPrice().getDetail().getExtraTax());
			}
		}
	}

	@Test(description = "Verify cabin types not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyCabinTypesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			for (Segments segment : cluster.getSegments()) {
				for (Choices choice : segment.getChoices()) {
					for (Legs leg : choice.getLegs()) {
						Assert.assertNotNull(leg.getCabinType(), "The flight (choice) "
								+ choice.getId()
								+ " does not have the a cabin leg: " + leg.getNumber());
					}
				}
			}

		}
	}

	@Test(description = "Verify destination airport names not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyDestinationAirportNamesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			for (Segments segment : cluster.getSegments()) {
				for (Choices choice : segment.getChoices()) {
					Assert.assertNotNull(
							choice.getDestination().getName(),
							"The destination airport is null for the flight (choice) "
									+ choice.getId());

				}
			}
		}

	}

	@Test(description = "Verify origin airport names not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyOriginAirportNamesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();
		for (Cluster cluster : clusters) {
			for (Segments segment : cluster.getSegments()) {
				for (Choices choice : segment.getChoices()) {
					Assert.assertNotNull(choice.getOrigin().getName(),
							"The origin airport is null for the flight (choice) "
									+ choice.getId());

				}
			}
		}
	}

	@Test(description = "Verify currency codes not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyCurrencyCodesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			Assert.assertNotNull(cluster.getPrice().getCurrency().getCode(),
					"The currency code is null for the carrier " + cluster.getValidatingCarrier());
		}

	}

	@Test(description = "Verify currency masks not null", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyCurrencyMasksNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			Assert.assertNotNull(cluster.getPrice().getCurrency().getMask(),
					"The currency mask is null for the carrier " + cluster.getValidatingCarrier());
		}

	}
	
	@Test(description = "Verify marketing carrier names not nul", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyMarketingCarrierNamesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			for (Segments segment : cluster.getSegments()) {
				for (Choices choice : segment.getChoices()) {
					for (Legs leg : choice.getLegs()) {
						Assert.assertNotNull(leg.getMarketingCarrier().getName(), "The fligth "
								+ results.getId()
								+ " does not have marketing carrier in this leg "+leg.getNumber());
					}
				}
			}

		}

	}

	@Test(description = "Verify operating carrier name not nul", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyOperatingCarrierNamesNotNull(Map<String, String> data) {
		ResponseData responseData = this.searchService.retrieveFlights(data);

		Assert.assertNotNull(
				responseData.getResponse(),
				"Error: " + responseData.getStatusCode() + ": "
						+ responseData.getErrorMessage());
		FlightResults results = (FlightResults) responseData.getResponse()
				.getBody();

		List<Cluster> clusters = results.getClusters();

		for (Cluster cluster : clusters) {
			for (Segments segment : cluster.getSegments()) {
				for (Choices choice : segment.getChoices()) {
					for (Legs leg : choice.getLegs()) {
						Assert.assertNotNull(leg.getOperatingCarrier().getName(), "The fligth (choice) "
								+ choice.getId()
								+ " does not have operating carrier in the leg: "+leg.getNumber());
					}
				}
			}

		}

	}
}