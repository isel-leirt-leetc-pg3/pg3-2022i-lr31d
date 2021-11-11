package leirt.pg3.shapes;

public class Trapezium extends Shape implements Quadrilateral {
    private final double width, height, offset;

    public Trapezium(Point ref, double width,
                     double height, double offset) {
        super(ref);
        this.width = width;
        this.height = height;
        this.offset = offset;
    }

    @Override
    public double area() {
        return (width+offset)*height;
    }

    @Override
    public double perimeter() {
        return 2*(width+offset) + 2*height;
    }

    @Override
    public double diagonalSize() {
        Point p1 = new Point();
        Point p2 = new Point(width+offset, height);
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + ", width=" + width
            + ", height=" + height
            + ", offset=" + offset;
    }
}
