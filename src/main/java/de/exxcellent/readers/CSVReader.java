package de.exxcellent.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    /**
     * Method to read csv file in resource folder and return lines as list
     *
     * @param filename
     * @return List which contains list of fields
     * @throws IOException  Throw exception if reading of the file fails
     */
    public static List<List<String>> readFileToList(String filename) throws IOException {
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
