package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void getShakeScreen(){
        System.out.println();
        System.out.println("~~~~----------~~~~~~~");
        System.out.println("~~~~----------~~~~~~~");
        int randNum = new Random().nextInt(13);
        String[] funnyResponses = new String[] {"Nice try, I'm contacting the authorities!", "Did you know, vending machines are responsible for an average of 13 deaths a year.",
        "You're killing me smalls!", "Do you even lift bro?!", "...and the Darwin Award goes to...", "Is that all you got?", "You need a snack that bad? Here's one on the house."
        ,"Come back when you get your allowance!", "This aggression will not stand, man!", "My friends didn't die face down in the muck for you to get free snacks!",
        "I'm not even supposed to be here today!", "This job would be great if it wasn't for the customers", "Sometimes you eat the bar, and sometimes...well sometimes the bar eats you."};

        for (int i = 0; i < funnyResponses.length; i++) {
            if (randNum == i) {
                System.out.println(funnyResponses[i]);
                System.out.println("~~~~----------~~~~~~~");
                System.out.println("~~~~----------~~~~~~~");
                System.out.println();
            }
        }
    }

}
