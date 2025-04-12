package com.example.bank.service;

import com.example.bank.dao.BankDAO;
import com.example.bank.entity.Account;
import com.example.bank.entity.BankTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private BankDAO dao;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account from = dao.getAccount(fromId);
        Account to = dao.getAccount(toId);

        if (from == null || to == null) throw new RuntimeException("Invalid account(s)");

        if (from.getBalance() < amount) throw new RuntimeException("Insufficient funds");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        dao.updateAccount(from);
        dao.updateAccount(to);
        dao.logTransaction(new BankTransaction(fromId, toId, amount));

        System.out.println("Transferred $" + amount + " from " + from.getHolderName() + " to " + to.getHolderName());
    }
}
