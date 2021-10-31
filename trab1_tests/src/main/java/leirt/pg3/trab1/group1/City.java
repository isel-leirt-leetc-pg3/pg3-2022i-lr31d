package leirt.pg3.trab1.group1;


import java.util.LinkedList;
import java.util.List;

/**
 * void city implementation
 */
public class City {

    public City(String nm, String country,int p, int a){

    }
    public City(String nm, int p, int a){

    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
       return false;
    }

    public String getName() {
        return "";
    }

    public String getCountry() {
        return "";
    }

    public int getArea() {
        return 0;
    }

    public int getPopulation() {
        return 0;
    }

    public int populationDensity() {
        return 0;
    }

    public int populationChange(double rate) {
      return 0;
    }

    public int compareTo(City c) {
        return -1;
    }

    /**
     * <country> ‘:’ <name> ‘-’ <area> ‘km²:’ <population>
     * @param desc
     * @return
     */
    public static City getCity(String desc) {
       return new City("", "", 0, 0);
    }

    /**
     *
     * @param cities
     * @param country
     * @return
     */
    public static int getCountryCitiesCount(City[] cities, String country) {
       return 0;
    }



    public static City smallerCity(City... cities) {
        return cities[0];
    }

    public static City[] getTop10(City[] cities) {
        return cities;
    }


}


