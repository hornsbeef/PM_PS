package at.ac.uibk.pm.g03.csbb5525.s07.e02;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static final List<Member> PARTIALLY_DUPLICATE_MEMBERS = List.of(
            new Member("Charlie", 19),
            new Member("Bob", 43),
            new Member("David", 31),
            new Member("Bob", 43),
            new Member("Frank", 25),
            new Member("Alice", 24),
            new Member("Eve", 25),
            new Member("Alice", 24));

    public static void main(String[] args) {
        Directory directory = Directory.ofUniqueMembers(PARTIALLY_DUPLICATE_MEMBERS);

        System.out.println("[Names]");
        List<String> names = directory.listNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println();

        System.out.println("[Directory]");
        for (String member : directory) {
            System.out.println(member);
        }

        System.out.println();

        System.out.println("[Up to 40]");
        Directory upTo40 = directory.upTo(40);
        for (String member : upTo40) {
            System.out.println(member);
        }

        System.out.println();

        System.out.println("[Youngest 3 age groups]");
        Directory youngest = directory.ofYoungestNAgeGroups(3);
        for (String member : youngest) {
            System.out.println(member);
        }

        System.out.println();

        System.out.println("[Youngest 3 age groups (via AdvancingDirectoryIterator)]");
        Iterator<String> youngestAdvancingIterator = youngest.advancingIterator();
        while (youngestAdvancingIterator.hasNext()) {
            System.out.println(youngestAdvancingIterator.next());
        }
    }
}
