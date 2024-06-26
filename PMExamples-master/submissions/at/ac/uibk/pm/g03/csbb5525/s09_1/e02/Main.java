package at.ac.uibk.pm.g03.csbb5525.s09_1.e02;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Path pathToFile = Path.of(args[0]);
        try(InputStream inputStream = new NumberInputStream(pathToFile)){
            byte[] input = inputStream.readNBytes(11);

            //StringBuilder stringBuilder = new StringBuilder();
            //for (int i = 0; i < input.length; i++) {
            //    stringBuilder.append(input[i]);
            //}
            //System.out.println(stringBuilder.toString());

            System.out.println(new String(input, StandardCharsets.UTF_8));

        }catch(IOException ioException){
            System.out.println(ioException.getMessage());
            ioException.printStackTrace();
        }

    }
}
