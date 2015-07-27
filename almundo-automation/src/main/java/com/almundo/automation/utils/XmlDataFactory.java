package com.almundo.automation.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.XStreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlDataFactory {

	/**
	 * variable singleton.
	 */
	private static XmlDataFactory dataProviderManager = new XmlDataFactory();

	/**
	 * testGroup associated.
	 */
	private static TestCaseGroup testCaseGroup;

	/**
	 * Default constructor.
	 */
	private XmlDataFactory() {
	}

	public static TestCaseGroup getTestCaseGroup() {
		return testCaseGroup;
	}

	/**
	 * Returns DataProviderManager instance.
	 * 
	 * @return DataProviderManager instance
	 */
	public static XmlDataFactory getInstance() throws IOException {
		return dataProviderManager;
	}

	/**
	 * Initializes the DataProviderManager and their testCaseGroup.
	 * 
	 * @throws IOException
	 *             if the property file is not found
	 */
	public void initialize(String projectPathToFiles) throws IOException {
		this.loadTestData(projectPathToFiles);
	}

	/**
	 * This method return only one couple of data if exists the dataRowName.
	 * 
	 * @param dataRowName
	 *            The datarow name to retrieve the values.
	 * @return A two dimensions array of values of each DataObject contained on
	 *         the data row given by parameter.
	 */
	public Object[][] getArrayFromDataRow(String dataRowName) {
		Object[][] dataRowArray = null;

		if (testCaseGroup.getDataSets() != null) {
			for (DataSet oneDataSet : testCaseGroup.getDataSets()) {

				for (DataRow oneDataRow : oneDataSet.getDataRows()) {
					if (oneDataRow.getName().equals(dataRowName)) {
						Object[] dataR = oneDataRow
								.getDataObjectsValuesAsArray();
						if (dataR.length > 0) {
							int i;
							dataRowArray = new Object[1][dataR.length];
							for (i = 0; i < dataR.length; i++)
								dataRowArray[0][i] = dataR[i];
						}
						break;
					}
				}
				if (dataRowArray != null) {
					break;
				}
			}
		}
		return dataRowArray;
	}

	/**
	 * This method return the values of the entire data set name given by
	 * parameter.
	 * 
	 * @param dataSetName
	 *            The dataset name to retrieve his values.
	 * @return A two dimensions array of values of each DataObject contained on
	 *         the data set given by parameter.
	 */
	public Object[][] getArrayFromDataSet(String dateSetName) {
		Object[][] dataRowArray = null;

		DataSet dataSet = null;
		Map<String, String> dataObjectsHashMap;

		for (DataSet dataSetAux : testCaseGroup.getDataSets()) {
			if (dataSetAux.getName().equals(dateSetName)) {
				dataSet = dataSetAux;
				break;
			}
		}

		int j = 0;

		if (dataSet != null) {
			if (!dataSet.getDataRows().isEmpty()) {

				dataRowArray = new Object[dataSet.getDataRows().size()][1];

				ArrayList<DataObject> dataObjects;

				for (DataRow oneDataRow : dataSet.getDataRows()) {
					dataObjects = oneDataRow.getDataObjects();
					dataObjectsHashMap = new HashMap<String, String>();

					for (DataObject dataObject : dataObjects) {
						dataObjectsHashMap.put(dataObject.getName(),
								dataObject.getValue());
					}
					Utils utils = new Utils();
					String date = utils.convertToSpecifDate(dataObjectsHashMap.get("date"));
					dataObjectsHashMap.remove("date");
					dataObjectsHashMap.put("departure", date);
					dataRowArray[j][0] = dataObjectsHashMap;
					j++;
				}
			}
		}
		return dataRowArray;
	}

	/**
	 * This method returns a random and only one row from a dataSet which has
	 * multiple rows.
	 * 
	 * @param dataSetName
	 *            The dataSet name to retrieve the row from.
	 * @return An n-dimensions array of values from a random row on the dataSet.
	 *         n will be equal to the amount of parameters set in the chosen row
	 */
	public Object[][] getRandomRowFromDataSet(String dataSetName) {
		Object[][] dataSetArray = getArrayFromDataSet(dataSetName);
		int randomNumber = new Random().nextInt(dataSetArray.length);
		Object[][] newDataSetArray = new Object[1][dataSetArray[randomNumber].length];
		newDataSetArray[0] = dataSetArray[randomNumber];
		return newDataSetArray;
	}

	/**
	 * Initializes the testCaseGroup.
	 * 
	 * @param filesPath
	 *            The relative path which inside contains the xml files to load
	 *            the data.
	 * @throws IOException
	 *             if the path given by parameter is not found
	 */
	public void loadTestData(String filesPath) throws IOException {
		filesPath = filesPath.trim();
		try {
			if (filesPath != null && filesPath.length() != 0) {
				XStream xstreamTC = new XStream(new DomDriver());
				xstreamTC.alias("testCaseGroup", TestCaseGroup.class);
				xstreamTC.alias("dataSets", java.util.ArrayList.class);
				xstreamTC.alias("dataSet", DataSet.class);
				xstreamTC.alias("dataRows", java.util.ArrayList.class);
				xstreamTC.alias("dataRow", DataRow.class);
				xstreamTC.alias("dataObjects", java.util.ArrayList.class);
				xstreamTC.alias("dataObject", DataObject.class);
				String[] fileNames = getFileNames(filesPath);
				StringBuffer data = fillDataBuffer(fileNames, filesPath);
				String dataString = data.toString();
				testCaseGroup = (TestCaseGroup) xstreamTC.fromXML(dataString);
			}

		} catch (XStreamException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the Test data from the XML files and adds the information to a
	 * buffer.
	 * 
	 * @param fileNames
	 *            the files to read from
	 * @param filePath
	 *            the path where the files resides
	 * @return a String Buffer with all the test data
	 * @throws IOException
	 *             if the data file is not found
	 */
	private StringBuffer fillDataBuffer(final String[] fileNames,
			final String filePath) throws IOException {
		// System.out.println(fileNames.length);
		StringBuffer data = new StringBuffer();
		data.append("<testCaseGroup>");
		data.append("<dataSets>");
		for (String fileName : fileNames) {
			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(
						filePath + fileName));
				if (reader != null) {
					String linea = reader.readLine();
					while (linea != null) {
						data.append(linea);
						linea = reader.readLine();
					}

				}

			} catch (Exception e) {
				throw new IOException("The File '" + fileName
						+ "' can´t be opened. " + e.getMessage());

			}
		}
		data.append("</dataSets>");
		data.append("</testCaseGroup>");
		return data;
	}

	/**
	 * Reads the files names in the given path.
	 * 
	 * @param filePath
	 *            where the files resides.
	 * @return an array of file names.
	 * @throws IOException
	 *             if the data file is not found.
	 */
	private String[] getFileNames(final String filePath) throws IOException {

		File dir = new File(filePath);
		Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(filePath);

		return dir.list(new XmlFileNameFilter());
	}
}
