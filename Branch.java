package com.company;

import java.util.ArrayList;

public class Branch {
    String name;
    ArrayList<Customer> customerArrayList;

    public Branch(String name) {
        this.name = name;
        this.customerArrayList = new ArrayList<Customer>();
    }

    public void addCustomer(String name, double initialAmount) {
        Customer customer = new Customer(name, initialAmount);
        if(findCustomer(customer) >= 0) {
            System.out.println("This customer already exists.");
        } else {
            this.customerArrayList.add(customer);
            System.out.println("Customer added successfully.");
        }
    }

    public void printCustomers() {
        System.out.println("\t" + "There are " + this.customerArrayList.size() + " customers in " + this.name + " branch.");
        for(int i = 0; i < this.customerArrayList.size(); i++) {
            System.out.println("\t" + (i+1) + ". " + this.customerArrayList.get(i).getName());
            this.customerArrayList.get(i).printCustomerTransactions();
        }
    }

    private int findCustomer(Customer customer) {
        for(int i = 0; i < this.customerArrayList.size(); i++) {
            if(this.customerArrayList.get(i).getName().equals(customer.getName())) {
                return i;
            }
        }

        return -1;
    }

    public int searchForCustomer(String name) {
        Customer customer = new Customer(name, 0);
        return findCustomer(customer);
    }

    public String getName() {
        return name;
    }
}
