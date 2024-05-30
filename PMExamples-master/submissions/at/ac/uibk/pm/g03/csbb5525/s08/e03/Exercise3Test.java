package at.ac.uibk.pm.g03.csbb5525.s08.e03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise3Test {

    @Test
    public void intArrayTest(){
        Integer[] intArray = {1,2,3,4,5};
        Integer actual = Exercise3.findMaxArray(intArray);
        assertEquals(5, actual);
    }

    @Test
    public void stringArrayTest(){
        String[] stringArray = {"apple", "xylophone", "orange", "pear"};
        String actual = Exercise3.findMaxArray(stringArray);
        assertEquals("xylophone", actual);
    }

    @Test
    public void intCollectionTest(){
        Collection<Integer> integerCollection = Arrays.asList(1, 2, 3, 4, 5);
        Integer actual = Exercise3.findMaxCollection(integerCollection);
        assertEquals(5, actual);
    }

    @Test
    public void stringCollectionTest(){
        Collection<String> stringCollection = Arrays.asList("apple", "xylophone", "orange", "pear");
        String actual = Exercise3.findMaxCollection(stringCollection);
        assertEquals("xylophone", actual);
    }

}
