package com.techelevator.ui;

import com.techelevator.models.Customer;
import com.techelevator.models.Financials;
import com.techelevator.models.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static com.techelevator.application.VendingMachine.makeInventory;
import static com.techelevator.models.Financials.getTotalSales;
import static com.techelevator.models.Product.selectItem;
import static com.techelevator.ui.UserOutput.displayHomeScreen;
import static com.techelevator.ui.UserOutput.getShakeScreen;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);
    static Customer customer = new Customer();
    static boolean isCorrectOption = true;

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.println("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("d"))
        {
            return "display";
        }
        else if (option.equals("p"))
        {
            return "purchase";
        }
        else if (option.equals("e"))
        {
            System.out.println("Thanks for shopping with us , please take this quick survey at https://www.surveymonkey.com/r/R9WF593");
            System.exit(0);
            return "exit";
        }else if (option.equals("s")) {
            return "secret admin menu";
    }else if (option.equals("k")){
            return "shake";
        }
        else
        {
            return "Invalid option selected please enter a valid option.";
        }

    }

    public void getPurchaseScreenOption(List<Product> inventory, Financials financials) {
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.printf("Your current balance is $ %s", financials.getBalance());
        System.out.println();

        System.out.println("M) Feed Money");
        System.out.println("S) Select Item");
        System.out.println("F) Finish Transaction");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
            if (option.equals("m")) {
                getMoneyAmountIn(financials);
                getPurchaseScreenOption(inventory, financials);
            }
            else if (option.equals("s")) {
                selectItem(inventory);
                getPurchaseScreenOption(inventory, financials);
            }
            else if (option.equals("f")) {
                //say bye
                System.out.println("Thank you for your business!");
                financials.makeChange(financials.getBalance());
            }
            else if (!option.equals("m") || !option.equals("s") || !option.equals("f")) {
                System.out.println();
                System.out.println("Invalid selection, please try again.");
                System.out.println();
                return;

            }

    }

    public static void getSecretAdminMenu() {
        System.out.println("---------------------------");
        System.out.println("----------Admin------------");
        System.out.println("----------Menu-------------");
        System.out.println("---------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Enter 'R' to generate sales data report");
        System.out.println("Enter 'X' to return to Main Menu");

        String adminChoice = scanner.nextLine().toLowerCase();


        if (adminChoice.equals("r")) {
            try (FileWriter totalSales = new FileWriter("salesreport.txt", true); BufferedWriter totalSalesBuffer = new BufferedWriter(totalSales)){
                String salesTotalsEntry = "TOTAL SALES:  $" + getTotalSales();
                totalSalesBuffer.write(salesTotalsEntry);
                totalSalesBuffer.newLine();
            } catch (IOException e){
                System.out.println("Error , couldn't find the sales report.");
            }
            Scanner fileReader = new Scanner("salesreport.txt");
            try (BufferedReader reader = new BufferedReader(new FileReader("salesreport.txt"))) {
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (adminChoice.equals("x")) {

            return;
        } else {
            System.out.println("Invalid selection , please try again.");
            getSecretAdminMenu();
        }
    }

    private static void getItem() {
    }

    public static void getMoneyAmountIn(Financials financials){
        System.out.println("How much would you like to add to your balance?");
        System.out.println();
        System.out.println("1) $1.00");
        System.out.println("5) $5.00");
        System.out.println("10) $10.00");
        System.out.println("20) $20.00");
        System.out.println();

        String choice = scanner.nextLine();
        BigDecimal userBalance = financials.getBalance();
        BigDecimal singleBill = new BigDecimal("1.00");
        BigDecimal fiveBill = new BigDecimal("5.00");
        BigDecimal tenBill = new BigDecimal("10.00");
        BigDecimal twentyBill = new BigDecimal("20.00");

        if (choice.equals("1")){
            financials.getMoney(singleBill);
            System.out.println("Current balance is: ");
            System.out.format("%s $", financials.getBalance());
            System.out.println();
        }
        if (choice.equals("5")){
            financials.getMoney(fiveBill);
            System.out.println("Current balance is: ");
            System.out.format("%s $", financials.getBalance());
            System.out.println();
        }
        if (choice.equals("10")){
            financials.getMoney(tenBill);
            System.out.println("Current balance is: ");
            System.out.format("%s $ ", financials.getBalance());
            System.out.println();
        }
        if (choice.equals("20")){
            financials.getMoney(twentyBill);
            System.out.println("Current balance is: ");
            System.out.format("%s $ ", financials.getBalance());
            System.out.println();
        }

    }



    
}
