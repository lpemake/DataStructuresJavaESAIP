import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class ReadCitiesFile {
   public static void main(String[] args) {
        // list to store cities
        ArrayList<City> cities = new ArrayList<>();

        // read file bigcities.txt
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
            }
            file.close();

            // sort the cities by name
            Collections.sort(cities, (city1, city2) -> city1.getName().compareTo(city2.getName()));
            Collections.sort(cities, (city1, city2) -> city2.getPopulation() - city1.getPopulation());

             // Create a comparator to sort cities by region and name
            Comparator<City> comparator = Comparator
                .comparing(City::getRegion)
                .thenComparing(City::getName);

            Collections.sort(cities, comparator);

            for (City city : cities) {
                System.out.println(city);
            }

            // population of cities
            HashMap<String, Integer> citypopulations = new HashMap<>();
            citypopulations.put("Seinajoki", 66000);
            citypopulations.put("Tampere", 220000);

            // map of city objects
            HashMap<String, City> citymap = new HashMap<>();
            citymap.put("Paris", new City("Paris", "Ile-de-France",
                2240000, 48.8566, 2.3522));
            citymap.put("Helsinki", new City("Helsinki", "Uusimaa",
                643272, 60.1695, 24.9354));

            // Map of cities by region
            HashMap<String, ArrayList<City>> citiesByRegion = new HashMap<>();
            citiesByRegion.put("Uusimaa", new ArrayList<>());
            citiesByRegion.put("Ile-de-France", new ArrayList<>());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }





   } 
}
