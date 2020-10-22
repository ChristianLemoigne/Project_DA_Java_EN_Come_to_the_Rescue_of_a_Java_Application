package com.hemebiotech;

import com.hemebiotech.analytics.AnalyticsCounter;
import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomwriter.ISymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomAggregatedIntoFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Launcher {

    private static final  String FILE_SYMPTOMS_INPUT ="C:\\NWLS\\projets\\opcroom\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
    private static final  String FILE_OUTPUT = "results.out";

    public static void main(String[] args) {

        try {
            ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(FILE_SYMPTOMS_INPUT);
            ISymptomWriter writeSymptomAggregatedIntoFile = new WriteSymptomAggregatedIntoFile(FILE_OUTPUT);

            AnalyticsCounter analyticsCounter =new AnalyticsCounter(readSymptomDataFromFile,writeSymptomAggregatedIntoFile);

            List<String> listSymptoms = analyticsCounter.readSymptoms() ;
            Map<String, Integer> mapSymptomsCount = analyticsCounter.aggregateSymptoms(listSymptoms);
            List<String> listSymptomsSorted = analyticsCounter.sortListSymptoms(mapSymptomsCount);
            analyticsCounter.writeSymptoms ( listSymptomsSorted,mapSymptomsCount );


        } catch (IOException e) {
            System.out.println("\n ---------------------------------------");
            System.out.println("Treatement in the \"Launcher\" for the IOException: ");
            System.out.println ("       "  + e.toString());
            System.out.println ("       "  + e.getMessage());
            System.out.println(" ---------------------------------------");
            e.printStackTrace();
        } catch (IllegalArgumentException f) {
            System.out.println("\n ---------------------------------------");
            System.out.println("Treatement in the \"Launcher\" for the IllegalArgumentException: " );
            System.out.println ("       "  + f.toString());
            System.out.println ("       "  + f.getMessage());
            System.out.println(" ---------------------------------------");
            f.printStackTrace();
        }
    }

}