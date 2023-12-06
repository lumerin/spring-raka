package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Account;

import java.util.List;
import java.util.Optional;


public interface AccountService {

    public Optional<Account> getById(int id);

    public List<Account> getAccounts();

    public Account save(Account account);
}
