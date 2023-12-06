package com.phinco.bootcamp.raka.controller;


import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/bootcamp/account/{id}")
    public Optional<Account> GetAccount(@PathVariable("id") int id) {
        return accountService.getById(id);
    }

    @GetMapping("/bootcamp/accounts")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping("/bootcamp/account")
    public Account save(@RequestBody Map<String, Object> body) {
        Account account = new Account();
        account.setId((int) body.get("id"));
        account.setAmount((double) body.get("amount"));
        account.setName((String) body.get("name"));

        return accountService.save(account);
    }
}
