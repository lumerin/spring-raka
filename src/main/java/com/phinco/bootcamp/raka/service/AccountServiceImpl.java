package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repository;

//    @Override
//    public Optional<Account> find(int id) {
////        Account account = new Account();
////        account.setId(1);
////        account.setName("Raka");
////        account.setAmount(10.0);
////
////        return account;
//        return repository.findById(id);
//    }

    @Override
    public Optional<Account> getById(int id) {
        return (Optional<Account>) repository.findById(id);
    }

    @Override
    public List<Account> getAccounts() {
//        Account account1 = new Account();
//        account1.setId(1);
//        account1.setName("Raka");
//        account1.setAmount(10.0);
//
//        Account account2 = new Account();
//        account2.setId(2);
//        account2.setName("Aditya");
//        account2.setAmount(10.0);
//
//        List<Account> accounts = new ArrayList<>();
//        accounts.add(account1);
//        accounts.add(account2);

//        return accounts;
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

}
