package com.phinco.bootcamp.raka.repository;


import com.phinco.bootcamp.raka.model.Account;

import java.util.List;

public interface AccountRepository {
    public Account getAccountById(String id);
    public Account getAccountByIdAndName(String id, String name);
    public List<Account> getAllAccount();
    public Account createAccount(Account account);
    public Account updateAccount(Account account);
    public Account softDeleteAccount(Account account);
}
