package at.ac.uibk.pm.g03.csbb5525.exercisetesting._uglyTesting;

import java.util.*;

public class UglyTesting1 implements Iterable<String>{

    List<String> list = new ArrayList<>(List.of("a", "b", "c"));


    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {

        UglyTesting1 a = new UglyTesting1();
        Iterator<String> iterator =  a.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
