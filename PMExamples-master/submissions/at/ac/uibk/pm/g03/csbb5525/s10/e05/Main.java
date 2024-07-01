package at.ac.uibk.pm.g03.csbb5525.s10.e05;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileMerger fileMerger = new FileMerger();

        List<String> fileNames = Arrays.asList("file1.txt", "file2.txt", "file3.txt");

        fileMerger.mergeFiles(fileNames, "output.txt", 10);

    }


}
