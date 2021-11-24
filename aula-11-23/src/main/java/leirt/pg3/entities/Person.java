package leirt.pg3.entities;

import java.time.LocalDate;

public class Person implements Comparable<Person> {
    private String name; 			// person name
    private long citizenId; 		// citizen card number
    private LocalDate birthDate; 	// birth date

    public Person(String name, long citizenId, LocalDate birthDate) {
        this.birthDate = birthDate;
        this.citizenId = citizenId;
        this.name = name;
    }

    public void show() {
        System.out.println("Nome: " + this.name);
        System.out.println("Bi: " + citizenId);
        System.out.println("Data nasc.: " + birthDate);
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        int diffYears = now.getYear() - birthDate.getYear();

        return birthDate.plusYears(diffYears).isAfter(now)
            ? diffYears -1
            : diffYears;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return citizenId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String toString() {
        return "{ Nome: " + this.name +  ", "
                  + "Bi: " + citizenId + ", "
                  + "Data nasc.: " + birthDate
                  +
              "}";
    }


    @Override
    public int compareTo(Person p) {
        return getName().compareTo(p.getName());
    }
}
