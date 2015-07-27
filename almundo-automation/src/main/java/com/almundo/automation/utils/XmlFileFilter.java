package com.almundo.automation.utils;

import java.io.*;

/**
 * This class represents a file filter to select only the files set in
 * okFileExtensions.
 * 
 * This class implements the Java FileFilter interface.
 */
public class XmlFileFilter implements FileFilter {
	private final String[] okFileExtensions = new String[] { "xml" };

	public boolean accept(File file) {
		for (String extension : okFileExtensions) {
			if (file.getName().toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}
