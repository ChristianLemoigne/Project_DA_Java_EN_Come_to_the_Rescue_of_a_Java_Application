package com.hemebiotech.analytics;

import com.hemebiotech.symptomreader.ISymptomReader;
import com.hemebiotech.symptomreader.ReadSymptomDataFromFile;
import com.hemebiotech.symptomwriter.ISymptomWriter;
import com.hemebiotech.symptomwriter.WriteSymptomAggregatedIntoFile;

import java.io.IOException;

public class Lanceur {
    private static final  String FILE_SYMPTOMS_INPUT ="C:\\NWLS\\projets\\opcroom\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
    private static final  String FILE_OUTPUT = "result.out";

    public static void main(String[] args) {

        try {
            ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(FILE_SYMPTOMS_INPUT);
            ISymptomWriter writeSymptomAggregatedIntoFile = new WriteSymptomAggregatedIntoFile(FILE_OUTPUT);

            AnalyticsCounter analyticsCounter =new AnalyticsCounter(readSymptomDataFromFile,writeSymptomAggregatedIntoFile);
            analyticsCounter.analyse();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        }
    }

}