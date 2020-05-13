package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank();

    public static void main(String[] args) {
        boolean quit = true;
        int choice;
        printInstructions();

        while(quit){
            System.out.println("Please enter your choice: \r");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    bank.printBranches();
                    break;
                case 2:
                    printCustomers();
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    addBranch();
                    break;
                case 5:
                    addCustomer();
                    break;
                case 6:
                    addTransaction();
                    break;
                case 7:
                    quit = false;
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the whole list (branches, customers, transactions).");
        System.out.println("\t 2 - To print the customers.");
        System.out.println("\t 3 - To print the transactions.");
        System.out.println("\t 4 - To add a branch to the list.");
        System.out.println("\t 5 - To add a customer to the branch.");
        System.out.println("\t 6 - To add a transaction to the customer.");
        System.out.println("\t 7 - To quit the application.");
    }

    private static void printCustomers() {
        int branchPosition = passBranch();

        if(branchPosition >= 0) {
            bank.branchArrayList.get(branchPosition).printCustomers();
        } else {
            System.out.println("This branch doesn't exists.");
        }
    }

    private static void printTransactions() {
        int branchPosition = passBranch();
        int customerPosition = passCustomer(branchPosition);

        if(customerPosition >= 0) {
            bank.branchArrayList.get(branchPosition).customerArrayList.get(customerPosition).printCustomerTransactions();
        } else {
            System.out.println("This customer doesn't exists.");
        }
    }

    private static void addBranch(){
        System.out.println("Please enter the branch name: \r");
        String name = scanner.nextLine();
        bank.addBranch(name);
    }

    private static void addCustomer() {
        int branchPosition = passBranch();

        if(branchPosition >= 0) {
            System.out.println("Please enter the name of the customer:\r");
            String customerName = scanner.nextLine();

            System.out.println("And now please enter the transaction amount: \r");
            double initialAmount = scanner.nextDouble();
            scanner.nextLine();

            bank.branchArrayList.get(branchPosition).addCustomer(customerName, initialAmount);
        } else {
            System.out.println("This branch doesn't exists.");
        }
    }

    private static void addTransaction() {
        int branchPosition = passBranch();
        int customerPosition = passCustomer(branchPosition);

        if(customerPosition >= 0) {
            System.out.println("Please enter a new transaction:\r");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            bank.branchArrayList.get(branchPosition).customerArrayList.get(customerPosition).addCustomerTransaction(amount);
        } else {
            System.out.println("This customer doesn't exists.");
        }
    }

    private static int passBranch() {
        System.out.println("Please enter the name of the branch:\r");
        String branchName = scanner.nextLine();
        return bank.searchForBranch(branchName);
    }

    private static int passCustomer(int branchPosition) {
        if(branchPosition >= 0) {
            System.out.println("Please enter the name of the customer:\r");
            String customerName = scanner.nextLine();
            return bank.branchArrayList.get(branchPosition).searchForCustomer(customerName);
        } else {
            System.out.println("This branch doesn't exists.");
            return -1;
        }
    }
}
/*
bank.addBranch("Industry");
        bank.addBranch("Development");
        bank.printBranches();

        bank.branchArrayList.get(0).addCustomer("Jack", 1000);
        bank.branchArrayList.get(0).addCustomer("Mike", 5000);

        bank.branchArrayList.get(1).addCustomer("Lucas", 4200);
        bank.branchArrayList.get(1).customerArrayList.get(0).addCustomerTransaction(2000);
        bank.branchArrayList.get(1).addCustomer("Lucas", 20);

        bank.branchArrayList.get(0).printCustomers();
        bank.branchArrayList.get(1).printCustomers();
 */