package leirt.pg3.shapes;


public class Point {
    private double x, y;

    public Point() {
        this.x = this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x; this.y = y;
    }

    public Point add(Point p) {
        return new Point(x+p.x, y+p.y);
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public double distance(Point p) {
        double distX = x - p.x;
        double distY = y - p.y;
        return Math.sqrt(distX*distX + distY*distY);
    }



    // toString implementation for Point
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }


    public int compareTo(Point p) {
        // to implement
        return 0;
    }


    // equals como redefinição (override)
    // de equals de object
    @Override
    public boolean equals(Object o) {
        // se as referências forem iguais trata-se
        // do mesmo objecto!
        if (this == o) return true;

        // se o é uma referência nula ou se os tipos
        // dos objectos são diferentes então os objectos
        // não podem ser iguais!
        if (o == null || getClass() != o.getClass())
            return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2),
            p2 = new Point(2, 1),
            p3 = new Point(),
            p4 = new Point(0, 0),
            p5 = new Point(1,2),
            p6 = null,
            p7 = p1;

        // comparar igualdade com null
        System.out.println(p1.equals(p6));

        // comparar igualdade no mesmo objecto
        System.out.println(p1.equals(p7));

        // comparar objectos diferentes com as mesmas coordenadas
        System.out.println(p1.equals(p5));

        // comparar objectos diferentes com as mesmas coordenadas
        System.out.println(p3.equals(p4));

        // comparar objectos diferentes com diferentes coordenadas
        System.out.println(p1.equals(p2));

        // o output deverá ser:
        // false
        // true
        // true
        // true
        // false

        System.out.printf("p1 hashcode = %x\n", p1.hashCode());

        // verifica a diferença de output comentando e descomentando
        // a implementação de toString de Point
        System.out.println("p1 toString = " + p1 );
    }

}
