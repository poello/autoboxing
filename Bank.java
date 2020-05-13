package com.company;

import java.util.ArrayList;

public class Bank {
    ArrayList<Branch> branchArrayList = new ArrayList<Branch>();

    public void addBranch(String name) {
        Branch branch = new Branch(name);
        if(findBranch(branch) >= 0) {
            System.out.println("This branch already exists.");
        } else {
            this.branchArrayList.add(branch);
        }
    }

    public void printBranches() {
        System.out.println("There are " + this.branchArrayList.size() + " branches");
        for(int i = 0; i < this.branchArrayList.size(); i++) {
            System.out.println((i+1) + ". " + this.branchArrayList.get(i).getName());
            this.branchArrayList.get(i).printCustomers();
        }
    }

    private int findBranch(Branch branch) {
        for(int i = 0; i < this.branchArrayList.size(); i++) {
            if(this.branchArrayList.get(i).getName().equals(branch.getName())) {
                return i;
            }
        }

        return -1;
    }

    public int searchForBranch(String name) {
        Branch branch = new Branch(name);
        return findBranch(branch);
    }
}
