package com.almundo.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	private static final String PATH = "../src/main/resources/com/almundo/automation/";
	private FileInputStream inputStream;
	
	public String getPropertiesValues(String key, String propertyFile) {
		try {
			Properties properties = new Properties();
			String propLocation = PATH + propertyFile;
			inputStream = new FileInputStream(propLocation);
			
			if(inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException(propLocation + " was not found in the classpath");
			}
			
			return properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
