package leirt.pg3.shapes;

import java.util.Arrays;

public class Polygon extends Shape {
    private Point[] vertices;

    /**
     * check if the vertices array have at least 3 vertices
     * if not throws a BadShapeException
     * if all is ok, returns the first point in array the will
     * be considered the reference point. The points in the vertices array
     * will be changed to make them relative to the reference point
     * @param vertices
     * @return
     * @throws BadShapeException
     */
    private static Point checkParams(Point[] vertices)
        throws BadShapeException {

      if (vertices.length < 3)
          throw new BadShapeException("Polygon must have at least 3 vertices");
      return vertices[0];
    }

    public static void normalize( Point[] points) {
        Point ref = points[0];
        for(int i=0; i < points.length; ++i) {
            points[i] = points[i].sub(ref);
        }
    }

    public Polygon(Point ... vertices)  throws BadShapeException {
        super(checkParams(vertices));
        this.vertices =
            Arrays.copyOf(vertices, vertices.length);
        normalize(vertices);
    }

    @Override
    public double area() {
        // to be implemented
        return 0;
    }

    @Override
    public double perimeter() {
        // to be implemented
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb =
            new StringBuilder(super.toString());
        sb.append(", [ ");
        sb.append(vertices[0]);
        for(int i= 1; i < vertices.length; ++i) {
            sb.append(", ");
            sb.append(vertices[i]);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
