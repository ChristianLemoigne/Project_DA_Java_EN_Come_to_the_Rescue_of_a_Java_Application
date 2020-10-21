package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomwriter.ISymptomWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class AnalyticsCounter {

	private ISymptomReader readSymptomDataFromFile ;
	private ISymptomWriter writeSymptomAggregatedIntoFile ;

	public   AnalyticsCounter(ISymptomReader readSymptomDataFromFile, ISymptomWriter writeSymptomAggregatedIntoFile) {
		this.readSymptomDataFromFile = readSymptomDataFromFile ;
		this.writeSymptomAggregatedIntoFile =writeSymptomAggregatedIntoFile ;
	}

	public  void analyse() throws Exception {

		List<String> listSymptoms = readSymptomDataFromFile.getSymptoms() ;
		Map<String, Integer> mapSymptoms = aggregateDatas(listSymptoms) ;
		writeSymptomAggregatedIntoFile.writeAggregateSymptoms(mapSymptoms);
	}

	private  Map<String, Integer> aggregateDatas(List<String> listSymptoms) {

		// TODO :  remove the "for loop"  and use stream() instead

		System.out.println(  "Liste des symptomes lus");
		System.out.println(  "");
		Map<String, Integer> mapSymptoms = new HashMap<>();
		for (String str : listSymptoms) {
			System.out.println(str);
			if (mapSymptoms.containsKey(str)) {
				mapSymptoms.put(str, mapSymptoms.get(str) + 1);
			} else {
				mapSymptoms.put(str, 1);
			}
		}
		// logging ( to be removed probably)
		System.out.println(  "");
		System.out.println(  " ------------------------ ");
		System.out.println("Résultat  : ");
		System.out.println(  " ------------------------ ");
		for (Entry mapEntry : mapSymptoms.entrySet()) {
			System.out.println(mapEntry.getKey() + " =  " + mapEntry.getValue());
		}
		System.out.println(" ");
		System.out.println(  " Fin de la liste des symptomes aggrégés par nombre d'apparition ");

		Map sortedMapSymptoms = new TreeMap(mapSymptoms);
		return sortedMapSymptoms ;
	}

}