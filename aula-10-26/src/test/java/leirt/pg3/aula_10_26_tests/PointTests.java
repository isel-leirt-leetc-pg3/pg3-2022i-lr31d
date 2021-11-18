package leirt.pg3.aula_10_26_tests;

import leirt.pg3.types.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTests {

    @Test
    public void same_object_equals_test() {
        Point p = new Point(2, 3);
        Point p1 = p;

        boolean areEqualPoints = p.equals(p1);
        assertTrue(areEqualPoints);
    }

    @Test
    public void different_object_with_same_content_equals_test() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);

        /*
        boolean areEqualPoints = p1.equals(p2);
        Assertions.assertTrue(areEqualPoints);
        */

       assertEquals(p1, p2);


    }

    @Test
    public void get_point_from_text_test() {
        String text = "  ( 23.45,   43.26  )";
        Point p = Point.from(text);

        System.out.println(p);
    }
}
