package com.almundo.automation.utils;

/**
 * This class represents the object that the data provider injects to the test
 * cases.
 * An DataObject represents a single Object with its corresponding name and value.
 */
public class DataObject {

	/**
	 * the DataObject name.
	 */
	private String name;

	/**
	 * the DataObject value.
	 */
	private String value;

	/**
	 * Default Constructor.
	 */
	public DataObject() {
	};

	/**
	 * Constructor with name.
	 * 
	 * @param theName The object name
	 */
	public DataObject(String theName) {
		name = theName;
	}

	/**
	 * Constructor with name and value.
	 * @param theName The object name.
	 * @param theValue The value for this object.
	 */
	public DataObject(String theName, String theValue) {
		name = theName;
		value = theValue;
	}

	/**
	 * Returns the name of DataObject.
	 * @return the name of DataObject.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of DataObject.
	 * @param theName the object name
	 */
	public void setName(final String theName) {
		name = theName;
	}

	/**
	 * Returns the value of DataObject.
	 * @return the value of DataObject
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of DataObject.
	 * @param theValue the object value
	 */
	public void setValue(String theValue) {
		value = theValue;
	}

	@Override
	public String toString() {
		return getName() + ": " + getValue();
	}
}
