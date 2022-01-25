package leirt.pg3.i1920_t2;

import java.time.LocalDate;

/**
 * Para ter  a classe Date com o mesmo comportamento especificado no enunciado
 * Não era necessário realizar, claro.
 */
public class Date implements Comparable<Date> {
    private LocalDate real;

    public static Date today() {
        return new Date();
    }

    public Date() {
        real = LocalDate.now();
    }

    public Date(String str) {
        real = LocalDate.parse(str);
    }

    public Date(int y, int m, int d) {
        real = LocalDate.of(y,m,d);
    }

    @Override
    public int compareTo(Date o) {
        return real.compareTo(o.real);
    }

    @Override
    public String toString() {
        return real.toString();
    }

    public boolean equals(Object o) {
        if (o.getClass() != Date.class) return  false;
        Date d = (Date) o;
        return real.equals(d.real);
    }
}
