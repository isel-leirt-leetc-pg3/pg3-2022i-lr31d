package leirt.pg3.trab1.group2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Group2Tests  {

    public  final double LISBOA_FARO_DISTANCE = 360;

    // places used in test
    public  final Place LISBOA = new City("Lisboa", 500000, 300);
    public  final Place COIMBRA = new City("Coimbra", 200000, 150);
    public  final Place PORTO = new City("Porto", 500000, 200);
    public  final Place FARO = new City("Faro", 100000, 100);
    public  final Place SANTAREM = new City("Santarem", 80000, 80);

    // simple path used
    public  final SimplePath PORTO_LISBOA = new SimplePath(PORTO, LISBOA, 330);
    public  final SimplePath LISBOA_COIMBRA = new SimplePath(LISBOA, COIMBRA, 200);
    public  final SimplePath COIMBRA_SANTAREM = new SimplePath(COIMBRA, SANTAREM, 140);
    public  final SimplePath SANTAREM_LISBOA = new SimplePath(SANTAREM, LISBOA, 70);
    public  final SimplePath LISBOA_FARO = new SimplePath(LISBOA, FARO, LISBOA_FARO_DISTANCE);

    // compound paths used in tests
    public   CompoundPath PORTO_COIMBRA;
    public   CompoundPath COIMBRA_FARO;

    // constructor for initiale compound paths
    public Group2Tests() throws PathException {
        PORTO_COIMBRA =  new CompoundPath(2, PORTO_LISBOA, LISBOA_COIMBRA);
        COIMBRA_FARO = new CompoundPath(3, COIMBRA_SANTAREM, SANTAREM_LISBOA, LISBOA_FARO);
    }

    // SimplePath tests

    @Test
    public void get_simple_path_places() {
        Path p = LISBOA_FARO;
        Place[] places = { LISBOA, FARO };

        assertEquals(LISBOA, p.getFirstPlace());
        assertEquals(FARO, p.getLastPlace());
        assertArrayEquals(places, p.getPlaces());
    }

    @Test
    public void get_simple_path_lisboa_faro_distance() throws PathException {
        assertEquals(LISBOA_FARO_DISTANCE, Path.sumDistance(1, LISBOA_FARO));
    }

    @Test
    public void check_to_string_for_simple_path()
        throws PathException {
        Path simple = LISBOA_FARO;
        String expected = "Lisboa -> Faro: 360.0Km";
        System.out.println(simple);
        assertEquals(expected, simple.toString());

    }

    @Test
    public void check_sum_distance_throws_exception_on_invalid_path_number() {
        try {
            Path.sumDistance(2, LISBOA_FARO);
            fail();
        }
        catch(PathException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void check_sum_distance_throws_exception_on_invalid_connection() {
        try {
            Path.sumDistance(2, LISBOA_FARO, COIMBRA_SANTAREM);
            fail("Should detect bad connections");
        }
        catch(PathException e) {
            System.out.println(e.getMessage());
        }
    }

    // CompoundPath tests

    @Test
    public void get_first_and_last_place_from_compound_path()
        throws PathException {
        Path compound = new CompoundPath(2, PORTO_COIMBRA, COIMBRA_FARO);

        assertEquals(PORTO, compound.getFirstPlace());
        assertEquals(FARO, compound.getLastPlace());
    }

    @Test
    public void get_compound_path_distance() throws PathException {
        final double COIMBRA_FARO_DISTANCE = (140 + 70 + LISBOA_FARO_DISTANCE);
        assertEquals(COIMBRA_FARO_DISTANCE, Path.sumDistance(1, COIMBRA_FARO));
    }

    @Test
    public void get_places_from_compound_path()
        throws PathException {

        CompoundPath compound = new CompoundPath(2, PORTO_COIMBRA, COIMBRA_FARO);

        Place[] expected = { PORTO, LISBOA, COIMBRA, SANTAREM, LISBOA, FARO };
        Place[] places = compound.getPlaces();

        // show compound on console
        System.out.println(compound);

        assertEquals(expected.length, places.length);
        assertArrayEquals(expected, places);
    }

    @Test
    public void check_to_string_for_compound_path()
        throws PathException {
        Path compound = new CompoundPath(2, PORTO_COIMBRA, COIMBRA_FARO);
        String expected = "Porto -> Faro: 1100.0Km(Porto->Lisboa->Coimbra->Santarem->Lisboa->Faro)";
        System.out.println(compound);
        assertEquals(expected, compound.toString());
    }
}