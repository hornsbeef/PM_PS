package at.ac.uibk.pm.g03.csbb5525.s05.e04;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


public class Drawings{

    //all necessary getters and setters created

    private Circle[] circles;

    public void parser(String input) throws IncorrectFormattingException {


        List<String> inputAfterFirstSplit = removeSemicolon(input);

        List<String> inputAfterFirstRemoval = removeBracketsAndNewline(inputAfterFirstSplit);


        List<String[]> perCircleStringBeforeConversion = inputAfterFirstRemoval.stream()
                                                                               .map(it -> it.split(","))
                                                                               .toList();

        try{
            checkCorrectFormatting(perCircleStringBeforeConversion);
        }catch(Exception ex){
            IncorrectFormattingException e = new IncorrectFormattingException("Formatting was not correct:");
            e.initCause(ex);
            throw e;
        }


        List<Integer[]> perCircleAfterConversion;
        try {
            perCircleAfterConversion = toIntegers(perCircleStringBeforeConversion);

        } catch (NumberFormatException ex) {
            IncorrectFormattingException e = new IncorrectFormattingException("per Circle three numbers are needed! Please check your format");
            e.initCause(ex);
            throw e;
        }


        createCirclesArray(perCircleAfterConversion);

    }

    private void createCirclesArray(List<Integer[]> perCircleAfterConversion) {
        //make easier readable:
        //circles = perCircleAfterConversion.stream()
        //                                  .map(it -> new Circle(it[0], it[1], it[2]))
        //                                  .toArray(Circle[]::new);

        //.toArray(Circle[]::new) is a bit overwhelming -> therefore rewritten like this:
        List<Circle> temp = perCircleAfterConversion.stream().map(it -> new Circle(it[0], it[1], it[2])).toList();
        circles = new Circle[temp.size()];
        temp.toArray(circles);



    }

    private static @NotNull List<Integer[]> toIntegers(List<String[]> perCircleStringBeforeConversion) {
        //List<Integer[]> perCircleAfterConversion;
        //make more readable!
        //perCircleAfterConversion = perCircleStringBeforeConversion.stream()
        //                                                          .map(it -> Arrays.stream(it)
        //                                                                           .map(inner -> Integer.parseInt(inner))
        //                                                                           .toArray(s -> new Integer[s]))
        //                                                          .toList();

        // .toArray(s -> new Integer[s])) seems a bit overwhelming, therefore rewritten like this:
        return perCircleStringBeforeConversion.stream().map(it -> {
                                                                      Integer[] arr = new Integer[3]; //arraysize is already checked.
                                                                      int index = 0;
                                                                      for (String s : it) {
                                                                          arr[index] = Integer.parseInt(s);
                                                                          index++;
                                                                      }
                                                                      return arr;
                                                                  }).toList();
    }

    private static void checkCorrectFormatting(List<String[]> perCircleStringBeforeConversion) throws IllegalArgumentException {
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
    }

    private static @NotNull List<String> removeBracketsAndNewline(List<String> inputAfterFirstSplit) {
        return inputAfterFirstSplit.stream()
                                   .map(it -> it.replace("(", "")
                                                                               .replace(")", "")
                                                                               .replace("\n", "")
                                                                               .replace("\t", "")
                                                                  )
                                   .toList();
    }

    private static @NotNull List<String> removeSemicolon(String input) {
        return Arrays.stream(input.split(";"))
                     .toList();
    }


    public Circle[] getCircles() {
        return circles.clone();
    }
}
