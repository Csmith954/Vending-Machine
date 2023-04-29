package com.techelevator.models;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest extends TestCase {
    @Test
    public void testGetName() {
        Product sut = new Product("A1", "Sprite", new BigDecimal("200.00"), "Drink");
        //arrange
        String actual = sut.getName();
        String expected = "Sprite";
        //act
        //assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testGetType() {
        Product sut = new Product("B4", "Popplers", new BigDecimal("1.00"), "Munchy");
        String actual = sut.getType();
        String expected = "Munchy";
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testGetLocation() {
        Product sut = new Product("C3", "Human Horn", new BigDecimal("69.00"), "Munchy");
        String actual = sut.getLocation();
        String expected = "C3";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetPrice() {
        Product sut = new Product("D2", "White Russian", new BigDecimal("10.00"), "Drink");
        BigDecimal actual = sut.getPrice();
        BigDecimal expected = new BigDecimal("10.00");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testGetSound() {
        Product sut = new Product("A3", "Bender Lets Loose!", new BigDecimal("15.00"), "CD");
        String actual = sut.getSound();
        String expected = "I dont know what to sing!";
        Assert.assertEquals(expected,actual);
    }
}