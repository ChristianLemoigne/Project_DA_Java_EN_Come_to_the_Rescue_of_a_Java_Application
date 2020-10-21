package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomwriter.ISymptomWriter;

import java.util.*;
import java.util.Map.Entry;


public class AnalyticsCounter {

	private ISymptomReader readSymptomDataFromFile ;
	private ISymptomWriter writeSymptomAggregatedIntoFile ;

	public   AnalyticsCounter(ISymptomReader readSymptomDataFromFile, ISymptomWriter writeSymptomAggregatedIntoFile) {
		this.readSymptomDataFromFile = readSymptomDataFromFile ;
		this.writeSymptomAggregatedIntoFile =writeSymptomAggregatedIntoFile ;
	}

	public  void analyse() throws Exception {

		System.out.println("\n*AnalyticsCounter.analyse: start");

		List<String> listSymptoms = readSymptomDataFromFile.getSymptoms() ;
		Map<String, Integer> mapSymptomsCount = aggregateDatas(listSymptoms) ;
		List<String> listSymptomsSorted = SortMapToList(mapSymptomsCount) ;
		writeSymptomAggregatedIntoFile.writeAggregateSymptoms(listSymptomsSorted, mapSymptomsCount);

		System.out.println("\n*AnalyticsCounter.analyse: end");
	}

	private  Map<String, Integer> aggregateDatas(List<String> listSymptoms) {

		System.out.println(  "\n** Liste des symptomes lus:");
		System.out.println(  "");
		Map<String, Integer> mapSymptoms = new HashMap<>();
		/* use stream() instead of "for loop"
		for (String str : listSymptoms) {
			System.out.println(str);
			if (mapSymptoms.containsKey(str)) {
				mapSymptoms.put(str, mapSymptoms.get(str) + 1);
			} else {
				mapSymptoms.put(str, 1);
			}
		}
		*/
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

		// Don't use treeMap  ( too easy)
		//return new TreeMap(mapSymptoms);
		return mapSymptoms ;
	}

	private List<String> SortMapToList (Map<String, Integer> map)  {

		List<String> ListKeySet = new ArrayList<>(map.keySet());
		Collections.sort(ListKeySet);

		System.out.println("\n ** List of Sorted symptoms:");
		ListKeySet.stream().forEach(x->System.out.println(x));

		return ListKeySet;
	}

}