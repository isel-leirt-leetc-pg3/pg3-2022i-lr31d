package leirt.pg3.entities;

public  class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x; this.y = y;
    }

    public int distance() {
        return (int) Math.floor(Math.sqrt(x*x + y*y));
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
