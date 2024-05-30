package at.ac.uibk.pm.g03.csbb5525.s08.e04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPrinter {

    public static void printNumberLists(List<? extends Number> list){
        for (Number it: list){
            System.out.println(it);
        }
    }

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        list.add(1.2);
        list.add(1L);
        list.add(12);
        list.add(new BigDecimal("99"));

        printNumberLists(list);

        List<String> stringList = Arrays.asList("apple", "xylophone", "orange", "pear");
        //printNumberLists(stringList);     //compiler does not like this!




    }


}
