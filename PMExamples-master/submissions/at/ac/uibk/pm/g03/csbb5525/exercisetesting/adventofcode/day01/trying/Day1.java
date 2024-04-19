package at.ac.uibk.pm.g03.csbb5525.exercisetesting.adventofcode.day01.trying;

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
        Then adding all the numbers from all lines together

         */


        Scanner scan = null;
        File data = new File ("submissions/at/ac/uibk/pm/g03/csbb5525/exercisetesting/adventofcode/day01/input");



        try{
            scan = new Scanner(data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


        //List<ArrayList> list = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        //while(scan.hasNext()){
            String temp = scan.nextLine();

            List<Character> characterList = temp.chars().mapToObj(c-> (char) c).toList();

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
            System.out.println(count);

            char[] charArray = new char[count];
            //charArray = List<Character>.stream(charactersListdigits).map(c -> (char)c).toArray();

        for (int i = 0; i <count; i++) {
            charArray[i] = charactersListdigits.get(i);
        }
        System.out.println(Arrays.toString(charArray));


            switch(count) {
                case 0 -> System.out.println("need to skip line -> use continue?");//continue;
                //case 1 -> list.addAll(charactersListdigits.stream().map(i->(int)i).toList());   //whut??
                default -> {
                    int first = (int) charArray[0];


                    int last = (int) charArray[count-1];
                    //int first = Integer.valueOf(charactersListdigits.get(0));   //todo: something goes wrong here.
                    //System.out.println(first);
                    //Integer last = Integer.valueOf(charactersListdigits.get(charactersListdigits.size() - 1));
                    System.out.println(first +""+ last);
                }
            }


        //}



    }








}
