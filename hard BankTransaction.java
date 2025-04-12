package com.example.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int fromAccountId;
    private int toAccountId;
    private double amount;
    private LocalDateTime timestamp;

    public BankTransaction() {}

    public BankTransaction(int from, int to, double amount) {
        this.fromAccountId = from;
        this.toAccountId = to;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters & setters
}
