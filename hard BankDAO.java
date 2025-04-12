package com.example.bank.dao;

import com.example.bank.entity.Account;
import com.example.bank.entity.BankTransaction;
import jakarta.persistence.NoResultException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccount(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void updateAccount(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }

    public void logTransaction(BankTransaction txn) {
        sessionFactory.getCurrentSession().save(txn);
    }

    public void createAccount(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }
}
