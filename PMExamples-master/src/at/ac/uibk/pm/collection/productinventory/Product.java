package at.ac.uibk.pm.collection.productinventory;

/**
 * Class provides means for storing information about products.
 */
public class Product implements Comparable<Product> {
    private int productID;
    private double price;
    private String name;
    private String description;
    private String manufacturer;
    private int stock;

    /**
     * Constructs product object
     *
     * @param productID    unique identifier of the product.
     * @param price        price of the product.
     * @param name         name of the product.
     * @param manufacturer manufacturer of the product.
     * @param description  description of the product.
     * @param stock        number of products in stock.
     */
    public Product(int productID, double price, String name,
                   String manufacturer,
                   String description, int stock) {
        this.productID = productID;
        this.price = price;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.stock = stock;
    }

    /**
     * {@return the manufacturer of the product}
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the product.
     *
     * @param manufacturer the manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * {@return the product id}
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the product id.
     *
     * @param productID the product id
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * {@return the price of the product}
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * {@return the product name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@return a description of the product}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a description of the product.
     *
     * @param description a description of the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@return the number of the products in stock}
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the number of the products in stock.
     *
     * @param stock the number of the products in stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("[%s by %s]: %s (id: %d, %.2f)", name,
                manufacturer, description,
                productID, price);
    }

    /**
     * Returns whether given product is in stock.
     *
     * @return boolean
     */
    public boolean isInStock() {
        return this.stock > 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product otherProduct)) {
            return false;
        }
        return productID == otherProduct.productID;
    }

    @Override
    public int hashCode() {
        return productID;

        /*
         * Hash code according to the rules.
         * Note that the documentation of Integer.hashCode states that the
         * hash code of an int is
         * the int itself.
         */
        // return Integer.hashCode(productID);


        /*
         * poor solution all products stored in same bucket (overflow list
         * searched for matching
         * product using equals)
         */

        // return 1;

        /*
         * poor solution same product is hashed to different bucket every
         * time hashcode is
         * called, hence, cannot be found
         */
        // return (int) (Math.random() * Integer.MAX_VALUE);
    }

    /**
     * Returns whether current object is smaller than other Product
     *
     * @param other Product instance
     * @return int - result of comparison
     */
    @Override
    public int compareTo(Product other) {
        // sort by id
        // return Integer.compare(this.productID, other.productID);

        // sort by name
        return this.name.compareTo(other.name);
    }

}
