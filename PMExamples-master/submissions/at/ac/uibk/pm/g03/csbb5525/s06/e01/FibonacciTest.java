package at.ac.uibk.pm.g03.csbb5525.s06.e01;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    @DisplayName("fibonacci(0)-Test")
    public void fibonacci0Test() {
        long actual = Fibonacci.fibonacci(0);
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("fibonacci(1)-Test")
    public void fibonacci1Test() {
        long actual = Fibonacci.fibonacci(1);
        assertEquals(1, actual);
    }

    @ParameterizedTest(name = "fibonacci({0}) - Test")
    @ValueSource(ints = {4,5,6,7}) //99,64526714})
    public void fibonacciNTest(int n) {
        long actual = Fibonacci.fibonacci(n);
        long expected = Fibonacci.fibonacci(n-1) + Fibonacci.fibonacci(n-2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "fibonacci(-{0}) - Test")
    @ValueSource(ints = {4,5,6,7})
    public void fibonacciNegativeTest(int n){
        Executable when = () -> Fibonacci.fibonacci(-n);
        assertThrows(IllegalArgumentException.class, when);
    }

}
