package at.ac.uibk.pm.g03.csbb5525.s09.e01;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Product p1 = new Product("Aloe", 11, BigDecimal.valueOf(19.22), 1);
        Product p2 = new Product("Sugar", 5, BigDecimal.valueOf(1.22), 1);
        Product p3 = new Product("Something", 99, BigDecimal.valueOf(0.22), 100);

        Stream.of(p1, p2, p3).forEach(warehouse::add);

        warehouse.print(warehouse.sort(new NameComparator()));
        System.out.println("-".repeat(20));
        warehouse.print(warehouse.sort(new PriceComparator()));
        System.out.println("-".repeat(20));
        warehouse.print(warehouse.sort(new AvailabilityComparator()));
        System.out.println("-".repeat(20));


        warehouse.print(warehouse.sort((it1, it2) -> {
                                           //todo:
                                           // sort by availability then by name;
                                           int availabilityCompare = -Integer.compare(it1.getAvailability(), it2.getAvailability());
                                           if (availabilityCompare != 0) {
                                               return availabilityCompare;
                                           } else {
                                               return it1.getName()
                                                         .compareTo(it2.getName());
                                           }

                                       }
        ));

        System.out.println("-".repeat(20));
        System.out.println("Should yield the same result:");
        warehouse.print(warehouse.sort((new AvailabilityComparator()).thenComparing(new NameComparator())));






    }
}
