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
	public void verifyAirportNameNotNull(Map<String, String> data) {
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
			float adultPrice = Math.round(cluster.getPrice().getDetail()
					.getAdultPrice());
			float childPrice = Math.round(cluster.getPrice().getDetail()
					.getChildPrice());
			float infantPrice = Math.round(cluster.getPrice().getDetail()
					.getInfantPrice());
			float taxPrice = Math.round(cluster.getPrice().getDetail()
					.getTaxes());
			float extraTax = Math.round(cluster.getPrice().getDetail()
					.getExtraTax());
			float total = Math.round(cluster.getPrice().getTotal());
			float sum = (adultPrice * Float.parseFloat(data.get("adults")))
					+ (childPrice * Float.parseFloat(data.get("children")))
					+ (infantPrice * Float.parseFloat(data.get("infants")))
					+ taxPrice + extraTax;
			if (total != sum) {
				Assert.fail("The carrier " + cluster.getValidatingCarrier()
						+ " should have an amount of " + total
						+ ", but it has " + sum);
			}

		}
	}

	@Test(description = "Verify the most important airports", groups = { "flight-search" }, dataProvider = "searchGenericData", dataProviderClass = DataProviders.class)
	public void verifyAirportsInClusters(Map<String, String> data) {
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

	@Test(description = "Verify not charging extra tax", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
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
				Assert.assertSame(cluster.getPrice().getDetail().getExtraTax(),
						0, "The flight " + results.getId()
								+ " should not charg extra tax "
								+ cluster.getPrice().getDetail().getExtraTax());
			}
		}
	}

	@Test(description = "Verify right type of cabin", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyTypeCabin(Map<String, String> data) {
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
						Assert.assertNotNull(leg.getCabinType(), "The fligth "
								+ results.getId()
								+ " does not have the a cabin");
					}
				}
			}

		}
	}

	@Test(description = "Verify destination airport name not null", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyDestinationAirportName(Map<String, String> data) {
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
							"The destination airport is null for "
									+ results.getId());

				}
			}
		}

	}

	@Test(description = "Verify origin airport name not null", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyOriginAirportName(Map<String, String> data) {
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
							"The origin airport is null for " + results.getId());

				}
			}
		}
	}

	@Test(description = "Verify currency code", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyCurrencyCode(Map<String, String> data) {
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
					"The currency code is null for " + results.getId());
		}

	}

	@Test(description = "Verify currency mask", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyCurrencyMask(Map<String, String> data) {
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
					"The currency mask is null for " + results.getId());
		}

	}
	
	@Test(description = "Verify marketing carrier name not nul", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyMarketingCarrierNAme(Map<String, String> data) {
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

	@Test(description = "Verify operating carrier name not nul", groups = { "flight-search" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
	public void verifyOperatingCarrierNAme(Map<String, String> data) {
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
						Assert.assertNotNull(leg.getOperatingCarrier().getName(), "The fligth "
								+ results.getId()
								+ " does not have operating carrier in this leg "+leg.getNumber());
					}
				}
			}

		}

	}
}