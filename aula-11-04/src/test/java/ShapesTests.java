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
        catch(BadShape e) {
            System.out.println(e.getMessage());
        }
        System.out.println("after try");
    }

    @Test
    public void check_polygon_toString()
                    throws BadShape {
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
}
