package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends Product implements Sellable{

    public Drink() {

    }
    public Drink(String location, String name, BigDecimal price) {
        super(location, name, price, "Drink");
        this.quantity = 6;
    }

    @Override
    public String getSound() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
