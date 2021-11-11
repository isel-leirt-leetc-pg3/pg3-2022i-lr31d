package leirt.pg3.shapes;

public class Circle extends Shape {

    private final double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + ", radius = " + radius;
    }
}
