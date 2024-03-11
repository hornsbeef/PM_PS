package at.ac.uibk.pm.serialization;

import java.io.*;

/**
 * Class holds information about a person (including name and address).
 */

public class Person implements Serializable {

    /**
     * the person's first name
     */
    private String firstName;

    /**
     * the person's last name
     */
    private String lastName;

    /**
     * the person's age
     */
    private int age;

    /**
     * the person's address
     */
    private Address address;

    /**
     * Constructs a person using the given information.
     *
     * @param first   the persons's first name.
     * @param last    the person's last name.
     * @param age     the person's age
     * @param address the person's address.
     */
    public Person(String first, String last, int age, Address address) {
        this.firstName = first;
        this.lastName = last;
        this.age = age;
        this.address = address;
    }

    /**
     * Returns the age of the person.
     *
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the first name of the person
     *
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the person
     *
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * {@return the last name of the person.}
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Returns a String representation of the person.
     *
     * @return String holding first and last name.
     */
    @Override
    public String toString() {
        return String.format("%s %s: %d (%s)", firstName, lastName, age, address);
    }

    /**
     * increases the age of this person by one
     */
    public void increaseAge() {
        this.age += 1;
    }

}