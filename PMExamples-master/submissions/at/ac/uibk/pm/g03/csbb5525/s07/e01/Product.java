package at.ac.uibk.pm.g03.csbb5525.s07.e01;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Product {

    private final String name;
    private final BigDecimal netPrice;
    private final LocalDate releaseDate;
    private final ZonedDateTime lastUpdate;

    private Product(String name, BigDecimal netPrice, LocalDate releaseDate, ZonedDateTime lastUpdate) {
        this.name = name;
        this.netPrice = netPrice;
        this.releaseDate = releaseDate;
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public ZonedDateTime getLastUpdate() {
        return lastUpdate;
    }

    public static Product create(String name, String netPrice, int releaseYear, int updatedDaysAgo) {
        // TODO
        //throw new UnsupportedOperationException("Not yet implemented");





        Product product = new Product()

    }

    public BigDecimal getGrossPrice() {
        // TODO
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getFormattedReleaseDate() {
        // TODO
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public LocalDateTime getLastUpdateUTC() {
        // TODO
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
