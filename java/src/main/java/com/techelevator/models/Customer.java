package com.techelevator.models;



import javax.annotation.processing.Filer;
import java.io.*;
import java.nio.Buffer;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Customer {
    private int itemsPurchased = 0;

    public Customer(){
        this.itemsPurchased = 0;
    }

    public int getItemsPurchased() {
        return itemsPurchased;
    }

    public void setItemsPurchased(int itemsPurchased) {
        this.itemsPurchased += itemsPurchased;
    }
}







