package at.ac.uibk.pm.g03.csbb5525.exercisetesting.wrappers;

public class WrapperClass {

    public static void methodA(Long l){
        System.out.println("Long");
    }

    public static void methodB(Number n){
        System.out.println("Number");
    }


    public static void main(String[] args) {

        Integer i = 5;
        Long l = 5L;

        methodA(l + 1);
        /*
        The Long object l is unboxed to a long for the arithmetic operation.
        The 1 is promoted to a long before the addition.
        The result of the addition is a long.
        This long result is then autoboxed back into a Long object to match the method parameter type.
         */

        methodB(5);

    }
}
