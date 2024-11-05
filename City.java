public class City {

    private String name;
    private String region;
    private int population;
    private double latitude;
    private double longitude;

    public City(String name, String region, int population, double latitude, double longitude) {
        this.name = name;
        this.region = region;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "City [name=" + name + ", region=" + region + ", population=" + population + ", latitude=" + latitude
                + ", longitude=" + longitude + "]";
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public int getPopulation() {
        return population;
    }
}