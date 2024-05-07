package at.ac.uibk.pm.g03.csbb5525.s05.e01;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Main {
    public static void main(String[] args) {
        RandomWrapper r = new RandomWrapper();
        IntStream.range(1, 99).forEach(it -> r.random10Generator());
        r.print3Arrays();


        System.out.println("\n\n");


        RandomWrapper nextGen = new RandomWrapper();
        IntStream.range(1, 99).forEach(it -> nextGen.random10Generator());
        nextGen.print3Arrays();


        System.out.println("\n\n");


        RandomWrapper r2 = new RandomWrapper();
        r2.lessRandom10Generator();
        r2.lessRandom10Generator();
        r2.print3Arrays();




    }
}


public class RandomWrapper {

    private final long[] negativeLongValues = new long[10];
    private int nlvCounter = 0;

    private final long[] positiveLongValues = new long[10];
    private int plvCounter = 0;

    private final int[] intValues = new int[10];
    private int ivCounter = 0;


    //Hinweis: Random ist etwas älter, daher empfohlen RandomGenerator zu verwenden.
    //RandomGenerator randomizer = RandomGenerator.getDefault();



    private final RandomGenerator random = new Random();


    public void random10Generator() {
        //idea?: implement exception handling if arrays are full??
        random.longs(10)
              .forEach(l -> arrayChooser(l)
              );
    }

    public void nextGenRandom10Generator() {
        LongStream.range(0, 10).forEach( it -> arrayChooser(random.nextLong()));
    }


    //Because probability -> with only long -> almost never get Integer values array populated.

    public void lessRandom10Generator() {
        LongStream.range(0, 7).forEach(it -> {
            long longItem = random.nextLong();
            arrayChooser(longItem);
        });
        LongStream.range(7, 10).forEach(it -> {
           int intItem = random.nextInt();
           arrayChooser(intItem);
        });
    }


    public void print3Arrays(){
        System.out.println("Negative long values: " +Arrays.toString(negativeLongValues));
        System.out.println("Positive long values: " + Arrays.toString(positiveLongValues));
        System.out.println("Integer values: " + Arrays.toString(intValues));
    }


    private void arrayChooser(long l) {
        if (l < Integer.MIN_VALUE && nlvCounter < 10) {
            negativeLongValues[nlvCounter] = l;
            nlvCounter++;
        } else if (l > Integer.MAX_VALUE && plvCounter < 10) {
            positiveLongValues[plvCounter] = l;
            plvCounter++;
        } else if (Integer.MIN_VALUE <= l && l <= Integer.MAX_VALUE && ivCounter < 10) {
            try {    //my first go at exception handling
                intValues[ivCounter] = Math.toIntExact(l);
                ivCounter++;
            } catch (ArithmeticException e) {
                System.out.println("Error: This should never happen\n" +
                                           "Integer.MIN_VALUE <= l <= Integer.MAX_VALUE but failed to be converted to int.");
                e.printStackTrace();
            }
        }
        else{
            //System.out.println(l + " could not be added to its corresponding Array, because it was already full.");
            //what else should I do with numbers that would be added to full arrays?
        }
    }

}

