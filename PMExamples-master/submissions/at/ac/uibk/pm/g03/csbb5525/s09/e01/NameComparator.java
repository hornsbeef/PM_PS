package at.ac.uibk.pm.g03.csbb5525.s09.e01;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {

        /*TODO: how to handle:
        Throws:
    NullPointerException - if an argument is null and this comparator does not permit null arguments
    ClassCastException - if the arguments' types prevent them from being compared by this comparator.
         */

        // ? what to do with a null product?
        if(o1 == null || o2 == null){
            throw new NullPointerException("Null-Product cannot be compared");
        }

        return o1.getName().compareTo(o2.getName());

    }
}
