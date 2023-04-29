package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import java.io.File;

import static com.techelevator.ui.UserInput.*;
import static com.techelevator.ui.UserOutput.getShakeScreen;

public class VendingMachine 
{
    UserInput input = new UserInput();
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();

    }
    public void run(){
        File userFile = new File("catering.csv");
        Product product = new Product();
        Gum gum = new Gum();
        Munchy munchy = new Munchy();
        Candy candy = new Candy();
        Drink drink = new Drink();
        List<String> inventory = product.getInventory(userFile);
        List<Product> actualInventory = makeInventory();
        Financials financials = new Financials(new BigDecimal("0.00"));
        UserInput input = new UserInput();

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                displayInventory();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                input.getPurchaseScreenOption(actualInventory, financials);

            }
            else if(choice.equals("exit"))
            {
                // good bye
                System.out.println("Thanks for shopping with us!");
                System.exit(0);
            }
            else if (choice.equals("secret admin menu")){
                getSecretAdminMenu();
            }
            else if (choice.equals("shake")){
                getShakeScreen();
            }
        }
    }

    public static void displayInventory() {
        File userFile = new File("catering.csv");
        Product product = new Product();
        Gum gum = new Gum();
        Munchy munchy = new Munchy();
        Candy candy = new Candy();
        Drink drink = new Drink();
        List<String> inventory = product.getInventory(userFile);
        List<Product> actualInventory = new ArrayList<>();
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).equalsIgnoreCase("gum")) {
                Gum newGum = new Gum(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                actualInventory.add(newGum);
            }
            if (inventory.get(i).equalsIgnoreCase("drink")) {
                Drink newDrink = new Drink(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                actualInventory.add(newDrink);
            }
            if (inventory.get(i).equalsIgnoreCase("candy")) {
                Candy newCandy = new Candy(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                actualInventory.add(newCandy);
            }
            if (inventory.get(i).equalsIgnoreCase("munchy")) {
                Munchy newMunchy = new Munchy(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                actualInventory.add(newMunchy);
            }
        }
        System.out.println("Taste Elevator's Current Stock: ");
        for (Product curProd : actualInventory) {
            System.out.format("%s %-20s %20s %20s", curProd.getLocation(), curProd.getName(), curProd.getPrice(), curProd.getQuantity());
            System.out.println();
        }
        }

        public static List<Product> makeInventory(){
            File userFile = new File("catering.csv");
            Product product = new Product();
            Gum gum = new Gum();
            Munchy munchy = new Munchy();
            Candy candy = new Candy();
            Drink drink = new Drink();
            List<String> inventory = product.getInventory(userFile);
            List<Product> actualInventory = new ArrayList<>();
            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).equalsIgnoreCase("gum")) {
                    Gum newGum = new Gum(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                    actualInventory.add(newGum);
                }
                if (inventory.get(i).equalsIgnoreCase("drink")) {
                    Drink newDrink = new Drink(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                    actualInventory.add(newDrink);
                }
                if (inventory.get(i).equalsIgnoreCase("candy")) {
                    Candy newCandy = new Candy(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                    actualInventory.add(newCandy);
                }
                if (inventory.get(i).equalsIgnoreCase("munchy")) {
                    Munchy newMunchy = new Munchy(inventory.get(i - 3), inventory.get(i - 2), new BigDecimal(inventory.get(i - 1)));
                    actualInventory.add(newMunchy);
                }
            }
            return actualInventory;
    }

}
