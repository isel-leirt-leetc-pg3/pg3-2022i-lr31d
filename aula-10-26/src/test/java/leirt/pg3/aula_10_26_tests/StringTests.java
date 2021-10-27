package leirt.pg3.aula_10_26_tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTests {
    @Test
    public void check_different_string_objects_test() {
        String s1 = new String("teste");
        String s2 = new String("teste");

        Assertions.assertEquals(s1, s2);
        Assertions.assertTrue(s1 != s2);
    }
}
