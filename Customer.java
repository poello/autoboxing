package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addCustomerTransaction(initialAmount);
    }

    public void addCustomerTransaction(double amount) {
        if(amount > 0) {
            this.transactions.add(Double.valueOf(amount));
        }
    }

    public void printCustomerTransactions(){
        System.out.println("\t\t"+ this.name + " transactions: ");
        for(int i = 0; i < this.transactions.size(); i++) {
            System.out.println("\t\t" + (i+1) + ". " + this.transactions.get(i).doubleValue() + " ");
        }
    }

    public String getName() {
        return name;
    }

}
