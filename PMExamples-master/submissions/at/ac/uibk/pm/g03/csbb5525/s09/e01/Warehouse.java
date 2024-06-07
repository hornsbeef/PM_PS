package at.ac.uibk.pm.g03.csbb5525.s09.e01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Warehouse {

    private final List<Product> list;

    public Warehouse(){
        this.list = new ArrayList<>(); //maybe better to use a Set, so no duplicates exist.
    }

    public void add(Product product){
        if(product == null) throw new NullPointerException("Cannot add Null-Product");
        list.add(product);
    }

    public List<Product> sort(Comparator<Product> comparator){
        return this.list.stream().sorted(comparator).toList(); //? better way to write this?
    }

    public void print(List<Product> printList){
        printList.forEach(System.out::println);
    }

}
