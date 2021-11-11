import leirt.pg3.shapes.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class ShapesTests {

    @Test
    public void try_to_instantiate_shape_class_test() {
        //Shape s = new Shape(new Point(1,1));
    }

    @Test
    public void create_and_show_rectangle() {
        Point p = new Point(3,5);
        Shape r = new Rectangle(p, 10, 6);

        System.out.println(r);
    }

    @Test
    public void check_empty_polygon_creation() {
        try {
            System.out.println("before constructor");
            Point a = new Point(2,3);
            Point b = new Point( 5, 6);
            Shape p = new Polygon(a, b );

            Assertions.fail("Polygon must have at least 3 vertices");
            System.out.println("after constructor");
        }
        catch(BadShapeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("after try");
    }

    @Test
    public void check_polygon_toString()
                    throws BadShapeException {
        Point a = new Point(2,3);
        Point b = new Point( 5, 6);
        Point c = new Point( 8, 9);
        Shape p = new Polygon(a, b, c);

        System.out.println(p.toString());
    }

    @Test
    public void check_square_toString() {

        Shape p = new Square(new Point(2,3), 10);

        System.out.println(p.toString());
    }

    @Test
    public void show_quadrilaterals_diagonals_size() {
        Point ref = new Point();
        Quadrilateral[] quads = {
            new Rectangle(ref, 3, 4),
            new Square(ref, 2),
            new Trapezium(ref, 3, 3, 1)
        };

        for(Quadrilateral q : quads) {
            System.out.printf("diag. of (%s) = %.3f\n",
                              q, q.diagonalSize());
        }
    }

    @Test
    public void show_quadrilaterals_diagonals_size_in_shapes()
                                throws BadShapeException {
        Point ref = new Point();
        Point a = new Point(2,3);
        Point b = new Point( 5, 6);
        Point c = new Point( 8, 9);

        Shape[] shapes = {
            new Rectangle(ref, 3, 4),
            new Circle(ref, 8.5),
            new Polygon(a, b, c),
            new Square(ref, 2),
            new Trapezium(ref, 3, 3, 1)
        };

        for(Shape s : shapes) {
            if (s instanceof Quadrilateral) {
                Quadrilateral q = (Quadrilateral) s;
                System.out.printf("diag. of (%s) = %.3f\n",
                    q, q.diagonalSize());
            }
        }
    }
}
