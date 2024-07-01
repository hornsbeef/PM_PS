package at.ac.uibk.pm.g03.csbb5525.s10.e05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileMergerTest {

    @AfterEach
    public void afterEach()throws IOException{
        Files.delete(Path.of("output.txt"));
    }



    @Test
    public void testFileMerger(@TempDir Path tempDir) throws IOException  //NEEDS import org.junit.jupiter.api.io.TempDir;
    {
        Path input1 = tempDir.resolve("file1.txt");
        Path input2 = tempDir.resolve("file2.txt");
        Path input3 = tempDir.resolve("file3.txt");

        Files.writeString(input1, "abc");
        Files.writeString(input2, "defg");
        Files.writeString(input3, "hijkl");

        Path output = tempDir.resolve("output.txt");

        FileMerger fileMerger = new FileMerger();

        fileMerger.mergeFiles(Arrays.asList("file1.txt", "file2.txt", "file3.txt"), "output.txt", 10);

        assertEquals("hijkldefg", Files.readString(Path.of("output.txt")));
    }

    @Test
    public void testFileMerger2(@TempDir Path tempDir) throws IOException  //NEEDS import org.junit.jupiter.api.io.TempDir;
    {
        Path input1 = tempDir.resolve("file1.txt");
        Path input2 = tempDir.resolve("file2.txt");
        Path input3 = tempDir.resolve("file3.txt");

        Files.writeString(input1, "abc");
        Files.writeString(input2, "defg");
        Files.writeString(input3, "hijkl");

        Path output = tempDir.resolve("output.txt");

        FileMerger fileMerger = new FileMerger();

        fileMerger.mergeFiles(Arrays.asList("file1.txt", "file2.txt", "file3.txt"), "output.txt", 5);

        assertEquals("hijkl", Files.readString(Path.of("output.txt")));
    }



}
