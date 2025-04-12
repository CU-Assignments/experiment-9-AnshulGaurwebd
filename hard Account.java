package com.example.bank.entity;

import jakarta.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String holderName;
    private double balance;

    public Account() {}

    public Account(String holderName, double balance) {
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters & setters

    public int getId() { return id; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void setHolderName(String name) { this.holderName = name; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return "Account{id=" + id + ", holder='" + holderName + "', balance=" + balance + '}';
    }
}
