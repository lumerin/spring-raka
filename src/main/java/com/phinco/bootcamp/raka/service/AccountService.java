package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountDto;

import java.util.List;

public interface AccountService {
    public Account getAccount(String id);
    public List<Account> getAccounts();
    public Account saveAccount(AccountDto accountDto);

    public Account updateAccount(AccountDto accountDto);

    public Account patchAccount(AccountDto accountDto);

    public Account deleteAccount(String id);
}
