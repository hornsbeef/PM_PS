package at.ac.uibk.pm.g03.csbb5525.s09.e02;

import java.util.List;

public class OrderProcessor {

    public static List<Order> filterOrderByCustomer(List<Order> orders, String customerName){
        return orders.stream().filter(it -> it.getCustomer().equals(customerName)).toList();
    }

    public static double calculateTotalRevenue(List<Order> orders){
        return orders.stream().<Double>mapMulti((order, downstream)-> downstream.accept(order.getSum())).reduce(0.0, Double::sum);
    }




}
