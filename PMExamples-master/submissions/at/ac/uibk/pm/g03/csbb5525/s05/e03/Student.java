package at.ac.uibk.pm.g03.csbb5525.s05.e03;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private final String firstName;
    private final String lastName;
    private final String studentNumber;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = UUID.randomUUID().toString();
    }

    /*
    Stellen Sie sicher, dass Student-Objekte nur gleichwertig sind, wenn diese dieselbe Matrikel-Nr.
    besitzen.
    Hab ich so verstanden, dass Vor und Nachname nicht ausreichen, und auch die Matrikelnummer geleich sein muss.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        return Objects.equals(studentNumber, student.studentNumber) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, studentNumber);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +", " + studentNumber;
    }


}
