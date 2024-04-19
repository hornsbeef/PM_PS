package at.ac.uibk.pm.g03.csbb5525.exercisetesting.artemisexperiment;

public class Artemisexperiment1 {
    //package artemis;

        public static void main(String[] args) {
            //int[] array = {1,2,3,4};
            int operand = 2;
            char operation = '+';
            //
            int[] data = { 1, 4, 7, 8, 25 };
            int[] array2 = calc4All(data, operation, operand);

            if(array2 != null){
                System.out.println(arrayToString(array2));
            }else if (array2 == null){
                System.out.println("null");
            }

            //int[] data = null;
            //System.out.println(arrayToString(calc4All(data, '+', 2)));
            //System.out.println(arrayToString(calc4All(data, '-', 0)));
            //System.out.println(arrayToString(calc4All(data, '*', 5)));
            //System.out.println(arrayToString(calc4All(data, '/', 0)));
            //System.out.println(arrayToString(calc4All(data, '%', 3)));
            //System.out.println(arrayToString(calc4All(data, 'p', 1)));
            //System.out.println(arrayToString(calc4All(data, '*', -1)));


        }

        public static int[] calc4All(int[] data, char operation, int operand) {
            // Implement your solution here
            if(data.length == 0 || data == null){
                return null;
            }


            return switch (operation) {
                case ('+') -> plusFunct(data, operand);
                case ('-') -> minusFunct(data, operand);
                case ('*') -> multiplicationFunct(data, operand);
                case ('/') -> divisionFunct(data, operand);
                case ('%') -> modoloFunct(data, operand);
                default -> null;
            };

        }

        private static int[] plusFunct(int[] data, int operand){

            int[] newdata = new int[data.length];


            for(int i = 0; i < data.length; i++){
                //todo: think about exceptions here
                newdata[i] = data[i] + operand;
            }
            return newdata;
        }
        private static int[] minusFunct(int[] data, int operand){

            int[] newdata = new int[data.length];


            for(int i = 0; i < data.length; i++){
                //todo: think about exceptions here
                newdata[i] = data[i] - operand;
            }
            return newdata;
        }
        private static int[] multiplicationFunct(int[] data, int operand){

            int[] newdata = new int[data.length];


            for(int i = 0; i < data.length; i++){
                //todo: think about exceptions here
                newdata[i] = data[i] * operand;
            }
            return newdata;
        }
        private static int[] divisionFunct(int[] data, int operand){

            int[] newdata = new int[data.length];


            for(int i = 0; i < data.length; i++){
                //todo: think about exceptions here
                newdata[i] = data[i] / operand;
            }
            return newdata;
        }
        private static int[] modoloFunct(int[] data, int operand){

            int[] newdata = new int[data.length];


            for(int i = 0; i < data.length; i++){
                //todo: think about exceptions here
                newdata[i] = data[i] % operand;
            }
            return newdata;
        }


        public static String arrayToString(int[] array) {
            String out = "{";
            for (int i = 0; i < array.length -1; i++) {
                out += array[i] + ", ";
            }
            return out + array[array.length - 1] + "}";
        }
    }



