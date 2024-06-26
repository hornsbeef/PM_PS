package at.ac.uibk.pm.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class shows Java's functionality for reading files, folders and information
 * from the file system.
 */
public class FileApplication {

    /**
     * The main method for the FileReader application.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        // get information on path
        Path relativePath = Path.of("src", "at", "ac", "uibk", "pm");
        Path absolutePath = relativePath.toAbsolutePath();
        System.out.printf("path: %s%n", absolutePath);
        System.out.printf("root: %s%n", absolutePath.getRoot());
        System.out.printf("parent: %s%n", relativePath.getParent());
        System.out.printf("filename: %s%n%n", relativePath.getFileName());

        // get information on the file

        System.out.printf("file exists: %b%n%n", Files.exists(relativePath));

        // get all files contained in directory if present
        System.out.printf("Files in directory %s:%n", relativePath);
        if (Files.isDirectory(relativePath)) {
            try {
                Files.list(relativePath).forEach(System.out::println);

                System.out.println("-".repeat(20));
                var test = Files.list(relativePath)
                                .map(x -> x.getFileName())
                                .map(x -> x.toString())
                                .sorted()
                                .toList();
                //test.forEach(System.out::println);
                System.out.println(String.join(", ", test));

                System.out.println("-".repeat(20));
                Set<String> set = new TreeSet<>();
                set.add("abc");
                set.add("ghi");
                set.add("def");
                System.out.println(set);

            } catch (IOException e) {
                System.out.println("There was a problem reading the files in the given directory.");
                e.printStackTrace();
            }
        } else {
            System.out.printf("%s is not a directory!%n", relativePath);
        }
    }
}
