/**
 * 
 */
package com.assurity.test.qa.util;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads the Json file from data and returns the json object.
 * 
 * @author Jaliya Sumanadasa
 *
 */
public class JsonReader {

    private static final Logger logger = LoggerFactory
	    .getLogger(JsonReader.class);

    /**
     * Read Json from file and return as String.
     * 
     * @param fileName
     *            : The name of the File.
     * 
     * @return String
     */
    public static String getJsonString(String fileName) {

	try {

	    return IOUtils.toString(
		    JsonReader.class.getResourceAsStream(fileName), "UTF-8");

	} catch (Exception e) {
	    logger.error("Error Reading Json File: " + fileName, e);
	    return null;
	}

    }

}
