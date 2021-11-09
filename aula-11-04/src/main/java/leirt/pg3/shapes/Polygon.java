package leirt.pg3.shapes;

import java.util.Arrays;

public class Polygon extends Shape {
    private Point[] vertices;

    private static Point checkParams(Point[] vertices)
        throws BadShape     {

      if (vertices.length < 3)
          throw new BadShape("Polygon must have at least 3 vertices");
      return vertices[0];

    }
    public Polygon(Point ... vertices)  throws BadShape {
        super(checkParams(vertices));
        this.vertices =
            Arrays.copyOf(vertices, vertices.length);
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
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
