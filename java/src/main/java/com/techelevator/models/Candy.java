package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Product implements Sellable {
    public Candy(String location, String name, BigDecimal price) {
        super(location, name, price, "Candy");
        this.quantity = 6;
    }
    public Candy () {

    }
    @Override
    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}
