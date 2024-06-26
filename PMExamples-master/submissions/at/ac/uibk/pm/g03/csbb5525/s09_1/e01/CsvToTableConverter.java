package at.ac.uibk.pm.g03.csbb5525.s09_1.e01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class CsvToTableConverter {

    public static String convert(Path pathToCsvFile){

        try(BufferedReader reader = Files.newBufferedReader(pathToCsvFile)) {
            StringBuilder input = new StringBuilder();
            reader.lines().forEach(line -> {
                input.append(line);
                input.append("\n");
            });
            //System.out.println(input.toString());
            return convert(input.toString());
            //return "test";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static String convert(String csv) {

        var lines = csv.split("\n");
        var splitByCommaAndNewline = Arrays.stream(lines)
                                           .map(line -> Arrays.stream(line.split(","))
                                                              .toList())
                                           .flatMap(array -> array.stream())
                                           .toList();


        List<List<String>> listOfSeparatedValues = batchStream(splitByCommaAndNewline.stream(), 3);
        //listOfSeparatedValues.forEach(System.out::println);

        StringBuilder sb1 = new StringBuilder();

        listOfSeparatedValues.forEach(line -> {
            sb1.append(String.format("%-4s", line.get(0)));
            sb1.append(" | ");
            sb1.append(String.format("%04d", Integer.parseInt(line.get(1))));
            sb1.append(" | ");
            sb1.append(String.format("%4s", line.get(2)));
            sb1.append("\n");
        });
        sb1.delete(sb1.length()-1, sb1.length());

        return sb1.toString();
    }

    private static <T> List<List<T>> batchStream(Stream<T> stream, int batchSize) {
        List<T> tempList = new ArrayList<>();
        List<List<T>> result = new ArrayList<>();

        stream.forEach(item -> {
            tempList.add(item);
            if (tempList.size() == batchSize) {
                result.add(new ArrayList<>(tempList));
                tempList.clear();
            }
        });

        if (!tempList.isEmpty()) {
            result.add(new ArrayList<>(tempList));
        }

        return result;
    }



}
