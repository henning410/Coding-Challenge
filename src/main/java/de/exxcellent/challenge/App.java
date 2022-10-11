package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public static void main(String... args) {
        // Your preparation code …

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

    /**
     * Method to read csv file in resource folder and return lines as list
     *
     * @param filename
     * @return List which contains list of fields
     * @throws IOException  Throw exception if reading of the file fails
     */
    private static List<List<String>> readFileToList(String filename) throws IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
        List<List<String>> records = new ArrayList<>();
        if (url != null) {
            InputStreamReader stream = new InputStreamReader(url.openStream());
            try (BufferedReader br = new BufferedReader(stream)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    records.add(Arrays.asList(values));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return records;
    }
}
