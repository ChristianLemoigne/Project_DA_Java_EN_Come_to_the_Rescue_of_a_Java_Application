package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * TODO
 *
 */

public class WriteSymptomAggregatedIntoFile implements ISymptomWriter {

    private String filepath;

    /**
     * TODO
     *
     */

    public WriteSymptomAggregatedIntoFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeAggregateSymptoms(List<String> listSymptoms, Map<String, Integer> mapSymptomsCount)  throws IOException {

        if (filepath != null) {

            FileWriter writer = new FileWriter(filepath);
            try {
                for (String symptom : listSymptoms) {
                    writer.write( symptom + "=" + mapSymptomsCount.get(symptom) + "\n");
                }
            } finally {
                writer.close();
            }
        } else {
            throw (new IllegalArgumentException("null filepath!")) ;
        }
    }

}

