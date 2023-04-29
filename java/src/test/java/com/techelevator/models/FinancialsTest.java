package com.techelevator.models;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

/*
got how to test print stream from https://morioh.com/p/c14998c5c076
 */


public class FinancialsTest extends TestCase {
    public final PrintStream standardOut = System.out;
    public final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    public Financials financials = new Financials();
    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
        public  void testOutput() {
            BigDecimal testChange = new BigDecimal("1.50");
            financials.makeChange(testChange);
            String expectedOutput = "Your change is : " + 1 + " dollar(s) " + 2 + " quarter(s) " + 0 + " dime(s) " + 0 + " nickle(s).";
            expectedOutput = String.format("%s\n%s", "The remaining balance is: " + testChange , expectedOutput).trim();
            assertEquals(expectedOutput, outputStreamCaptor.toString().replaceAll("\\r\\n", "\n").trim()
            );
        }


//    @Test
//    public void testMakeChange() {
//        Financials sut = new Financials();
//        BigDecimal testChange = new BigDecimal("1.50");
//        String actual = makeChange(testChange);
//        String expected = "Your change is : " + 1 + " dollar(s) " + 2 + " quarter(s) " + 0 + " dime(s) " + 0 + " nickle(s).";
//        Assert.assertEquals(expected,actual);
//    }
}