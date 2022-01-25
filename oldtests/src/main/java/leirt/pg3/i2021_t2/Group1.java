package leirt.pg3.i2021_t2;

import java.util.*;
import java.util.function.*;

public class Group1 {
    // Grupo I a)
    public static <S extends Set<String>>
    S greater( Collection<String> c, Comparator<String> cmp, Supplier<S> ss ) {
        S result = ss.get();
/*      String aux = null;
        for( String s : c ) {
            if ( aux == null || cmp.compare( s, aux) > 0 ) aux= s;
        }
        String max = aux;
 */
        String max = Collections.max( c, cmp );
        c.forEach(s -> { if (cmp.compare(s, max) == 0 ) result.add( s ); });
        return result;
    }
    // Grupo II b)
    public static String greaterLength( List<String> words ) {
        if ( words.isEmpty() ) return "";
        TreeSet<String> tree = greater( words,
                                        (s1, s2) -> s1.length()-s2.length(),
                                      //Comparator.comparing(String::length),
                                        ()-> new TreeSet<>( String::compareToIgnoreCase ));
        String result = tree.toString();
        return result.substring(1, result.length()-1);
    }

    public static void main(String[] args) {
        System.out.println( greaterLength(List.of("Santos", "neto", "gois", "Gil", "gaspar")));
    }

}
