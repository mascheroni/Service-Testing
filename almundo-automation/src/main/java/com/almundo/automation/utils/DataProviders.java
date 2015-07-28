package com.almundo.automation.utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	public DataProviders() {
	}

	@DataProvider(name = "searchGenericData")
	public static Object[][] getSearchData() throws IOException {
		XmlDataFactory factory = XmlDataFactory.getInstance();
		factory.initialize("../src/main/resources/com/almundo/automation/data/");
		return factory.getArrayFromDataSet("searchGenericData");
	}
	
	@DataProvider(name = "searchOldDates")
	public static Object[][] getSearchOldDates() throws IOException {
		XmlDataFactory factory = XmlDataFactory.getInstance();
		factory.initialize("../src/main/resources/com/almundo/automation/data/");
		return factory.getArrayFromDataSet("searchOldDates");
	}

}
