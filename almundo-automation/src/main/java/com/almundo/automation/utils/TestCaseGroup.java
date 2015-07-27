package com.almundo.automation.utils;

import java.util.ArrayList;

/**
 * This class represents a test case group with their data sets.
 */
public class TestCaseGroup {

	/** the DataSet ArrayList */
	private ArrayList<DataSet> dataSets;

	/**
	 * Default Constructor.
	 */
	public TestCaseGroup() {
	}

	/**
	 * Constructor with a ArrayList to set the dataSets list.
	 * @param theDataSet
	 */
	public TestCaseGroup(ArrayList<DataSet> theDataSet) {
		dataSets = theDataSet;
	}

	/**
	 * This method return this list of DataSet contained on it self.
	 * @return a list of dataSets
	 */
	public ArrayList<DataSet> getDataSets() {
		return dataSets;
	}

	/**
	 * 
	 * @param theDataSets the list of DataSet to be set.
	 */
	public void setDataSets(ArrayList<DataSet> theDataSets) {
		dataSets = theDataSets;
	}
}
