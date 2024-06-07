package at.ac.uibk.pm.g03.csbb5525.s09.e01;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final int id;
    private BigDecimal price;   //might change
    private int availability;   //might change

    public Product(String name, int id, BigDecimal price, int availability) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }


    @Override
    public String toString() {
        return "Product{name='%s', id=%d, price=%s, availability=%d}".formatted(name, id, price, availability);
    }
}
