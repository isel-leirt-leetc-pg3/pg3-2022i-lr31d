package leirt.pg3.entities;

import java.time.LocalDate;

public class PersonV2 {
    private String name; 			// person name
    private long citizenId; 		// citizen card number
    private LocalDate birthDate; 	// birth date

    public PersonV2() {
        name = "Test name";
        citizenId = 123456789;
        birthDate = LocalDate.now();
    }
    public PersonV2(String name, long citizenId, LocalDate birthDate) {
        // "this" is the hidden parameter  (of the class type)
        // passed to constructors and instance methods
        // that reference the invoked (called) object.
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

    /*
    public String toString() {
        return "{ Nome: " + this.name +  ", "
                  + "Bi: " + citizenId + ", "
                  + "Data nasc.: " + birthDate
                  +
              "}";
    }

    */


}
