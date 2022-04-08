package com.example.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class StockPrice extends Stock {

    private Double price;

    @JsonCreator
    public StockPrice(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("price") Double price
    ) {
        super(id, name);
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StockPrice that = (StockPrice) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "price=" + price +
                "stock=" + super.toString() +
                '}';
    }
}
