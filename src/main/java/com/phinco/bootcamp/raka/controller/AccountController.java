package com.phinco.bootcamp.raka.controller;


import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountDto;
import com.phinco.bootcamp.raka.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/bootcamp/account/{id}")
    public Account getAccount(@PathVariable("id") String id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/bootcamp/accounts")
    public List<Account> getAccounts(){
        return accountService.getAccounts();
    }


    @PostMapping("/bootcamp/account")
    public ResponseEntity<Account> save(@Valid @RequestBody AccountDto accountDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<Account>(accountService.saveAccount(accountDto), responseHeaders, HttpStatus.CREATED);
    }

    @PatchMapping("/bootcamp/account")
    public ResponseEntity<Account> patchAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<Account>(accountService.patchAccount(accountDto), HttpStatus.OK);
    }

    @PutMapping("/bootcamp/account")
    public ResponseEntity<Account> updateAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<Account>(accountService.updateAccount(accountDto), HttpStatus.OK);
    }

    @DeleteMapping("/bootcamp/account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") String id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
