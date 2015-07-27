package com.almundo.automation.utils;

import java.io.*;

/**
 * This class represents a filename filter to select only the files named like
 * is set the okFileExtensions attribute.
 * 
 * This class implements the Java FilenameFilter interface.
 * 
 */
public class XmlFileNameFilter implements FilenameFilter {

	private final String okFileExtensions = "xml";

	public boolean accept(File dir, String name) {
		return name.endsWith(okFileExtensions);
	}
}
