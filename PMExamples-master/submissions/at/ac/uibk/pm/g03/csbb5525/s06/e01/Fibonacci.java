package at.ac.uibk.pm.g03.csbb5525.s06.e01;

public class Fibonacci {

    public static long fibonacci(int n) throws IllegalArgumentException {
        if (n < 0) {
            IllegalArgumentException illArg = new IllegalArgumentException();
            throw illArg ;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        //System.out.println(fibonacci(99));
    }
}
