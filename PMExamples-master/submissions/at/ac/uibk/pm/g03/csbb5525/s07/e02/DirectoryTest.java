package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DirectoryTest {


    @Test
    void noDuplicate(){
        Directory actual = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);
        Directory expected = new Directory(List.of(
                new Member("Charlie", 19),
                new Member("Alice", 24),
                new Member("Eve", 25),
                new Member("Frank", 25),
                new Member("David", 31),
                new Member("Bob", 43)));

        assertIterableEquals(expected, actual);
    }

    @Test
    void withDuplicates(){
        Directory actual = new Directory(Main.PARTIALLY_DUPLICATE_MEMBERS);
        Directory expected = new Directory(List.of(
                new Member("Charlie", 19),
                new Member("Bob", 43),
                new Member("David", 31),
                new Member("Bob", 43),
                new Member("Frank", 25),
                new Member("Alice", 24),
                new Member("Eve", 25),
                new Member("Alice", 24)));

        assertIterableEquals(expected, actual);
    }

    @Test
    void upTo40(){
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);

        Directory actual = actDir.upTo(40);
        Directory expected = new Directory(List.of(
                new Member("Charlie", 19),
                new Member("Alice", 24),
                new Member("Eve", 25),
                new Member("Frank", 25),
                new Member("David", 31)
                ));
        assertIterableEquals(expected, actual);
    }

    @Test
    void ofYougest3AgeGroups(){
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);

        Directory actual = actDir.ofYoungestNAgeGroups(3);
        Directory expected = new Directory(List.of(
                new Member("Charlie", 19),
                new Member("Alice", 24),
                new Member("Eve", 25),
                new Member("Frank", 25)

        ));
        assertIterableEquals(expected, actual);
    }

    @Test
    void directorySize(){
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);

        int actual = actDir.size();
        int expected = new Directory(List.of(
                new Member("Charlie", 19),
                new Member("Alice", 24),
                new Member("Eve", 25),
                new Member("Frank", 25),
                new Member("David", 31),
                new Member("Bob", 43)))
                .size();
        assertEquals(expected, actual);
    }

    @Test
    void immutableList() {
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);
        var actual = actDir.listNames();

        Executable when = () -> actual.add(1, "test");

        assertThrows(UnsupportedOperationException.class, when);
    }

    @Test
    void iteratorFirst2Elements() {
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);

        var iterator = actDir.iterator();

        assertAll(
                () ->assertEquals("Charlie (19)", iterator.next()),
                () -> assertEquals("Alice (24)", iterator.next())
        );

    }

    @Test
    void advancedIteratorFirst2Elements() {
        Directory actDir = Directory.ofUniqueMembers(Main.PARTIALLY_DUPLICATE_MEMBERS);

        var iterator = actDir.advancingIterator();

        assertAll(
                () ->assertEquals("Charlie (19)", iterator.next()),
                () -> assertEquals("Alice (24)", iterator.next())
        );

    }



}
