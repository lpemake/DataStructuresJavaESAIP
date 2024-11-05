import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class CountCitiesByRegionHasMap {
    public static void main(String[] args) {
        // lista kuntia varten 
        ArrayList<City> cities = new ArrayList<>();

        HashMap<String, Integer> regions = new HashMap<>();

        try {
            Scanner file = new Scanner(Paths.get("bigcities.txt"));
            while (file.hasNextLine()) {
                // read the next line
                String line = file.nextLine();
                // split the line into parts
                String[] parts = line.split(";");
                // get the data from the parts array
                String name = parts[0];
                String region = parts[1];
                int population = Integer.parseInt(parts[2]);
                double latitude = Double.parseDouble(parts[3]);
                double longitude = Double.parseDouble(parts[4]);
                // create a new City object and add it to the list
                City city = new City(name, region, population,
                    latitude, longitude);
                cities.add(city);

                // check if the region is in the hashmap
                if (!regions.containsKey(region)) {
                    // add region to the hashmap
                    regions.put(region, 0);
                }
                // get the current value from the hashmap
                int value = regions.get(region);
                // increment the value
                regions.put(region, ++value);
            }
            file.close();

            // go through the regions and print the number of cities in each region
            for (String r : regions.keySet()) {
                int count = regions.get(r);
                System.out.println(r + ": " + count);
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
