package at.ac.uibk.pm.g03.csbb5525.exercisetesting.jUnit5_AssertionTesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTestingClassTest {


    @Test
    @DisplayName("myTest")
    public void myTest(){
        double actual = 1d / 3d;
        double expected = 0.333;
        assertAll(
                //() -> assertEquals(expected, actual, "this probably fails"),
                //() -> assertEquals(expected, actual, 0.0001, "this fails as well"),
                () -> assertEquals(expected, actual, 0.001, "this works")
        );
    }

    @Test
    void arrayTest(){
        int[] one = {1,2,3,4};
        int[] two = {1,2,3,4};
        assertArrayEquals(one, two);
    }

    @Test
    void assertSameTest(){
        Integer one = 130;
        //Integer two = 130;
        Integer two = one;
        assertSame(one, two);
    }

    @Test
    void assertThatTest(){
        Integer one = 130;
        //Integer two = 130;
        Integer two = one;
        assertSame(one, two);
    }

    @Test
    void assertThrowsTest(){
        assertThrows(ArithmeticException.class, ()->{int x = 1/0;} );
    }





}


