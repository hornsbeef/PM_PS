package at.ac.uibk.pm.g03.csbb5525.s09.e02;


import java.util.Date;

public class Order implements Comparable<Order>{

    private final int id;
    private final String customer;
    private final double sum;
    private final Date date;    //explicitly Date in requirements - would have otherwise used LocalDate

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
