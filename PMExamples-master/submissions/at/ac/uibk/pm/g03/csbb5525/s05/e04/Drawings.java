package at.ac.uibk.pm.g03.csbb5525.s05.e04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Drawings {

    private Circle[] circles;

    public void parser(String input) {
        //todo: implement robust Exceptions

        List<String> inputAfterFirstSplit = Arrays.stream(input.split(";"))
                                                  .toList();

        List<String> inputAfterFirstRemoval = inputAfterFirstSplit.stream()
                                                                  .map(it -> it.replace("(", "")
                                                                               .replace(")", "")
                                                                               .replace("\n", "")
                                                                               .replace("\t", "")
                                                                  )
                                                                  .toList();


        List<String[]> perCircleStringBeforeConversion = inputAfterFirstRemoval.stream()
                                                                               .map(it -> it.split(","))
                                                                               .toList();
        //testing
        //perCircleStringBeforeConversion.forEach(it -> System.out.println(Arrays.toString(it)));

        perCircleStringBeforeConversion.forEach(it -> {
            if (it.length != 3) {
                throw new IllegalArgumentException("per Circle three numbers are needed!");
            }
            for (String s : it) {
                for (char c : s.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException("the Circle needs NUMBERS (without chars mixed in)");
                    }
                }
            }
        });



        List<Integer[]> perCircleAfterConversion;
        try {
            //make more readable!
            //perCircleAfterConversion = perCircleStringBeforeConversion.stream()
            //                                                          .map(it -> Arrays.stream(it)
            //                                                                           .map(inner -> Integer.parseInt(inner))
            //                                                                           .toArray(s -> new Integer[s]))
            //                                                          .toList();

            // .toArray(s -> new Integer[s])) seems a bit overwhelming, therefore rewritten like this:
            perCircleAfterConversion = perCircleStringBeforeConversion.stream().map(it -> {
                                                                          Integer[] arr = new Integer[3]; //arraysize is already checked.
                                                                          int index = 0;
                                                                          for (String s : it) {
                                                                              arr[index] = Integer.parseInt(s);
                                                                              index++;
                                                                          }
                                                                          return arr;
                                                                      }).toList();




        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("per Circle three numbers are needed! Please check your format");
        }


        //testing:
        //perCircleAfterConversion.forEach(it -> System.out.println(Arrays.toString(it)));
        circles = perCircleAfterConversion.stream()
                                          .map(it -> new Circle(it[0], it[1], it[2]))
                                          .toArray(Circle[]::new);

    }


    public Circle[] getCircles() {
        return circles.clone();
    }
}
