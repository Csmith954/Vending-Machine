package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;

import static com.techelevator.models.Product.selectItem;
import static com.techelevator.ui.UserInput.getHomeScreenOption;



public class Financials {
    static BigDecimal balance;
    static Product product = new Product();
    static Customer customer = new Customer();
    public static BigDecimal totalSales = new BigDecimal("0.00");

    public Financials(){
        this.balance = new BigDecimal("0.00");
    }
    public Financials(BigDecimal balance){
        this.balance = balance;
    }

    public static void setTotalSales(BigDecimal totalSalesInput) {
        totalSales.add(totalSalesInput);
    }

    public static void sellItem(Product product) {
        BigDecimal productPrice = product.getPrice();
        int regSale = 0;
        int bogoSale = 0;
        int results = balance.compareTo(productPrice);
        try (FileWriter fileWriter = new FileWriter("transactionLog.txt", true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             FileWriter salesReportWriter = new FileWriter("salesreport.txt", true); BufferedWriter bufferedWriterSales = new BufferedWriter(salesReportWriter)) {
            if (results > 0 ) {
                if (product.getQuantity() == 0){
                    System.out.println();
                    System.out.println("Sorry " + product.getName() + " is currently out of stock. Please make a different selection.");
                    System.out.println();
                }
                else if (customer.getItemsPurchased() % 2 != 0 && product.getQuantity() > 0) {
                    BigDecimal updatedBalance = balance.subtract(productPrice).add(new BigDecimal("1.00"));
                    String entry = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + " " + product.getName() + " " + product.getLocation() + " " + balance + " " + updatedBalance;
                    bufferedWriter.write(entry);
                    bufferedWriter.newLine();
                    bufferedWriter.close();

                    totalSales = totalSales.add(product.getPrice());
                    System.out.println(getTotalSales());
                    bogoSale += 1;
                    String salesEntry = product.getName() + " | " + regSale + " | " + bogoSale;
                    bufferedWriterSales.write(salesEntry);
                    bufferedWriterSales.newLine();
                    bufferedWriterSales.close();

                    balance = updatedBalance;
                    customer.setItemsPurchased(1);
                    product.setQuantity();
                    System.out.println(product.getName() + " costs $" + product.getPrice());
                    System.out.println("You Saved a dollar by using the Spring BOGODO Promo!");
                    System.out.println("Enjoy your " + product.getName() + "!");
                    System.out.println(product.getSound());
                    System.out.printf("Your new balance is : $%s", updatedBalance);
                    System.out.println();
                }
             else {
                BigDecimal updatedBalance = balance.subtract(productPrice);
                    String entry = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss").format(LocalDateTime.now()) + " " + product.getName() + " " + product.getLocation() + " " + balance + " " + updatedBalance;
                bufferedWriter.write(entry);
                bufferedWriter.newLine();
                bufferedWriter.close();

                totalSales = totalSales.add(product.getPrice());
                System.out.println(getTotalSales());
                regSale += 1;
                String salesEntry = product.getName() + " | " + regSale + " | " + bogoSale;
                bufferedWriterSales.write(salesEntry);
                bufferedWriterSales.newLine();
                bufferedWriterSales.close();

                balance = updatedBalance;
                customer.setItemsPurchased(1);
                product.setQuantity();
                System.out.println(product.getName() + " costs $" + product.getPrice());
                System.out.println("Enjoy your " + product.getName() + "!");
                System.out.println(product.getSound());
                System.out.printf("Your new balance is : $%s", updatedBalance);
                System.out.println();
            }
        } else {
                System.out.println();
                System.out.println("Insufficient funds, please add more money.");
                System.out.println();
            }
    }catch (IOException e){
            System.out.println();
            System.out.println("An error occurred, no snacks for you!");
            System.out.println();
        }
    }

    public BigDecimal getBalance() {
        return this.balance;
    }
    public void setBalance(BigDecimal money){
        this.balance.add(money);
    }

    public void setBalancePurchase(BigDecimal money){
        this.balance.subtract(money);
    }

    public void getMoney(BigDecimal moneyIn){
        try(FileWriter fileWriter = new FileWriter("transactionLog.txt", true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            balance = balance.add(moneyIn);
            String entry = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss ").format(LocalDateTime.now()) + " MONEY FED: " + moneyIn + " " + balance;
            bufferedWriter.write(entry);
            bufferedWriter.newLine();
        } catch (IOException e){
            System.out.println("Error occurred , thanks for the money!");
        }

        }
    public void makeChangeOne(){

    }
    public void makeChange(BigDecimal moneyOut) {
        BigDecimal balanceLeft = moneyOut;
        BigDecimal zero = new BigDecimal("0.00");
        BigDecimal dollarBill = new BigDecimal("1.00");
        BigDecimal twentyFiveCents = new BigDecimal("0.25");
        BigDecimal tenCents = new BigDecimal("0.10");
        BigDecimal fiveCents = new BigDecimal("0.05");
        int dollar = 0;
        int quarter = 0;
        int dime = 0;
        int nickel = 0;

        String changeProvided = null;

            System.out.println("The remaining balance is: $" + balanceLeft);
            boolean breaker = true;
            while (breaker) {
                if ((balanceLeft.compareTo(dollarBill)) == 1 || balanceLeft.compareTo(dollarBill) == 0) {
                    balanceLeft = balanceLeft.subtract(dollarBill);
                    dollar += 1;
                } else if ((balanceLeft.compareTo(twentyFiveCents)) == 1 || balanceLeft.compareTo(twentyFiveCents) == 0) {
                    balanceLeft = balanceLeft.subtract(twentyFiveCents);
                    quarter += 1;
                } else if ((balanceLeft.compareTo(tenCents)) == 1 || balanceLeft.compareTo(tenCents) == 0) {
                    balanceLeft = balanceLeft.subtract(tenCents);
                    dime += 1;
                } else if ((balanceLeft.compareTo(fiveCents)) == 1 || balanceLeft.compareTo(fiveCents) == 0) {
                    balanceLeft = balanceLeft.subtract(fiveCents);
                    nickel += 1;
                } else if (balanceLeft.compareTo(zero) == 0) {
                    breaker = false;
                }

            }

            System.out.println("Your change is : " + dollar + " dollar(s) " + quarter + " quarter(s) " + dime + " dime(s) " + nickel + " nickle(s).");
            String entry = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss ").format(LocalDateTime.now()) + " CHANGE GIVEN: " + balance + " " + balanceLeft;
            writeLine(entry);
            balance = balanceLeft;
    }
public void writeLine(String entry){
    try (FileWriter fileWriter = new FileWriter("transactionLog.txt", true); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
        bufferedWriter.write(entry);
        bufferedWriter.newLine();
    } catch (IOException e) {
        System.out.println("A bank error occurred in favor of the machine");
    }
}
    public static BigDecimal getTotalSales() {
        return totalSales;
    }

}
