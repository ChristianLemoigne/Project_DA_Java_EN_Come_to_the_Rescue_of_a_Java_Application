package com.hemebiotech.symptomwriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * write list of symptom data into a source
 * The important part is, two parameters in input :
 * the list of Symptoms and the map of symptoms count
 *
 *
 */

public interface ISymptomWriter {

        /**
         * it write the symptoms
         * @param listSymptoms  List of symptoms, not necesary sorted
         * @param mapSymptomsCount  map  of symptoms aggregated and their count, on line per symptom
         * @throws IOException  if problem in writing the list of symptoms
         */

        void writeAggregateSymptoms (List<String> listSymptoms, Map<String, Integer> mapSymptomsCount)  throws IOException;
}


