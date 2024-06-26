package at.ac.uibk.pm.g03.csbb5525.test3.e01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    public static <T extends Comparable<? super T>> List<T> mergeAndSortLists(List<T> list1, List<T> list2){

        List<T> temp = new ArrayList<>(list1);
        temp.addAll(list2);
        Collections.sort(temp);
        return temp;
    }

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("ba");
        l1.add("ca");
        l1.add("aa");

        List<String> l2 = new ArrayList<>();
        l1.add("ba");
        l1.add("ca");
        l1.add("aa");

        System.out.println(mergeAndSortLists(l1, l2));
    }

}
