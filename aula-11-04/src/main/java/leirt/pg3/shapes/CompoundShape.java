package leirt.pg3.shapes;

public class CompoundShape extends Shape{

    public CompoundShape(Point r) {
        super(r);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
