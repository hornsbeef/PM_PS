package at.ac.uibk.pm.g03.csbb5525.s05.e03;

import java.util.Objects;
import java.util.UUID;

public class Lecturer {

    private final String firstName;
    private final String lastName;
    private final String employeeID;


    public Lecturer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = UUID.randomUUID().toString();
    }


    //same idea here as in Student-class
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lecturer lecturer)) {
            return false;
        }
        return Objects.equals(employeeID, lecturer.employeeID) && Objects.equals(firstName, lecturer.firstName) && Objects.equals(lastName, lecturer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, employeeID);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + employeeID;
    }
}
