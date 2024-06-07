package at.ac.uibk.pm.g03.csbb5525.exercisetesting.filesystem_IO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class File_Path_App {

    public static void main(String[] args) {
        Path xPath = Path.of("TestPath");
        Path absPath = xPath.toAbsolutePath();
        Path absPath2 = Paths.get("C:\\Users\\WindOShornsbeef\\Documents\\2Sem_PS\\PM_PS\\PMExamples-master\\TestPath\\1\\2");
        System.out.println(absPath2);
        absPath2 = absPath2.normalize();
        System.out.println(absPath2);


        //System.out.printf("%s\n%s%n", xPath, absPath);
        try{
            Files.createDirectories(absPath2);
            Path path = absPath2.resolve("Test.txt");
            path.toFile().createNewFile();
            //Files.delete(absPath2);
            //Path absPath1 = absPath2.getParent();
            //System.out.println(absPath1);
            //Files.delete(absPath1);
            Files.list(absPath2).forEach(it -> System.out.println(it.getFileName()));
            FileWriter fileWriter = new FileWriter(String.valueOf(path));
            fileWriter.write("Test im Text.txt");
            fileWriter.close();
        }catch(IOException ioException){
            System.err.printf("Error: \n%s%n%s%n", ioException.getMessage(), ioException.getLocalizedMessage());
            ioException.printStackTrace();
        }


        Path inputFile = Path.of("src", "resources", "alice_in_wonderland.txt");
        try (BufferedReader stream = Files.newBufferedReader(inputFile)) {
            System.out.println(stream.readLine());

            stream.lines().limit(20).forEach(System.out::println);

        } catch (IOException e) {
            // handle error, rethrow error or use throws instead of this catch!
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }


}
