package leirt.pg3.entities;

import java.time.LocalDate;

public class Person {
    private String name; 			// person name
    private long citizenId; 		// citizen card number
    private LocalDate birthDate; 	// birth date

    public Person(String n, long id, LocalDate birth) {
        birthDate = birth;
        citizenId = id;
        name = n;
    }

    public void show() {
        System.out.println("Nome: " + name);
        System.out.println("Bi: " + citizenId);
        System.out.println("Data nasc.: " + birthDate);
    }


}
