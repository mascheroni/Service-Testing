package com.almundo.automation.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a set of data rows. This means that this class represents the main container
 * of data rows which can be parsed from the xml files. 
 *  
 * An instance of this class may contains a list of DataRow.  
 */
public class DataSet {

	/** the DataSet name. */
	private String name;

	/**
	 * the DataRow ArrayList.
	 */
	private ArrayList<DataRow> dataRows;

	public DataSet() {
	}

	/**
	 * Returns the name of DataSets.
	 * 
	 * @return the set name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of DataSet.
	 * 
	 * @param theName the set name
	 */
	public void setName(final String theName) {
		name = theName;
	}

	/**
	 * Returns the DataRows list.
	 * 
	 * @return the DataRows list
	 * 
	 */
	public List<DataRow> getDataRows() {
		return dataRows;
	}

	/**
	 * Set the DataRow list.
	 * 
	 * @param theDataObjects the set data objects
	 */
	public void setDataRows(final ArrayList<DataRow> theDataRows) {
		dataRows = theDataRows;
	}

	/**
	 * Returns the DataRows as an array.
	 * 
	 * @return the DataRows as an array.
	 */
	public Object[] getDataRowsAsArray() {
		return dataRows.toArray();
	}
}
