package at.ac.uibk.pm.g03.csbb5525.test1.e02;

import java.util.Arrays;

public class Exercise2 {

    public static void main(String[] args) {

        //testing
        //System.out.println('a' == 'A');

        String hello = "hello";
        char[] letters1 = {'H', 'e', 'l', 'o', 'l', '0', '.', '1'};

        System.out.println("before " + hello);
        System.out.println("before " + String.valueOf(letters1));


        System.out.println(containsAllLetters(letters1, hello));
        System.out.println(containsAllLetters(hello, letters1));

        System.out.println("after " + hello);
        System.out.println("after " + String.valueOf(letters1));

    }

    public static boolean containsAllLetters(char[] letters, String text) {
        return containsAllLetters(text, letters);
    }

    public static boolean containsAllLetters(String text, char[] letters) {

        char[] textArray = text.toCharArray();

        int numberOfLetters = 0;
        for (char l : letters) {
            if (Character.isLetter(l)) {
                numberOfLetters++;
            }
        }

        char[] onlyLetters = new char[numberOfLetters];
        int counter = 0;
        for (char l : letters) {
            if (Character.isLetter(l)) {
                onlyLetters[counter] = l;
                counter++;
            }
        }

        boolean[] isPresent = new boolean[onlyLetters.length];
        Arrays.fill(isPresent, false);
        boolean[] allTrue = new boolean[onlyLetters.length];
        Arrays.fill(allTrue, true);


        for (int i = 0; i < onlyLetters.length; i++) {
            for (char t : textArray) {
                if (t == onlyLetters[i]) {
                    isPresent[i] = true;
                }
            }
        }

        return Arrays.equals(allTrue, isPresent);

    }

}
