package at.ac.uibk.pm.g03.csbb5525.exercisetesting.jUnit5_AssertionTesting;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class JUnit_xyz {

    @Test
    public void mytestMethod(){
        assertTrue(true);
    }

    @Test
    public void doubleTest(){
        assertEquals(1.1, 1.2, 0.1);
    }


    @Test
    public void arrayOutBound(){
        int[] ints = new int[3];

        Executable when = () -> ints[4] = 0;

        assertThrows(IndexOutOfBoundsException.class, when);
    }


    @ParameterizedTest(name = "This is a Test {0} => true")
    @ValueSource(ints = {1, 2, 3})
    public void test(int x){
        assertTrue(true, String.valueOf(x));
    }


}
