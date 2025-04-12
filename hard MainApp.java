package com.example.bank;

import com.example.bank.config.AppConfig;
import com.example.bank.entity.Account;
import com.example.bank.service.BankService;
import com.example.bank.dao.BankDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        BankService bankService = context.getBean(BankService.class);
        BankDAO bankDAO = context.getBean(BankDAO.class);

        // Create sample accounts (run once)
        bankDAO.createAccount(new Account("Alice", 5000));
        bankDAO.createAccount(new Account("Bob", 3000));

        try {
            // Successful transaction
            bankService.transferMoney(1, 2, 1000);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        try {
            // Failed transaction (Insufficient funds)
            bankService.transferMoney(1, 2, 10000);
        } catch (Exception e) {
            System.out.println("Transfer failed (expected): " + e.getMessage());
        }

        context.close();
    }
}
