package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputeAverageTest{


    @Test
    public void testAverage1(){
        double expected = 2.5;
        double actual = ComputeAverage.computeAVerage(List.of(1,2,3,4));

        assertEquals(expected, actual);

    }
    @Test
    public void testAverage2(){
        double expected = 0;
        double actual = ComputeAverage.computeAVerage(List.of(0));

        assertEquals(expected, actual);

    }

    
}
