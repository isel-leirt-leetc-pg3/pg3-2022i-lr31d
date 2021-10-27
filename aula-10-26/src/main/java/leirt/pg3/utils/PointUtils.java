package leirt.pg3.utils;

import leirt.pg3.types.Point;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PointUtils {
    // a static PointUtils variable
    static int xpto;



    /**
     * Determina o menor e o maior ponto presentes no array points
     * Nota: pode obter a dimensão do array points usando o campo length do array
     *       (points.length)
     * @param points
     *      the received array
     * @return
     *      Um array de 2 elementos do tipo Point, o primeiro com o menor
     *      ponto e o segundo com o maior ponto
     *      Nota: criar o array resultado, de 2 elementos, faça:
     *      Point[] result = new Point[2];
     */
    public static Point[] extremes(Point[] points) {
        Point[] result = new Point[2];
        result[0] = result[1] = points[0];

        xpto = 3;

        for(int i = 1; i < points.length; ++i) {
            if (points[i].compareTo(result[0]) < 0)
                result[0] = points[i];
            else if (points[i].compareTo(result[1]) > 0)
                result[1] = points[i];
        }
        return result;
    }

    /**
     * retorna um novo array de pontos ao qual foram retirados os pontos do
     * array "points" que sejam iguais ao ponto "ref"
     * @param points
     *  the receicved array
     * @param ref
     *  the point to find
     * @return
     * O novo array
     */
    public static Point[] remove0(Point[] points, Point ref) {
        int count = 0;
        for(Point p : points) {
            if (p.equals(ref)) count++;
        }
        Point[] pr = new Point[points.length - count];
        int pos = 0;
        for(Point p : points) {
            if (!p.equals(ref)) pr[pos++] = p;
        }
        return pr;
    }


    public static Point[] remove(Point[] points, Point ref) {
        List<Point> pl = new ArrayList<>();

        for(Point p : points) {
            if (!p.equals(ref)) pl.add(p);
        }

        Point[] pr = new Point[pl.size()];

        pl.toArray(pr);
        return pr;
    }



        /**
         * calcula o perímetro do poligono convexo fechado determinado pela
         * sequência de pontos presente no array vertices
         * @param vertices
         * @return
         *  o double que representa o perímetro do array
         */
    public static double perimeter(Point[] vertices) {
        double perimeter = 0.0;

        for (int i= 0; i < vertices.length -1 ; ++i)  {
            perimeter += vertices[i].distance(vertices[i+1]);
        }
        perimeter += vertices[vertices.length-1].distance(vertices[0]);
        return perimeter;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);

        Point[] points = {
            p1,
            new Point(3,3),
            p1,
            p1
        };

        /*
        Point[] points2 = new Point[3];
        points2[0] = p1;
        points2[1] = p1;
        points2[2] = p1;
        */
        Point[] result = PointUtils.extremes(points);

        System.out.println("maior ponto: " + result[1]);
        System.out.println("menor ponto: " + result[0]);
    }
}
