package com.hemebiotech.symptomwriter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

    /**
     *
     *
     *  TO DO
     *
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


