package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Product implements Sellable {
    public Gum(String location, String name, BigDecimal price) {
        super(location, name, price, "Gum");
        this.quantity = 6;
    }
    public Gum() {

    }


    @Override
    public String getSound() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}

