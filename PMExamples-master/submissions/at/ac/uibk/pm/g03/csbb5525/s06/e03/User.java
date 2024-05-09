package at.ac.uibk.pm.g03.csbb5525.s06.e03;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;

public class User {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    private final static int minYear = 1900;
    private final static int maxYear = Year.now().getValue();



    public User(String firstName, String lastName, int day, int month, int year){
        if(firstName == null || lastName == null){
            throw new IllegalArgumentException("Userfields must not be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        if(year < minYear || year > maxYear){
            throw new IllegalArgumentException("User must have a valid birth-year");
        }


        try{
            this.birthday = LocalDate.of(year, month, day);
        }catch(DateTimeException e){
            throw new IllegalArgumentException("User must have a valid birthday");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;    //LocalDate is immutable
    }
}
