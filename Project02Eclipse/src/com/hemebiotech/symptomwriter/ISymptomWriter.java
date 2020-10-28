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
         *     TODO
         *
         *
         */
        void writeAggregateSymptoms (List<String> listSymptoms, Map<String, Integer> mapSymptomsCount)  throws IOException;
}


