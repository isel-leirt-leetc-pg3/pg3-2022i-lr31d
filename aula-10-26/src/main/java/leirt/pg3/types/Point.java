package leirt.pg3.types;

import java.util.Objects;


public class Point {
    private double x, y;

    public static Point from(String text) {

        int firstParIdx  = text.indexOf('(');
        int lastParIdx = text.indexOf(')');
        int commaIdx = text.indexOf(',');
        String text_x =
            text.substring(firstParIdx+1, commaIdx).trim();
        String text_y =
            text.substring(commaIdx+1, lastParIdx).trim();

        double x = Double.parseDouble(text_x);
        double y = Double.parseDouble(text_y);
        return new Point(x, y);
    }

    public Point() {
        this(0,0);
    }

    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public Point add(Point p) {
        return new Point(x+p.x, y+p.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p) {
        double distX = x - p.x;
        double distY = y - p.y;
        return Math.sqrt(distX*distX + distY*distY);
    }

    public String toString() {

        return "(" + x + "," + y + ")";
    }

    public int compareTo(Point p) {
        Point origin = new Point();
        return (int) (this.distance(origin) - p.distance(origin));
    }


    public boolean equals(Point p) {
        return x == p.x && y == p.y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }


}
