package com.almundo.automation.tests;


/**
 * Verify all entities that was defined on the framework
 * 
 * @author zenen.morales
 *
 */
public class EntitiesTests extends BaseTest {

//	@Test(description = "Verifies the entity Segment", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifySegmentEntity(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		List<Segment> segments = response.getSegments();
//		Assert.assertNotNull("The entity Segment it큦 null",
//				!segments.isEmpty());
//	}
//
//	@Test(description = "Verifies the entity OperatingCarrier", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifyOperatingCarrierEntity(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		List<OperatingCarrier> operatingCarriers = response
//				.getOperatingCarrier();
//		Assert.assertNotNull("The entity Operating Carrier it큦 null",
//				!operatingCarriers.isEmpty());
//	}
//
//	@Test(description = "Verifies the entity Choice", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifyChoiceEntity(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		List<Choice> choices = response.getChoice();
//		Assert.assertNotNull("The Choice it큦 null", !choices.isEmpty());
//	}
//
//	@Test(description = "Verifies the entity Leg", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifyLegEntity(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		List<Leg> legs = response.getLegs();
//		Assert.assertNotNull("The Choice it큦 null", !legs.isEmpty());
//	}
//
//	@Test(description = "Verifies the entity MarketingCarrier", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifyMarketingCarrierEntity(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		MarketingCarrier marketing = response.getMarketingCarriers();
//		Assert.assertNotNull("The Choice it큦 null", marketing);
//	}
//
//	@Test(description = "Verifies that the list of filters it큦 not null", groups = { "entities-tests" }, dataProvider = "test1", dataProviderClass = DataProviders.class)
//	public void verifyFilters(Map<String, String> data) {
//		String reqDate = this.utils.convertToSpecifDate(data.get("date"));
//		data.remove("date");
//		data.put("departure", reqDate);
//		this.httpClient.setSearchRequest(data);
//		Response response = this.httpClient.post();
//		List<Filter> filters = response.getFilters();
//		Assert.assertNotNull("The list of filter it큦 null", !filters.isEmpty());
//	}

}
