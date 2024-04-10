package at.ac.uibk.pm.g03.csbb5525.exercisetesting.adventofcode.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Day1 {

    public static void main(String[] args){

        /*
        the calibration value can be found by combining
        the first digit and the last digit (in that order)
        to form a single two-digit number.
         */


        Scanner scan = null;
        File data = new File ("submissions/at/ac/uibk/pm/g03/csbb5525/exercisetesting/adventofcode/day01/input");



        try{
            scan = new Scanner(data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


        List<ArrayList> list = new ArrayList<>();


        //while(scan.hasNext()){
            //testing:
            //System.out.println(scan.nextLine());


            String temp = scan.nextLine();


            List<Character> characterList = temp.chars().mapToObj(c-> (char) c).toList();

            //characterList.forEach(System.out::print);
            //System.out.println();

            List<Character> charactersListdigits =
                   characterList.stream()
                                .filter(c -> Character.isDigit(c))
                                .toList();

                                //.forEach( (c) -> {
                                //    System.out.println(c);
                                //    //System.out.println(c.getClass());
                                //});
                                //.mapToInt( i -> (int) i)
                                //.boxed().collect(Collectors.toList());

                                //.map( c -> (int) c)//todo: something goes wrong here!
                                //.toList();


            //integerList.forEach(System.out::println);


                            //.mapToInt(i -> (int) i)
                            //.collect(Collectors.toList());

            charactersListdigits.forEach( i -> {
                System.out.println(i);
                System.out.println(i.getClass());
            });

            int count = charactersListdigits.size();

            switch(count) {
                case 0 -> System.out.println();//continue;
            }


        //}



    }








}
