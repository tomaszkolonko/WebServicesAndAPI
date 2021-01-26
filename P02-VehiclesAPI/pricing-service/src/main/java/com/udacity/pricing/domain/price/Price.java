package com.udacity.pricing.domain.price;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents the price of a given vehicle, including currency.
 */
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    public Price() {
    }

    public Price(String currency, BigDecimal price, Long vehicleId) {
        this.currency = currency;
        this.price = price;
        this.vehicleId = vehicleId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(currency, price1.currency) &&
                Objects.equals(price, price1.price) &&
                Objects.equals(vehicleId, price1.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, price, vehicleId);
    }
}
