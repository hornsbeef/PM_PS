package at.ac.uibk.pm.lambdas.streams;

import java.math.BigDecimal;

/**
 * Class provides means for storing information about products.
 */
public class Product {
    private final int productID;
    private final BigDecimal price;
    private final String name;

    /**
     * Constructs product object
     *
     * @param productID    unique identifier of the product.
     * @param price        price of the product.
     * @param name         name of the product.
     */
    public Product(int productID, BigDecimal price, String name) {
        this.productID = productID;
        this.price = price;
        this.name = name;
    }

    /**
     * {@return the product id}
     */
    public int getProductID() {
        return productID;
    }

    /**
     * {@return the price of the product}
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * {@return the product name}
     */
    public String getName() {
        return name;
    }

}