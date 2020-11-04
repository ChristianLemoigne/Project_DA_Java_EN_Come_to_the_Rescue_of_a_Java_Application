package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Simple implementation  of interface ISymptomWriter
 * it write the symptoms in a file, which name is in the param   filepath
 */


public class WriteSymptomAggregatedIntoFile implements ISymptomWriter {

    private String filepath;

    /**
     * it stores the filepath
     * @param filepath a full path to file in wich we are going to write
     */

    public WriteSymptomAggregatedIntoFile(String filepath) {
        this.filepath = filepath;
    }


    /**
     * it write the symptoms in the file   ( filepath property)
     * @param listSymptoms  List of symptoms, not necesary sorted
     * @param mapSymptomsCount  map  of symptoms aggregated and their count, on line per symptom
     * @throws IOException  if problem in writing the list of symptoms
     */
    @Override
    public void writeAggregateSymptoms(List<String> listSymptoms, Map<String, Integer> mapSymptomsCount)  throws IOException {

        if (filepath != null) {
            try (FileWriter writer = new FileWriter(filepath);){
                for (String symptom : listSymptoms) {
                    writer.write( symptom + "=" + mapSymptomsCount.get(symptom) + "\n");
                }
            }
        } else {
            throw (new IllegalArgumentException("null filepath!")) ;
        }
    }

}

