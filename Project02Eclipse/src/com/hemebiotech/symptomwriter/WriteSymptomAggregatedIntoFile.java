package com.hemebiotech.symptomwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;
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
    public void writeAggregateSymptoms(List<String> listSymptoms, Map<String, Integer> mapSymptomsCount)  throws  Exception {

        if (filepath != null) {
            FileWriter writer = new FileWriter(filepath);


            listSymptoms.stream().forEach(symptom -> {
                try {
                    writer.write( symptom + "=" + mapSymptomsCount.get(symptom) + "\n");
                }catch (Exception e){
                    try {
                        throw new Exception(e) ;
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                }});

            //TODO  EXPLAIN : A)  does work   but   B) :  doesn't   work   ( need to catch exception"

            /* A    does work

            for (String symptom : listSymptoms) {
                writer.write( symptom + " =  " + mapSymptomsCount.get(symptom) + "\n");
            }
            */

            /* B    doesn't   work   ( need to catch exception"

            listSymptoms.stream().forEach(symptom -> {
                    writer.write( symptom + " =  " + mapSymptomsCount.get(symptom) + "\n");
               });
            */

            writer.close();
        } else {
            throw (new InvalidParameterException("null filepath !")) ;
        }
    }

}

