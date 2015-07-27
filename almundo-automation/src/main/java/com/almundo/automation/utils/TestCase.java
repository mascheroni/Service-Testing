package com.almundo.automation.utils;

import java.util.List;

/**
 * This class represents a test case with their data sets.
 */
public class TestCase {

	/** name of TestCase. */
	private String name;

	/** the DataSet list. */
	private List<DataSet> dataSets;

	/**
	 * TestCase Constructor.
	 * 
	 * @param theName name of TestCase
	 */
	public TestCase(final String theName) {
		name = theName;
	}

	/**
	 * Returns the list of DataSet.
	 * 
	 * @return list of DataSet
	 */
	public List<DataSet> getDataSets() {
		return dataSets;
	}

	/**
	 * Set the list of DataSet.
	 * 
	 * @param theDataSets The data sets
	 */
	public void setDataSets(final List<DataSet> theDataSets) {
		this.dataSets = theDataSets;
	}

	/**
	 * Return the name of TestCase.
	 * 
	 * @return the name of TestCase
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of TestCase.
	 * 
	 * @param theName the set name
	 */
	public void setName(final String theName) {
		name = theName;
	}
}
