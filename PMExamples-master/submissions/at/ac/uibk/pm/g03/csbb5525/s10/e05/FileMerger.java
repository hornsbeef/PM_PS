package at.ac.uibk.pm.g03.csbb5525.s10.e05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileMerger {

    public void mergeFiles(List<String> inputLocationList, String output, int size) {

        int currentSize = 0;

        Path outputPath = Path.of(output);
        try {
            Path outputFile = Files.createFile(outputPath);


            List<String> inputStringList = new ArrayList<>();

            inputLocationList.forEach(inputLocation -> {
                try {
                    //List<String> allLines = Files.readAllLines(Path.of(inputLocation));
                    ////This method ensures that the file is closed when all bytes have been read or an I/O error, or other runtime exception, is thrown.
                    //String inputOfOneFile = allLines.stream().reduce("", (a, b) -> a+b);
                    String inputOfOneFile = Files.readString(Path.of(inputLocation));
                    inputStringList.add(inputOfOneFile);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });

            inputStringList.sort((a, b) -> Integer.compare(b.length(), a.length()));

            if (inputStringList.isEmpty()) {
                return;
            }

            if (inputStringList.get(0)
                               .length() > size) {
                System.out.println("Longest Input is longer than size");
                return;
            }

            StringBuilder sb = new StringBuilder();
            Iterator<String> iterator = inputStringList.iterator();

            while (iterator.hasNext()) {
                String temp = iterator.next();
                currentSize += temp.length();
                if (currentSize > size) {
                    break;
                }
                sb.append(temp);
            }

            Files.writeString(outputFile, sb.toString());

        } catch (IOException ioe) {
            //System.out.println("Output-File already exists!");
            ioe.printStackTrace();
        }


    }


}
