package at.ac.uibk.pm.g03.csbb5525.s09_1.e01;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        var csv = """
                Aaaa,1,!!
                bb,22,...
                CCC,333,?""";


        System.out.println(CsvToTableConverter.convert(csv));

        System.out.println("-".repeat(20));

        System.out.println(Path.of(args[0]));


        System.out.println("-".repeat(20));

        //Path pathToFile = Path.of("submissions", "at", "ac", "uibk", "pm", "g03", "csbb5525", "s09_1", "e01", "some.csv");
        Path pathToFile = Path.of("some.csv");

        //Path pathToFile = Path.of(args[0]);
        //System.out.println(pathToFile.toAbsolutePath().toFile().exists());
        System.out.println(CsvToTableConverter.convert(pathToFile));


    }

}

//submissions/at/ac/uibk/pm/g03/csbb5525/s09_1/e01/some.csv