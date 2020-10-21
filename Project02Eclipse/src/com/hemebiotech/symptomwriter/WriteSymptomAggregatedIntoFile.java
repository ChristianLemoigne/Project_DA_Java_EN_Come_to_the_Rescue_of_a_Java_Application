package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Map;
import java.util.Map.Entry;


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
    public void writeAggregateSymptoms(Map<String, Integer> mapSymptoms) throws  Exception {

        if (filepath != null) {
            FileWriter writer = new FileWriter(filepath);
            for (Entry mapEntry : mapSymptoms.entrySet()) {
                writer.write(mapEntry.getKey() + " =  " + mapEntry.getValue() + "\n");
            }
            writer.close();
        } else {
            throw (new InvalidParameterException("null filepath !")) ;
        }
    }

}

