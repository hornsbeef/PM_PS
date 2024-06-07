package at.ac.uibk.pm.g03.csbb5525.exercisetesting.filesystem_IO;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Scanner_experimenting {


    public static void main(String[] args) {
        String input = "Hello World!";
        Scanner scanner = new Scanner(input);

        // Skip the word "World" using skip(Pattern pattern)
        //scanner.skip(Pattern.compile("World"));   //->NoSuchElementException
        //System.out.println(scanner.nextLine()); // prints "Hello "

        // Skip the word "World" using skip(String pattern)
        scanner = new Scanner(input);
        scanner.skip(".*World");
        System.out.println(scanner.nextLine()); // prints "Hello "

        // Skip the word "Hello" using skip(Pattern pattern)
        scanner = new Scanner(input);
        scanner.skip(Pattern.compile("Hello"));
        System.out.println(scanner.nextLine()); // prints " World!"

        System.out.println("-".repeat(20));

        String input2 = "Hello, world Hello again!";
        Scanner scanner2 = new Scanner(input2);
        Stream<MatchResult> stream = scanner2.findAll(".*o\\p{Blank}");
        stream.forEach(match -> System.out.println(match.group()));

        stream = scanner2.findAll(".*o,");
        stream.forEach(match -> System.out.println(match.group()));






    }


}
