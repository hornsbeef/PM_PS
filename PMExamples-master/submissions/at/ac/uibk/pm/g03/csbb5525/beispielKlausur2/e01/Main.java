package at.ac.uibk.pm.g03.csbb5525.beispielKlausur2.e01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> stringList = List.of("one", "two", "three");


        printProducts(stringList);


    }

    private static void printProducts(List<String> stringList) {
        Iterator iterator = stringList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
