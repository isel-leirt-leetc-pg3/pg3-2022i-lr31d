package leirt.pg3.tests;

import leirt.pg3.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTests {

    private  static  List<Person> filterPersons(List<Person> persons,
                                       Predicate<Person> pred) {
        List<Person> newList = new ArrayList<>();

        for(Person p : persons) {
            if (pred.test(p)) newList.add(p);
        }
        return newList;
    }

    @Test
    public void filter_persons_examples() {
        List<Person> persons = List.of(
            new Person("Antonio", 123456,
                LocalDate.of(1990, 2, 3)),
            new Person("Maria", 234567,
                LocalDate.of(1959, 6, 12)),
            new Person("Margarida", 345678,
                LocalDate.of(2010, 7, 1))
        );


        System.out.println("Show persons having name started with letter 'M'");
        List<Person> result =
            filterPersons(persons, p ->
                                        p.getName().startsWith("M"));

        for(Person p : result)  {
            System.out.println(p);
        }

        System.out.println("\nShow persons having more than 20 years");
        result = filterPersons(persons, (p) -> p.getAge() > 20);

        for(Person p : result) {
            System.out.println(p);
        }
    }

    @Test
    public void persons_remove_if_example() {
        List<Person> persons = new ArrayList<>();
        persons.add(
            new Person("Antonio", 123456,
                LocalDate.of(1990, 2, 3)));
        persons.add(
            new Person("Maria", 234567,
                LocalDate.of(1959, 6, 12)));

        persons.add(new Person("Margarida", 345678,
                LocalDate.of(2010, 7, 1)));


        System.out.println("persons class is " + persons.getClass().getName());
        System.out.println("\nShow persons having more than 20 years");


        persons.removeIf(p -> p.getAge() > 20);

        for(Person p : persons)  {
            System.out.println(p);
        }

    }

}
