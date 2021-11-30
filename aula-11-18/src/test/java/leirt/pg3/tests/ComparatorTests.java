package leirt.pg3.tests;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTests {

    // a private inner class used in tests
    private static class Point {
        public final int x, y;

        public Point(int x, int y) {
            this.x = x; this.y = y;
        }

        public int distance() {
            return (int) Math.floor(Math.sqrt(x*x + y*y));
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /**
     * A private inner class that implements Comparator<Point>
     * using distance as criterium
     */
    private static class PointComparator implements  Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            return p1.distance() - p2.distance();
        }
    }


    /**
     * Show using class PointComparator for comparing points
     */
    @Test
    public void points_sort_with_normal_class() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2 ),
            new Point(3, 4)
        };

        PointComparator pc = new PointComparator();

        Arrays.sort(points, pc);

        for(Point p : points)
            System.out.println(p);

    }

    /**
     * Show using an anonymous class for comparing points
     */
    @Test
    public void points_sort_with_anonymous_class() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2 ),
            new Point(3, 4)
        };

        // using an anonymous class for the creation of a point comparator
        Comparator<Point> pc = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                // the System.out is just for demo purposes
                System.out.println("comparing " +p1 + " and " + p2);
                return p1.distance()-p2.distance();
            }
        };


        Arrays.sort(points, pc);

        for(Point p : points)
            System.out.println(p);

    }

    private static  int cmpPointsStatic(Point p1, Point p2) {
        return p1.distance()-p2.distance();
    }

    private  int cmpPoints(Point p1, Point p2) {
        return cmpPointsStatic(p1,p2);
    }

    /**
     * Show using a lambda expression for comparing points
     */
    @Test
    public void points_sort_with_lambda_expression() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2),
            new Point(3, 4)
        };

        Arrays.sort(points,
                  // the lambda expression is in fact an implementation of Comparator<Point>
                  (p1,p2) -> p1.distance() - p2.distance());

        for(Point p : points)
            System.out.println(p);
    }

    /**
     * Show using a static  method reference for comparing points
     */
    @Test
    public void points_sort_with_static_method_reference() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2 ),
            new Point(3, 4)
        };

        Arrays.sort(points, ComparatorTests::cmpPointsStatic);

        for(Point p : points)
            System.out.println(p);

    }

    /**
     * Show using an instance method reference for comparing points
     */
    @Test
    public void points_sort_with_instance_method_reference() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2 ),
            new Point(3, 4)
        };

        Arrays.sort(points, this::cmpPoints);

        for(Point p : points)
            System.out.println(p);

    }

    /**
     * Show using an instance method reference for comparing points
     */
    @Test
    public void points_sort_with_comparator_comparing_static_method() {
        Point[] points = {
            new Point(2,3),
            new Point(1,2 ),
            new Point(3, 4)
        };

        Arrays.sort(points,
            Comparator.comparing(Point::distance));

        for(Point p : points)
            System.out.println(p);

    }
}
