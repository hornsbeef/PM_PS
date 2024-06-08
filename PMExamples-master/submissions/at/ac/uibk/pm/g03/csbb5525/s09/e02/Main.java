package at.ac.uibk.pm.g03.csbb5525.s09.e02;


import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Order> list = Stream.of(
                new Order(12, "Andreas", 12.25, new Date(90, 0, 01)),
                new Order(10, "Andreas", 12, new Date(2, 0, 5)),
                new Order(11, "ZZzzZ", 99, new Date(1, 0, 5)),
                new Order(13, "Johannes", 1, new Date(100, 0, 5)),
                null
        ).toList();
        //list = null;

        System.out.println("filterOrderByCustomer");
        OrderProcessor.filterOrderByCustomer(list, "Andreas").forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.filterOrderByCustomer(list, null).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.filterOrderByCustomer(Collections.emptyList(), null).forEach(System.out::println);
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));

        System.out.println("calculateTotalRevenue");
        System.out.println(OrderProcessor.calculateTotalRevenue(list));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.calculateTotalRevenue(Collections.emptyList()));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.calculateTotalRevenue(null));
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));

        System.out.println("findMostExpensiveOrder");
        System.out.println(OrderProcessor.findMostExpensiveOrder(list));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.findMostExpensiveOrder(Collections.emptyList()));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.findMostExpensiveOrder(null));
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));

        System.out.println("findMostExpensiveOrderByCustomer");
        System.out.println(OrderProcessor.findMostExpensiveOrderByCustomer(list, "Andreas"));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.findMostExpensiveOrderByCustomer(null, "Andreas"));
        System.out.println("-".repeat(23));
        System.out.println(OrderProcessor.findMostExpensiveOrderByCustomer(Collections.emptyList(), null));
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));


        System.out.println("sortOrder");
        OrderProcessor.sortOrders(list).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.sortOrders(null).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.sortOrders(Collections.emptyList()).forEach(System.out::println);
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));

        System.out.println("sortOrdersByAmount");
        OrderProcessor.sortOrdersByAmount(list).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.sortOrdersByAmount(null).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.sortOrdersByAmount(Collections.emptyList()).forEach(System.out::println);
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));

        System.out.println("customersWithOrders");
        OrderProcessor.customersWithOrders(list).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.customersWithOrders(null).forEach(System.out::println);
        System.out.println("-".repeat(23));
        OrderProcessor.customersWithOrders(Collections.emptyList()).forEach(System.out::println);
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));


        System.out.println("customersWithOrdersMoreExpensiveThan");
        var newList = OrderProcessor.customersWithOrdersMoreExpensiveThan(12.00, list);
        newList.add("modified the returnded List");
        newList.forEach(System.out::println);
        System.out.println("-".repeat(23));
        newList = OrderProcessor.customersWithOrdersMoreExpensiveThan(12.00, null);
        newList.add("modified the returnded List");
        newList.forEach(System.out::println);
        System.out.println("-".repeat(23));
        newList = OrderProcessor.customersWithOrdersMoreExpensiveThan(12.00, Collections.emptyList());
        newList.add("modified the returnded List");
        newList.forEach(System.out::println);
        System.out.println("-".repeat(23));
        System.out.println("-".repeat(23));




    }


}
