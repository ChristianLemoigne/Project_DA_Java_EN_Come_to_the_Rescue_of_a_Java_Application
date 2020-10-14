package com.hemebiotech.analytics;

import java.io.IOException;

public class Lanceur {

    public static void main(String[] args) {

        try {
            AnalyticsCounter.analyse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        }
    }

}