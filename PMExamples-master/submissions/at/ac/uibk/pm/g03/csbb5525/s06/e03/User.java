package at.ac.uibk.pm.g03.csbb5525.s06.e03;

import java.time.LocalDate;

public class User {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    public User(String firstName, String lastName, int day, int month, int year){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = LocalDate.of(year, month, day);
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
