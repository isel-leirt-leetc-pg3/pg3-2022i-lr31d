package leirt.pg3.shapes;

public class Rectangle extends Shape
    implements Quadrilater {
    private double width;
    private double height;

    public Rectangle(Point p, double w, double h) {
        super(p);
        this.width = w;
        this.height = h;
    }

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public double perimeter() {
        return 2*width+2*height;
    }

    @Override
    public String toString() {

        String s = super.toString();
        return s + ", width=" + width
                 + ", height=" + height;
    }

    @Override
    public double diagonalSize() {
        return 0;
    }
}
