package com.hemebiotech.symptomreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Simple implementation  of interface ISymptomReader
 * it reads the symptoms from a file, which name is in the param   filepath
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * it stores the filepath ( filepath property)
	 * @param filepath a full path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}


	/**
	 * it reads the symptoms from the file ( data filepath) and return them
	 * If no data is available, return an empty List
	 * @return  a raw listing of all Symptoms obtained from the file, duplicates are possible/probable
	 * @throws IOException  if problem in reading the list of symptoms
	 */
	@Override
	public List<String> getSymptoms() throws IOException {

		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath));) {
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			}
		}  else {
			throw (new IllegalArgumentException("null filepath !")) ;
		}
		return result;
	}

}
