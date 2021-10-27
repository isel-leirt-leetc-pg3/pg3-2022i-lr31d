package leirt.pg3.aula_10_26_tests;

import leirt.pg3.types.Point;
import leirt.pg3.utils.PointUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PointUtilsTests {
    @Test
    public void single_array_extremes_test() {
        Point p = new Point(1,2);
        Point[] points = { p };

        Point[] expected = { p, p};
        Point[] result = PointUtils.extremes(points);

        assertTrue(p == result[0]);
        assertTrue(p == result[1]);

        assertArrayEquals(expected, result);
    }

    @Test
    public void all_same_values_array_extremes_test() {
        Point first = new Point(1,2);

        Point[] points = {
            first,
            new Point(1,2),
            new Point(1,2),
            new Point(1,2),
        };

        Point[] expected = {
            new Point(1,2),
            new Point(1,2)
        };
        Point[] result = PointUtils.extremes(points);

        assertTrue(first == result[0]);
        assertTrue(first == result[1]);

        assertArrayEquals(expected, result);
    }

    @Test
    public void different_values_array_extremes_test() {
        Point[] points = {
            new Point(1,3),
            new Point(2,4),
            new Point(3,5),
            new Point(4,1),
        };

        Point[] expected = {
            new Point(1,3),
            new Point(3,5)
        };
        Point[] result = PointUtils.extremes(points);


        assertArrayEquals(expected, result);
    }

    @Test
    public void remove_test() {
        Point ref = new Point(2, 3);
        Point [] points = {
            new Point(2, 3),
            new Point (4, 5),
            new Point (6, 7),
            new Point(2, 3),
        };

        Point[] expected = { new Point(4, 5), new Point(6,7)};


        Point[] result = PointUtils.remove(points, ref);
        List<Point> pointsList = Arrays.asList(result);
        System.out.println(pointsList);
        Assertions.assertArrayEquals(expected, result);
    }
}
