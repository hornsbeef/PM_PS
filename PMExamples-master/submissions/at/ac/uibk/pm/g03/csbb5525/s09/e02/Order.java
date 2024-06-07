package at.ac.uibk.pm.g03.csbb5525.s09.e02;


import java.util.Date;

public class Order implements Comparable<Order>{

    private int id;
    private String customer;
    private double sum;
    private Date date;

    public Order(int id, String customer, double sum, Date date) {
        this.id = id;
        this.customer = customer;
        this.sum = sum;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getCustomer() {
        return customer;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public int compareTo(Order o) {
        return date.compareTo(o.getDate());
    }

    @Override
    public String toString() {
        return "Order{id=%d, customer='%s', sum=%s, date=%s}".formatted(id, customer, sum, date);
    }
}
