package at.ac.uibk.pm.g03.csbb5525.s09.e01;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        // ? what to do with a null product?
        if(o1 == null || o2 == null){
            throw new NullPointerException("Null-Product cannot be compared");
        }

        return o1.getPrice().compareTo(o2.getPrice());
    }
}
