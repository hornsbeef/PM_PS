package at.ac.uibk.pm.g03.csbb5525.s09.e02;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Order> list = Stream.of(
                new Order(12, "Andreas", 12.25, new Date(1992, 12, 01)),
                new Order(10, "Andreas", 12, new Date(1256, 12, 5)),
                new Order(10, "Johannes", 12, new Date(2056, 12, 5))
        ).toList();

        OrderProcessor.filterOrderByCustomer(list, "Andreas").forEach(System.out::println);
    }


}
