package de.exxcellent.calculations;

import java.util.List;

public class SmallestSpread {
    /**
     * Method to calculate the lowest spread between to given columns
     *
     * @param data Nested list which contains List of fields
     * @param column1 Name of first column for spread calculation
     * @param column2 Name of second column for spread calculation
     * @return  Returns first field (called identifier) as String
     */
    public static String getSmallestSpread(List<List<String>> data, String column1, String column2) {
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
