package com.hemebiotech.symptomreader;

import java.io.IOException;
import java.util.List;

/**
 * read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {

	/**
	 * it reads the symptoms and return them
	 * If no data is available, return an empty List
	 * @return  a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 * @throws IOException  if problem in reading the list of symptoms
	 */

	List<String> getSymptoms () throws IOException;
}
