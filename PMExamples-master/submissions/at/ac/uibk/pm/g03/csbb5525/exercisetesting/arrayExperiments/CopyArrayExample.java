package at.ac.uibk.pm.g03.csbb5525.exercisetesting.arrayExperiments;

import java.util.Arrays;

class QuickTestClass{
    private int x = 12;

    @Override
    public String toString() {
        return "QuickTestClass{" +
                "x=" + x +
                '}';
    }


    public void changeOthersX(QuickTestClass qtc, int newX){
        qtc.x = newX;
    }


}



public class CopyArrayExample {




    public static void main(String[] args) {

        //int[][] original = { {1, 2, 3}, {4, 5, 6} };  //works the same
        int[][] original = new int[2][];
        original[0] = new int[]{1,2,3};
        original[1] = new int[]{4,5,6};


        // Kopieren des äußeren Arrays mit clone()
        int[][] copy = original.clone();

        int[][] copy1 = new int[original.length][];
        System.arraycopy(original, 0, copy1, 0, original.length);

        int[][] copy2 = Arrays.copyOf(original, original.length);


        printArrays(original, copy, copy1, copy2);


        //int[][] original = { {1, 2, 3}, {4, 5, 6} };  //works the same
        Integer[][] originalInt = new Integer[2][];
        originalInt[0] = new Integer[]{1,2,3};
        originalInt[1] = new Integer[]{4,5,6};


        // Kopieren des äußeren Arrays mit clone()
        Integer[][] copyInt = originalInt.clone();

        Integer[][] copy1Integer = new Integer[original.length][];
        System.arraycopy(original, 0, copy1, 0, original.length);

        Integer[][] copy2Integer = Arrays.copyOf(originalInt, originalInt.length);

        System.out.println("Orig");
        printIntegerArray(originalInt);

        System.out.println("Copy: - CLONE()");
        printIntegerArray(copyInt);

        System.out.println("Copy1: SYSTEM.ARRAYCOPY()");
        printIntegerArray(copy1Integer);

        System.out.println("Copy2: Arrays.copyOf()");
        printIntegerArray(copy2Integer);


        char[] letters = {'a', 'b', 'c'};

        letters[0] = 20000;

        for (int it : letters){
            System.out.println(it);
        }


        QuickTestClass qtc1 = new QuickTestClass();
        QuickTestClass qtc2 = new QuickTestClass();

        qtc2.changeOthersX(qtc1, 99);

        System.out.println(qtc1.toString());
        System.out.println(qtc2.toString());





    }

    private static void printArrays(int[][] original, int[][] copy, int[][] copy1, int[][] copy2) {
        // Ausgabe der Arrays
        System.out.println("Original:");
        printArray(original);

        System.out.println("Copy:");
        printArray(copy);

        System.out.println("Copy1:");
        printArray(copy1);

        System.out.println("Copy2:");
        printArray(copy2);
    }

    // Hilfsmethode zur Ausgabe eines mehrdimensionalen Arrays
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printIntegerArray(Integer[][] arr){
        for (Integer[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }


}
