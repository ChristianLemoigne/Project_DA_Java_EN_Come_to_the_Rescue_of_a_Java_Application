package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomwriter.ISymptomWriter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This Class is sused to Read a list of medical symptoms,
 * and to write a list of these symptoms aggregated.
 * one line  for each symptom of the list
 * */

public class AnalyticsCounter {

	private ISymptomReader readSymptomData ;
	private ISymptomWriter writeSymptomAggregated ;

	/**
	 * this constructor inject the two dependencies below:
	 * @param readSymptomData interface for readind the list of symptoms
	 * @param writeSymptomAggregated  interface for writing the result on an output support
	 */
	public   AnalyticsCounter(ISymptomReader readSymptomData, ISymptomWriter writeSymptomAggregated) {
		this.readSymptomData = readSymptomData ;
		this.writeSymptomAggregated =writeSymptomAggregated ;
	}

	/**
	 * it reads the symptoms by calling a dependency injected
	 * @return  list of symptoms, with possibly several times the same symptom
	 * @throws IOException  if problem in reading the list of symptoms
	 */
	public  List<String>  readSymptoms() throws IOException {
		return readSymptomData.getSymptoms() ;
	}

	/**
	 * it aggregate the symptoms
	 * @return  Map of symptoms, one line in output for each symptom in the input
	 * @param listSymptoms  List of symptoms
	 */
	public  Map<String, Integer>  aggregateSymptoms(List<String> listSymptoms)   {
		return aggregateDatas(listSymptoms) ;
	}

	/**
	 * it sorts alphabetically the list of aggregated symptoms
	 * @return  List of symptoms
	 * @param mapSymptomsAggegated   map of  aggregated symptoms
	 */
	public  List<String>  sortListSymptoms(Map<String, Integer>  mapSymptomsAggegated)   {
		return sortMapToList(mapSymptomsAggegated) ;
	}

	/**
	 * it write the symptoms  by calling a dependency injected
	 * @param listSymptomsSorted  List of symptoms sorted
	 * @param mapSymptomsCount  map  of symptoms aggregated and their count, on line per symptom
	 * @throws IOException  if problem in writing the list of symptoms
	 */
	public  void  writeSymptoms(List<String> listSymptomsSorted, Map<String, Integer> mapSymptomsCount  )  throws IOException {
		writeSymptomAggregated.writeAggregateSymptoms(listSymptomsSorted, mapSymptomsCount);
	}


	private  Map<String, Integer> aggregateDatas(List<String> listSymptoms) {

		System.out.println(  "\n** Liste des symptomes lus:");

		Map<String, Integer> mapSymptoms = new HashMap<>();
		listSymptoms.stream().forEach(str -> {
			System.out.println(str);
			if (mapSymptoms.containsKey(str)) {
				mapSymptoms.put(str, mapSymptoms.get(str) + 1);
			} else {
				mapSymptoms.put(str, 1);
			}
		});
		System.out.println(  "\n ** Liste des symptomes aggregés:");
		mapSymptoms.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " =  " + x.getValue()));

		return mapSymptoms ;
	}

	private List<String> sortMapToList (Map<String, Integer> map)  {
		return map.keySet().stream().sorted().collect(Collectors.toList());
	}

}