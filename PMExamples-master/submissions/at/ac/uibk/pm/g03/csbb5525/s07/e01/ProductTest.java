package at.ac.uibk.pm.g03.csbb5525.s07.e01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    //TODO: ? implement check for getLastUpdateUTC() ?

    @Test
    public void olderProduct() {
        Product product = Product.create("Product A", "9.99", 2021, 7);
        assertAll(
                () -> assertEquals("11.29", product.getGrossPrice().toString()),
                () -> assertEquals("3 years ago", product.getFormattedReleaseDate()));
    }

    @Test
    public void newerProduct() {
        Product product = Product.create("Product B", "10.10", 2023, 7);
        assertAll(
                () -> assertEquals("11.41", product.getGrossPrice().toString()),
                () -> assertEquals("2023-01-06", product.getFormattedReleaseDate()));
    }
}