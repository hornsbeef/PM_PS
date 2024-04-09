package at.ac.uibk.pm.g03.csbb5525.exercisetesting.ytjonaskeil.lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args){

        int num1 = 4;
        int num2 = 2;

        Calculator adder = (a, b) -> a + b;
        System.out.println("add: " + rechenOperation(adder, num1, num2));

        System.out.println( rechenOperation((Calculator) (a, b) -> a - b , num1, num2 ));
        System.out.println( rechenOperation((Calculator) (a, b)-> a*b , num1 , num2 ));
        System.out.println( rechenOperation( (Calculator) (a, b) ->
             switch (b) {
                case 0 -> 0;
                default -> a / b;
            },num1, num2));


    }

    public static int rechenOperation(Calculator calculator, int numb1, int numb2){
        return calculator.calculate(numb1, numb2);

    }


}


class MainTest{

    @Test
    public void testAdd(){
        Calculator adder = (a, b) -> a + b;
        assertEquals(4, Main.rechenOperation((Calculator) (a, b) -> a + b , 2, 2 ));


    }


}




//System.out.println(addierer.rechnen(zahl1, zahl2));
//Rechner addierer = new Rechner(){
//    @Override
//    public int rechnen(int zahl1, int zahl2) {
//        return zahl1 + zahl2;
//    }
//};
//System.out.println(addierer.rechnen(zahl1, zahl2));