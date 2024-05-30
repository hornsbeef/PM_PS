package at.ac.uibk.pm.g03.csbb5525.s08.e03;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exercise3 {

    public static <T extends Comparable<T>> T findMaxArray(T[] input){
        List<T> list = Arrays.asList(input);
        return Collections.max(list);
    }
    public static <T extends Comparable<T>> T findMaxCollection(Collection<T> input){
        List<T> list = input.stream().toList();
        return Collections.max(list);
    }





}
