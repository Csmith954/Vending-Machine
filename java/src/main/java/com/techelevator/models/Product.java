package com.techelevator.models;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.application.VendingMachine.displayInventory;
import static com.techelevator.application.VendingMachine.makeInventory;
import static com.techelevator.models.Financials.sellItem;


public class Product implements Sellable {

    private String name;
    private String type;
    private String location;
    private BigDecimal price;
    public int quantity = 6;
    File userFile = new File("catering.csv");
    List<String> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public Product() {

    }
    public Product(String location, String name, BigDecimal price, String type) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(){
        this.quantity -= 1;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public List<String> getInventory(File userFile) {
           try (Scanner inputScanner = new Scanner(userFile.getAbsoluteFile())) {
            while (inputScanner.hasNextLine()) {
                String line = inputScanner.nextLine();
                String[] data = line.split(",");
                for (int i = 0; i <= 3; i++) {
                    inventory.add(data[i]);
                }
            }
        } catch (IOException e) {
               e.printStackTrace();
               System.out.println("Problem opening inventory file!");
        }

        return inventory;
    }

    public static void selectItem(List<Product> inventory) {
        File userFile = new File("catering.csv");
        Product product = new Product();
        Gum gum = new Gum();
        Munchy munchy = new Munchy();
        Candy candy = new Candy();
        Drink drink = new Drink();
        boolean isItem = false;
        System.out.println("Taste Elevator's Current Stock: ");

            for (Product item : inventory) {
                System.out.format("%s %-20s %20s %20s", item.getLocation(), item.getName(), item.getPrice(), item.getQuantity());
                System.out.println();
            }
        System.out.println("Please enter your item location: ");
        String choice = scanner.nextLine().toLowerCase();
            for (Product selectedItem : inventory) {
                if (selectedItem.getLocation().equalsIgnoreCase(choice)){
                    sellItem(selectedItem);
                    System.out.println();
                    isItem = true;
                }
            }
            if (!isItem){
                System.out.println();
                System.out.println("Invalid selection, please try again.");
                System.out.println();
            }
            }

    @Override
    public String getSound() {
        return "I dont know what to sing!";
    }
}
