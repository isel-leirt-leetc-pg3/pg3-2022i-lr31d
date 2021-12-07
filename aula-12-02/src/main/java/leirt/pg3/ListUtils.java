package leirt.pg3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * In this class tehere generic versions
 * for filter, map and forEach operations on lists
 */
public class ListUtils  {

    public  static <E> List<E> filter(List<E> items,
                                               Predicate<E> pred) {
        List<E> newList = new ArrayList<>();

        for(E p : items) {
            if (pred.test(p)) newList.add(p);
        }
        return newList;
    }

    public  static <T,U> List<U> map(List<T> items,
                      Function<T,U> mapper) {
        List<U> newList = new ArrayList<>();

        for(T t : items) {
            newList.add(mapper.apply(t));
        }
        return newList;
    }

    public  static <T> void forEach(List<T> items,
                              Consumer<T> action) {
        for (T t : items) {
            action.accept(t);
        }
    }

    public static long sum(List<Integer> values) {
        long[] total = {0};
        forEach(
            values,
            (n -> total[0] +=  n)
        );
        return total[0];
    }
}
