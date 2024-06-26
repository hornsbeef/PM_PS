package at.ac.uibk.pm.g03.csbb5525.s08.e02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedTriple<T extends Comparable<T>> {

    private final T first;
    private final T second;
    private final T third;

    public SortedTriple(T a, T b, T c){
        List<T> list = Arrays.asList(a,b,c);
        //List<T> list = new ArrayList<>(List.of(a,b,c)); //BESSER? nicht unbedingt - nur anders

        Collections.sort(list);
        this.first = list.get(0);
        this.second = list.get(1);
        this.third = list.get(2);
    }

    // maybe could use .clone() or new T(first) for defensive copy, if all T implement such features.
    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public T getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "SortedTriple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
