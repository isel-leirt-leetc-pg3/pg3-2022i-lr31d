package leirt.pg3.shapes;

public abstract class Shape {
    private Point ref;

    protected Shape(Point ref) {
        this.ref = ref;
    }

    public abstract double area();

    public abstract double perimeter();

    public final void translate(int dx, int dy) {
        ref = ref.add(new Point(dx, dy));
    }

    public String toString() {
        return getClass().getSimpleName() + ":"
               + " ref=" + ref;
    }
}
