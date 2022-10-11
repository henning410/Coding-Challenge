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

    /**
     * Method to calculate the lowest spread between to given columns
     *
     * @param data Nested list which contains List of fields
     * @param column1 Name of first column for spread calculation
     * @param column2 Name of second column for spread calculation
     * @return  Returns first field (called identifier) as String
     */
    private static String calcSmallestSpread(List<List<String>> data, String column1, String column2) {
        // Make sure list has some content
        if (!data.isEmpty()) {
            List<String> headLine = data.get(0);
            Double smallestSpread = null;
            String identifier = "";
            // Make sure to skip first line in iteration
            for (List<String> line : data.subList(1, data.size())) {
                double currentSpread = Math.abs(Double.parseDouble(line.get(headLine.indexOf(column1))) - Double.parseDouble(line.get(headLine.indexOf(column2))));
                if (smallestSpread == null) {
                    smallestSpread = currentSpread;
                } else if (smallestSpread > currentSpread) {
                    smallestSpread = currentSpread;
                    identifier = line.get(0);
                }
            }
            return identifier;
        }
        return "";
    }
}
