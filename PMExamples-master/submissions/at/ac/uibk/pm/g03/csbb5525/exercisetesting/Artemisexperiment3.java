package at.ac.uibk.pm.g03.csbb5525.exercisetesting;

//package artemis;

public class Artemisexperiment3 {
    public static void main(String[] args) {
        int[][] matrix1 = { { 4, 5, 7 }, { 2, 8, 1 }, { 9, 6, 3 } };
        int[][] matrix2 = { { 1, 2, 4 }, { 5, 7, 3} , { 6, 8, 9 } };
        int[][] matrix3 = { { 1, 3, 6 }, { 5, 5, 9 }, { 7, 8, 4 } };

        System.out.println(isValidNumberMatrix(matrix1));
        System.out.println(isValidNumberMatrix(matrix2));
        System.out.println(isValidNumberMatrix(matrix3));


    }

    public static boolean isValidNumberMatrix(int[][] numbers) {
        // Implement your solution here
        if(numbers == null){
            return false;
        }
        if(numbers.length != 3){
            return false;
        }



        //flags:
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean nine = false;
        boolean zero = false;
        //implement all numbers


        for(int i = 0; i < numbers.length; i++){
            if(numbers[i].length != 3){
                return false;
            }

            for(int j = 0; j < numbers[i].length; j++){
                if(!isValidNumber(numbers[i][j])){
                    return false;
                }
                if(one == false && numbers[i][j] == 1){
                    one = true;
                }else if(two == false && numbers[i][j] == 2){
                    two = true;
                }else if(three == false && numbers[i][j] == 3){
                    three = true;
                }else if(four == false && numbers[i][j] == 4){
                    four = true;
                }else if(five == false && numbers[i][j] == 5){
                    five = true;
                }else if(six == false && numbers[i][j] == 6){
                    six = true;
                }else if(seven == false && numbers[i][j] == 7){
                    seven = true;
                }else if(eight == false && numbers[i][j] == 8){
                    eight = true;
                }else if(nine == false && numbers[i][j] == 9){
                    nine = true;
                }else if(zero == false && numbers[i][j] == 0){
                    zero = true;
                }else{
                    return false;
                }

            }
        }

        return true;
    }
    public static boolean isValidNumber(int number){
        if(1 <= number && number <= 9){
            return true;
        }
        return false;

    }
}

