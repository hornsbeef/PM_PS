package at.ac.uibk.pm.g03.csbb5525.exercisetesting.artemisexperiment_exercise.one;

//package artemis;

public class Main {
    public static void main(String[] args) {
        int[] data = { 1, 4, 7, 8, 25 };
        //int[] data = null;
        System.out.println(arrayToString(calc4All(data, '+', 2)));
        System.out.println(arrayToString(calc4All(data, '-', 0)));
        System.out.println(arrayToString(calc4All(data, '*', 5)));
        System.out.println(arrayToString(calc4All(data, '/', 0)));
        System.out.println(arrayToString(calc4All(data, '%', 3)));
        System.out.println(arrayToString(calc4All(data, 'p', 1)));
        System.out.println(arrayToString(calc4All(data, '*', -1)));
    }

    public static int[] calc4All(int[] data, char operation, int operand) {
        // Implement your solution here
        if(data == null || data.length ==0){
            return null;
        }
        if( operation != '+' && operation != '-'&& operation != '*' && operation != '/' && operation != '%'){
            return null;
        }


        int[] returndata = data.clone();


        return switch (operation){
            case ('+') -> plus(returndata, operand);
            case '%' ->  {
                if(operand == 0){
                    yield null;
                }
                else{
                    yield modo(returndata, operand);
                }
            }

            case '*' -> mal(returndata, operand);


            case '-' -> minus(returndata, operand);
            case '/' -> {
                if(operand ==0){
                    yield null;
                }else {
                    yield div(returndata, operand);
                }
            }
            default -> returndata;
        };

    }

    public static int[] plus(int[] returndata, int operand){
        for (int i = 0; i < returndata.length; i++) {
            returndata[i] = returndata[i] + operand;
        }
        return returndata;
    }
    public static int[] minus(int[] returndata, int operand){
        for (int i = 0; i < returndata.length; i++) {
            returndata[i] = returndata[i] - operand;
        }
        return returndata;
    }
    public static int[] mal(int[] returndata, int operand){
        for (int i = 0; i < returndata.length; i++) {
            returndata[i] = returndata[i] * operand;
        }
        return returndata;
    }

    public static int[] modo(int[] returndata, int operand){
        for (int i = 0; i < returndata.length; i++) {
            returndata[i] = returndata[i] % operand;
        }
        return returndata;
    }
    public static int[] div(int[] returndata, int operand){
        for (int i = 0; i < returndata.length; i++) {
            returndata[i] = returndata[i] / operand;
        }
        return returndata;
    }



    public static String arrayToString(int[] array) {
        if(array == null){
            return "null";
        }else{
            String out = "{";
            for (int i = 0; i < array.length -1; i++) {
                out += array[i] + ", ";
            }
            return out + array[array.length - 1] + "}";
        }


    }
}


