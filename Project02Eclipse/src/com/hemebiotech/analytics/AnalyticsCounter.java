package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomwriter.ISymptomWriter;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Read the symtoms,
 * Aggregaate the symptoms
 * Write the symptonsaggegated
 */
public class AnalyticsCounter {

	private ISymptomReader readSymptomDataFromFile ;
	private ISymptomWriter writeSymptomAggregatedIntoFile ;

	/**
	 * En une phrase, dire ce que tu fais le constructeur
	 * @param readSymptomDataFromFile interface du truc
	 * @param writeSymptomAggregatedIntoFile  totootototot
	 */
	public   AnalyticsCounter(ISymptomReader readSymptomDataFromFile, ISymptomWriter writeSymptomAggregatedIntoFile) {
		this.readSymptomDataFromFile = readSymptomDataFromFile ;
		this.writeSymptomAggregatedIntoFile =writeSymptomAggregatedIntoFile ;
	}

	/**
	 *
	 * @return raconter ce que c'est censé  retourner  ( liste des symptoms avec doublons éventuels)
	 * @throws IOException
	 */
	public  List<String>  readSymptoms() throws IOException {
		return readSymptomDataFromFile.getSymptoms() ;
	}

	public  Map<String, Integer>  aggregateSymptoms(List<String> listSymptoms)   {
		return aggregateDatas(listSymptoms) ;
	}

	public  List<String>  sortListSymptoms(Map<String, Integer>  mapSymptomsAggegated)   {
		return sortMapToList(mapSymptomsAggegated) ;
	}

	public  void  writeSymptoms(List<String> listSymptomsSorted, Map<String, Integer> mapSymptomsCount  )  throws IOException {
		writeSymptomAggregatedIntoFile.writeAggregateSymptoms(listSymptomsSorted, mapSymptomsCount);
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