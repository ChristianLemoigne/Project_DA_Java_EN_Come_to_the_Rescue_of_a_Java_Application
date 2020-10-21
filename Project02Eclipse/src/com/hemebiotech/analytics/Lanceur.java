package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomwriter.ISymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomAggregatedIntoFile;

import java.io.IOException;

public class Lanceur {

    private static final  String FILE_SYMPTOMS_INPUT ="C:\\NWLS\\projets\\opcroom\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
    //private static final  String FILE_SYMPTOMS_INPUT = null;  // to test  the null file in input

    private static final  String FILE_OUTPUT = "result.out";
    //private static final  String FILE_OUTPUT = null;     //  to test  the null file in input

    public static void main(String[] args) {

        try {
            ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(FILE_SYMPTOMS_INPUT);
            ISymptomWriter writeSymptomAggregatedIntoFile = new WriteSymptomAggregatedIntoFile(FILE_OUTPUT);

            AnalyticsCounter analyticsCounter =new AnalyticsCounter(readSymptomDataFromFile,writeSymptomAggregatedIntoFile);
            analyticsCounter.analyse();

        } catch (IOException e) {
            System.out.println(" ---------------------------------------");
            System.out.println("This is the treatement for the IOException: ");
            System.out.println ("       "  + e.toString());
            System.out.println ("       "  + e.getMessage());
            System.out.println(" ---------------------------------------");
            e.printStackTrace();
        } catch (Exception f) {
            System.out.println(" ---------------------------------------");
            System.out.println("This is the treatement for the Exception: " );
            System.out.println ("       "  + f.toString());
            System.out.println ("       "  + f.getMessage());
            System.out.println(" ---------------------------------------");
            f.printStackTrace();
        }
    }

}