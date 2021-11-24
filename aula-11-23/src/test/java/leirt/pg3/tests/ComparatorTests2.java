package leirt.pg3.tests;

import leirt.pg3.entities.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class ComparatorTests2 {

    @Test
    public void try_sort_persons_array_by_natural_order() {
        // Person implements Comparable<Person>
        // Natural order corresponds to the order
        // imposed by that implementation
        // In this case it is the name order

        Person[] persons = {
            new Person("Manuel", 3,
                LocalDate.of(2000, 11, 12)),
            new Person("Carlos", 2,
                LocalDate.of(1990, 11, 13)),
            new Person("Luisa", 4,
                LocalDate.of(1990, 11, 19))
        };

        // Note that we don't pass the order to the sort
        // In this case the natural order is used
        Arrays.sort(persons);

        for(Person p : persons)
            System.out.println(p);
    }

    @Test
    public void try_sort_persons_array_by_comparator() {
        Person[] persons = {
            new Person("Manuel", 3,
                LocalDate.of(2000, 11, 12)),
            new Person("Carlos", 2,
                LocalDate.of(1990, 11, 13)),
            new Person("Luisa", 4,
                LocalDate.of(1990, 11, 19))
        };

        // here we used an explicit comparator to
        // sort the Person array by a different order
        // (cityzen id number)
        Arrays.sort(persons, (p1,p2) ->
            Long.compare(p1.getId(), p2.getId()));

        for(Person p : persons)
            System.out.println(p);
    }
}
