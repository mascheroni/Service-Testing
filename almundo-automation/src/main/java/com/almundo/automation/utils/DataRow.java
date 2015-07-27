package com.almundo.automation.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents a row of test data.
 * An instance of this class may contains a list of DataObject.  
 */
public class DataRow {

	/** the DataSet name. */
	private String name;

	/**
	 * the DataObject properties.
	 */
	private ArrayList<DataObject> dataObjects;

	public DataRow() {
	}

	/**
	 * Returns the name of DataSet.
	 * 
	 * @return the set name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of DataSet.
	 * @param theName the set name
	 */
	public void setName(final String theName) {
		name = theName;
	}

	/**
	 * Returns the DataObject Properties.
	 * @return the DataObject Properties
	 */
	public ArrayList<DataObject> getDataObjects() {
		return dataObjects;
	}

	/**
	 * Set the DataObject properties.
	 * 
	 * @param theDataObjects the set data objects properties
	 */
	public void setDataObjects(final ArrayList<DataObject> theDataObjects) {
		dataObjects = theDataObjects;
	}

	/**
	 * This method extract the value of each DataObject contained on it, and return
	 * an array of this values. 
	 * @return an array of the values of each contained DataObject.
	 */
	public Object[] getDataObjectsValuesAsArray() {
		Object[] dataValues = new Object[dataObjects.toArray().length];

		int i = 0;
		for (DataObject obj : dataObjects) {
			dataValues[i] = (String) obj.getValue();
			i++;
		}

		return dataValues;

	}

	/**
	 * This method up cast an ArrayList to Collection.
	 * @return a {link Collection} of DataOjects
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection<Object> getDataObjectsValuesAsCollection() {
		return (Collection) dataObjects;
	}
}
