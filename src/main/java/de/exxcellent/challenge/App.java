package de.exxcellent.challenge;

import java.io.IOException;
import java.util.List;

import static de.exxcellent.calculations.SmallestSpread.getSmallestSpread;
import static de.exxcellent.readers.CSVReader.readFileToList;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws IOException {
        List<List<String>> weatherList = readFileToList("weather.csv");
        List<List<String>> footballList = readFileToList("football.csv");

        String dayWithSmallestTempSpread = getSmallestSpread(weatherList, "MxT", "MnT");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = getSmallestSpread(footballList, "Goals", "Goals Allowed");
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

}
