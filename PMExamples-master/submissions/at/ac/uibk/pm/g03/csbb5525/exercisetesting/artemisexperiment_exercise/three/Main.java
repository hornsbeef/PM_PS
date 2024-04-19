package at.ac.uibk.pm.g03.csbb5525.exercisetesting.artemisexperiment_exercise.three;

//package artemis;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = { { 4, 5, 7 }, { 2, 8, 1 }, { 9, 6, 3 } };
        int[][] matrix2 = { { 1, 2, 4 }, { 5, 7, 3} , { 6, 8, 9 } };
        int[][] matrix3 = { { 1, 3, 6 }, { 5, 5, 9 }, { 7, 8, 4 } };

        System.out.println(isValidNumberMatrix(matrix1));
        System.out.println(isValidNumberMatrix(matrix2));
        System.out.println(isValidNumberMatrix(matrix3));
    }

    public static boolean isValidNumberMatrix(int[][] numbers) {
        if(numbers == null || (numbers.length != 3)){
            return false;
        }
        if(numbers[0].length !=3 || numbers[1].length !=3 || numbers[2].length != 3){
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(numbers[i][j] < 1 || numbers[i][j]> 9){
                    return false;
                }
            }
        }

        boolean[] numberHasBeenSeen = new boolean[9];
        Arrays.fill(numberHasBeenSeen, false);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(numberHasBeenSeen[numbers[i][j]-1] == true){
                    return false;
                }
                numberHasBeenSeen[numbers[i][j]-1] = true;
            }
        }
        return true;

    }
}

