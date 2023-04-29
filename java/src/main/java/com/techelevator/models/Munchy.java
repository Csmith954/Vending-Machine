package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Product implements Sellable {

    public Munchy() {

    }
    public Munchy(String location, String name, BigDecimal price) {
        super(location, name, price, "Munchy");
        this.quantity = 6;
    }

    @Override
    public String getSound() {
        return "Munchy, Munchy, so Good!";
    }
}
