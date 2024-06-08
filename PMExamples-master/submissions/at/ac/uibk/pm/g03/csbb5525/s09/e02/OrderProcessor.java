package at.ac.uibk.pm.g03.csbb5525.s09.e02;

import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {

    public static List<Order> filterOrderByCustomer(List<Order> orders, String customerName) {
        return Optional.ofNullable(orders)
                       .filter(input -> customerName != null)
                       .map(list -> list.stream()
                                            .filter(Objects::nonNull)
                                            .filter(order -> Objects.nonNull(order.getCustomer()))
                                            .filter(it -> it.getCustomer()
                                                            .equals(customerName))
                                            .toList())
                       .orElse(List.of(new Order(1, "null-List", 0.0, new Date())));

    }

    public static double calculateTotalRevenue(List<Order> orders) {
        return Optional.ofNullable(orders)
                       .map(
                               order_list -> order_list.stream()
                                                       .filter(Objects::nonNull)

                                                       .<Double>mapMulti((order, downstream) -> downstream.accept(order.getSum()))
                                                       .reduce(0.0, Double::sum)
                       ).orElse(0.0);

    }

    public static double findMostExpensiveOrder(List<Order> orders) {
        return Optional.ofNullable(orders)
                       .map(
                               orders_list -> orders_list.stream()
                                                         .filter(order -> Objects.nonNull(order))
                                                         .<Double>mapMulti((order, downstream) -> downstream.accept(order.getSum()))
                                                         .max(Double::compare)
                                                         .orElse(0.0)
                       )
                       .orElse(0.0);
    }

    public static double findMostExpensiveOrderByCustomer(List<Order> orders, String customerName){
        //return findMostExpensiveOrder(filterOrderByCustomer(orders, customerName));

        return Optional.ofNullable(orders)
                       .filter(input -> customerName != null)
                       .map(list -> list.stream()
                                        .filter(Objects::nonNull)
                                        .filter(order -> Objects.nonNull(order.getCustomer()))
                                        .filter(it -> it.getCustomer()
                                                        .equals(customerName)
                                        )
                                        .<Double>mapMulti((order, downstream) -> downstream.accept(order.getSum()))
                                        .max(Double::compare)
                                        .orElse(0.0)
                       )
                       .orElse(0.0);

    }

    public static List<Order> sortOrders(List<Order> orders) {
        return Optional.ofNullable(orders)
                       .map(
                               it -> {
                                   if(orders.isEmpty()){
                                       return List.of(new Order(1, "empty-List", 0.0, new Date()));
                                   }
                                   return it.stream()
                                     .filter(Objects::nonNull)
                                     .sorted()
                                     .toList();
                               }
                       )
                       .orElse(List.of(new Order(1, "null-List", 0.0, new Date())));

    }

    public static List<Order> sortOrdersByAmount(List<Order> orders) {
        return Optional.ofNullable(orders)
                       .map(
                                   list -> {
                                       if(orders.isEmpty()){
                                           return List.of(new Order(1, "empty-List", 0.0, new Date()));
                                       }
                                       return list.stream().filter(Objects::nonNull)
                                           .sorted(Comparator.comparingDouble(Order::getSum))
                                           .toList();
                                   }
                           )
                       .orElse(List.of(new Order(1, "null-List", 0.0, new Date())));

        //return orders.stream().sorted(Comparator.comparingDouble(Order::getSum)).toList();
    }

    public static List<String> customersWithOrders(List<Order> orders) {
        return Optional.ofNullable(orders)
                       .map(
                               list -> {
                                   if (orders.isEmpty()) {
                                       return List.of("empty-List");
                                   }
                                   return list.stream()
                                              .filter(Objects::nonNull)
                                              .map(Order::getCustomer)
                                              .distinct()
                                              .sorted()
                                              .toList();
                               }
                       )
                       .orElse(List.of("null-list"));

    }

    public static List<String> customersWithOrdersMoreExpensiveThan(double amount, List<Order> orders){
        return  Optional.ofNullable(orders).map(
                list -> {
                    if(orders.isEmpty()){
                        return new ArrayList<String>();
                    }
                    return list.stream()
                        .filter(Objects::nonNull)
                        .filter(it -> it.getSum() > amount)
                        .map(Order::getCustomer)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toCollection(ArrayList::new));
                }
        ).orElse(new ArrayList<>());
    }




}
