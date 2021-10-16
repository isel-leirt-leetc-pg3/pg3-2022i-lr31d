package leirt.pg3;

import leirt.pg3.entities.PersonV2;
import java.time.LocalDate;

public class UsePersons {
    public static void main(String[] args) {
        LocalDate bd = LocalDate.of(2010, 11, 12);
        PersonV2 p = new PersonV2("Carlos", 123456, bd );

        p.show();

        System.out.printf("O %s tem %d anos!\n",
            p.getName(), p.getAge());

        PersonV2 p2 = new PersonV2();
        PersonV2 p3 = p2;
        PersonV2 p4 = new PersonV2("Carlos", 123456, bd );


        p2.show();

        // using equals to compare equality of objects referred by p2 and p3
        // should return true since both vars refer the same object
        System.out.println(p2.equals(p3));

        // using equals to compare equality of objects referred by p and p4
        // Object implementation is used, that compare the objects address,
        // not the objects content, so false is returned.
        System.out.println(p.equals(p4));

        // using equal operator to compare equality of objects referred by p and p4
        // the values of p and p4 variables (the references) are compared,
        // so it gives false, since each variable refer to a different object
        System.out.println(p == p4);

        // uncomment the toString method in PersonV2 and
        // see the executions difference.
        System.out.println(p.toString());
    }
}
