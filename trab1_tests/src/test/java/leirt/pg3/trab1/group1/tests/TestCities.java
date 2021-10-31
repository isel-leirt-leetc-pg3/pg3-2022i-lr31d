package leirt.pg3.trab1.group1.tests;


import leirt.pg3.trab1.group1.City;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class TestCities {
    private static final City FARO = new City("Faro", 64560, 202 );
    private static final City LEIRIA = new City("Leiria", "Portugal", 55000, 100 );
    private static final City NOVA_YORK = new City("Nova York", "Estados Unidos",  8419000, 783);

    private void testGetters( City c, String nm, String ct, int p, int a) {
        assertEquals(nm, c.getName());
        assertEquals(ct, c.getCountry());
        assertEquals(p, c.getPopulation());
        assertEquals(a, c.getArea());
    }

    @Test
    public void check_construction_tests() {
        testGetters( FARO, "Faro", "Portugal", 64560, 202 );
        testGetters( NOVA_YORK, "Nova York", "Estados Unidos",  8419000, 783);
    }

    @Test
    public void toString_tests() {
        assertEquals( "Portugal:Faro - 202km2:64560", FARO.toString() );
        assertEquals( "Estados Unidos:Nova York - 783km2:8419000", NOVA_YORK.toString() );
    }

    @Test
    public void population_density_tests() {
        assertEquals( 64560/202, FARO.populationDensity());
        assertEquals(8419000/783, NOVA_YORK.populationDensity());
    }

    @Test
    public void equals_tests() {

        assertTrue( FARO.equals(new City(new String("Faro"), 64560, 202)) );

        assertTrue( NOVA_YORK.equals(new City("Nova York", new String("Estados Unidos"),  8419000, 783)) );

        assertFalse( NOVA_YORK.equals( new City("Nova","Estados Unidos",  8419000, 783) ));
        assertFalse( NOVA_YORK.equals( new City("Nova York", "Estados",  8419000, 783) ));
        assertFalse( NOVA_YORK.equals( new City("Nova York","Estados Unidos",  8419, 783) ));
        assertFalse( NOVA_YORK.equals( new City("Nova York", "Estados Unidos",  8419000, 78) ));

        assertFalse( FARO.equals( null ) );
        assertFalse( FARO.equals("Portugal:Faro - 202Km2:64560"));
    }

    @Test
    public void compareTo_tests() {
        assertTrue( FARO.compareTo( FARO ) == 0 );
        assertTrue( FARO.compareTo( NOVA_YORK ) < 0 );
        assertTrue( NOVA_YORK.compareTo( FARO ) > 0 );
    }

    @Test
    public void population_change_tests() {
        assertEquals(106441, FARO.populationChange(0.5));
        assertEquals(64560, FARO.populationChange(1.1));
        assertEquals(64560, FARO.populationChange(-1.0));
        assertEquals(64560, FARO.populationChange(0.0));
        assertEquals(71349, FARO.populationChange(0.1));
    }

    @Test
    public void getCity_tests() {
        City faro =  City.getCity( "Portugal:Faro - 202km2:64560" );

        testGetters( faro, "Faro", "Portugal", 64560, 202 );
        assertTrue(FARO.equals( faro ) );
        assertEquals( FARO, faro  );

        City ny = City.getCity( "Estados Unidos:Nova York - 783km2:8419000" );
        testGetters(ny, "Nova York", "Estados Unidos",  8419000, 783);
        assertEquals( NOVA_YORK, ny  );
    }

    private static String[] descriptions = {
        "Portugal:Faro - 202km2:64560",
        "Estados Unidos:Nova York - 783km2:8419000",
        "Estados Unidos:Boston - 232km2:684379",
        "Estados Unidos:Chicago - 606km2:2710000",
        "Reino Unido:Londres - 1572km2:8982000",
        "Portugal:Leiria - 100km2:55000",
        "Portugal:Lisboa - 300km2:504718",
        "Portugal:Braga - 184km2:136885",
        "Portugal:Chaves - 591km2:41243",
        "Portugal:Viana do Castelo - 319km2:85864",
        "Reino Unido:Bristol - 110km2:467099",
        "Portugal:Porto - 42km2:214349",
        "Portugal:Coimbra - 31km2:105842",
    };

    private static City[] getCities( int n ) {
        if ( n > descriptions.length ) n= descriptions.length;
        City [] cities = new City[n];
        for( int i= 0; i< n; ++i )
            cities[i] = City.getCity( descriptions[i] );
        return cities;
    }

    @Test
    public void get_description_test() {
        String desc =  "Portugal:Faro - 202km2:64560";
        City c = City.getCity(desc);
        testGetters( c, "Faro", "Portugal", 64560, 202 );
    }

    @Test
    public void country_cities_count_tests() {
        City [] cities = getCities(descriptions.length);
        assertEquals( 8, City.getCountryCitiesCount(cities, new String("Portugal")));
        assertEquals( 3, City.getCountryCitiesCount(cities, "Estados Unidos"));
        assertEquals( 2, City.getCountryCitiesCount(cities, "Reino Unido"));
        assertEquals( 0, City.getCountryCitiesCount(cities, "Espanha") );
    }

    @Test
    public void smaller_cities_tests() {
        assertEquals( FARO, City.smallerCity( FARO ) );
        assertEquals( FARO, City.smallerCity( FARO, NOVA_YORK ) );
        assertEquals( FARO, City.smallerCity( NOVA_YORK, FARO ) );


        City[] firstFiveCities = getCities(5);

        assertEquals( FARO, City.smallerCity(firstFiveCities) );

        City[] firstEightCities = getCities(8);

        assertEquals( LEIRIA, City.smallerCity(firstEightCities));

        City[] allCities = getCities(descriptions.length);
        City lastCity = City.getCity(descriptions[descriptions.length-1]);
        assertEquals( lastCity, City.smallerCity(allCities));

        assertNull( City.smallerCity( new City[0]) );
    }

    @Test
    public void top_ten_tests() {
        Comparator<City> cmp = City::compareTo;

        City[] firstThreeCities = getCities( 3  );
        City[] top10 = City.getTop10( firstThreeCities );

        assertTrue( firstThreeCities != top10 );
        assertEquals( 3, top10.length );

        //sort the cities in descending order
        Arrays.sort( firstThreeCities, cmp.reversed() );
        assertArrayEquals(firstThreeCities, top10 );

        City[] allCities = getCities( descriptions.length );
        top10 = City.getTop10( allCities);
        assertEquals( 10, top10.length );

        //sort the cities in descending order
        Arrays.sort( allCities, cmp.reversed() );
        City[] expected = Arrays.copyOf(allCities, 10);
        assertArrayEquals(expected, top10 );

        // sort the cities in ascending order
        Arrays.sort(  allCities, cmp );
        top10 = City.getTop10( allCities);
        assertEquals( 10, top10.length );
        assertArrayEquals(expected, top10 );
    }
}
