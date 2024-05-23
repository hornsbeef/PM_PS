package at.ac.uibk.pm.g03.csbb5525.s07.e01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.ZoneOffset.UTC;
import static java.time.temporal.ChronoUnit.YEARS;
import static java.time.temporal.TemporalAdjusters.firstInMonth;

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
        BigDecimal netPriceNum = new BigDecimal(netPrice);
        LocalDate releaseDate = LocalDate.of(releaseYear, 1, 1).with(firstInMonth(FRIDAY));
        ZonedDateTime lastUpdate = ZonedDateTime.now().minusDays(updatedDaysAgo);
        return new Product(name, netPriceNum, releaseDate, lastUpdate);
    }

    public BigDecimal getGrossPrice() {
        //BruttoPreis -> +13% to 2 decimal places
        return netPrice.multiply(new BigDecimal("1.13")).setScale(2, RoundingMode.HALF_UP);
    }

    public String getFormattedReleaseDate() {

        long yearsBetween = YEARS.between(releaseDate, LocalDate.now());
        if (yearsBetween >= 2) {
            return yearsBetween +" years ago";
        }
        return releaseDate.toString();


    }

    public LocalDateTime getLastUpdateUTC() {
        return lastUpdate.withZoneSameInstant(UTC).toLocalDateTime();
    }
}
