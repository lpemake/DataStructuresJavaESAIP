import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CitiesByRegionHasMap {
    public static void main(String[] args) {
  
        ArrayList<City> cities = new ArrayList<>();
        HashMap<String, ArrayList<City>> regions = new HashMap<>();

        try {
            Scanner file = new Scanner(Paths.get("bigcities.txt"));
            while (file.hasNextLine()) {
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
                    // add region to the hashmap and create a new list
                    regions.put(region, new ArrayList<City>());
                }
                // add the city to the list of cities in the region
                regions.get(region).add(city);
            }
            file.close();

            // go through the regions and print the cities in each region
            for (String r : regions.keySet()) {
                System.out.println(r + ":");
                for (City c : regions.get(r)) {
                    System.out.println("  " + c);
                }
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
