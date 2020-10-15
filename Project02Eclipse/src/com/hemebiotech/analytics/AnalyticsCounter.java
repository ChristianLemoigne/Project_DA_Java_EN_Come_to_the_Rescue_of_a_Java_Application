package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomwriter.ISymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomAggregatedIntoFile;

import java.util.*;
import java.util.Map.Entry;


public class AnalyticsCounter {

	public static void analyse() throws Exception {

		List<String> listSymptoms = readSymptoms();
		Map<String, Integer> mapSymptoms = aggregateDatas(listSymptoms) ;
		writeAggregatedSymptoms(mapSymptoms);
	}

	private static List<String> readSymptoms()    {
		// TODO : ça me gène de renseigner ici le chemin du fichier
		final  String FILE_SYMPTOMS_INPUT ="C:\\NWLS\\projets\\opcroom\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(FILE_SYMPTOMS_INPUT);
		return readSymptomDataFromFile.getSymptoms() ;
	}

	private static void writeAggregatedSymptoms(Map<String, Integer>  mapSymptoms)    {
		final  String FILE_OUTPUT = "result.out";
		ISymptomWriter writeSymptomAggregatedIntoFile = new WriteSymptomAggregatedIntoFile(FILE_OUTPUT);
		writeSymptomAggregatedIntoFile.writeAggregateSymptoms(mapSymptoms);
	}

	private static Map<String, Integer> aggregateDatas(List<String> listSymptoms) {

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
		System.out.println(  "  -> enjoy ! ");

		Map sortedMapSymptoms = new TreeMap(mapSymptoms);
		return sortedMapSymptoms ;
	}

}