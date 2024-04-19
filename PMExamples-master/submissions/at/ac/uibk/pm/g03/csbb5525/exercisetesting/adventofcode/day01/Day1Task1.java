package at.ac.uibk.pm.g03.csbb5525.exercisetesting.adventofcode.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day1Task1 {
        //This works! the conversion form char to int is strange!

    public static void main(String[] args) {
        /*
        the calibration value can be found by combining
        the first digit and the last digit (in that order)
        to form a single two-digit number.
        Then adding all the numbers from all lines together

         */


        Scanner scan = null;
        File data = new File("submissions/at/ac/uibk/pm/g03/csbb5525/exercisetesting/adventofcode/day01/input");


        try {
            scan = new Scanner(data);
        } catch (
                FileNotFoundException e) {
            System.out.println("File not found!");
        }

        int sum = 0;

        while(scan.hasNext()){
            String temp = scan.nextLine();

            char[] charArray = temp.toCharArray();

            int[] intArray = new int[1];
            int intArrayCounter = 0;

            for (int i = 0; i < charArray.length; i++) {
                if(Character.isDigit(charArray[i])){
                    //System.out.println(charArray[i]);
                    intArray[intArrayCounter] = (charArray[i] - '0');
                    intArray = Arrays.copyOf(intArray, intArray.length + 1);
                    intArrayCounter++;
                }

            }

            int first = intArray[0];
                //System.out.println(first);
            int last = intArray[intArrayCounter-1];

            int lineSum = first*10 + last;
            sum += lineSum;


        }
        System.out.println(sum);

    }
}
