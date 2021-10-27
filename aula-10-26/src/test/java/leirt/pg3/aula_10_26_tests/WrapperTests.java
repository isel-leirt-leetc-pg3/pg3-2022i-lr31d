package leirt.pg3.aula_10_26_tests;

import org.junit.jupiter.api.Test;

public class WrapperTests {
    @Test
    public void primitive_double_as_object_test() {
        double d = 3.14;
        Double o = d;

        double d1 = o;

        System.out.println(o.getClass().getName());
    }
}
