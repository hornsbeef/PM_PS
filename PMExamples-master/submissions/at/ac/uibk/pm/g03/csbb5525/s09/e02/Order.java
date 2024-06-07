package at.ac.uibk.pm.g03.csbb5525.s09.e02;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Order implements Comparable<Order>{

    private int id;
    private String customer;
    private double sum;
    private Date date;

    @Override
    public int compareTo(@NotNull Order o) {
        return 0;
    }
}
