package com.phinco.bootcamp.raka.controller;


import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountDto;
import com.phinco.bootcamp.raka.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@Tag(name = " ACCOUNT API")
public class AccountController {
//    Logger logger = LoggerFactory.getLogger(AccountController.class);
    Logger logger = getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @Operation(summary = "Get Account By Id", description = "API to return 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "404", description = "Not Found - The Product was not found")
    })
    @GetMapping("/bootcamp/account/{id}")
    public Account getAccount(@PathVariable String id) {
        logger.info("getaccount id {}", id);
        return accountService.getAccountById(id);
    }


//    @GetMapping("/bootcamp/account/{id}")
//    public Account getAccount(@PathVariable("id") String id) {
//        logger.info("message log");
//        logger.info("message log {}", id);
//        logger.info("fatal", Throwable.class);
//        logger.debug("message debug", id);
//        logger.trace("message {}", id);
//        return accountService.getAccount(id);
//    }

//    @GetMapping("/bootcamp/accounts")
//    public List<Account> getAccounts(){
//        return accountService.getAccounts();
//    }
//
//
//    @PostMapping("/bootcamp/account")
//    public ResponseEntity<Account> save(@Valid @RequestBody AccountDto accountDto) {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("MyResponseHeader", "MyValue");
//        return new ResponseEntity<Account>(accountService.saveAccount(accountDto), responseHeaders, HttpStatus.CREATED);
//    }
//
//    @PatchMapping("/bootcamp/account")
//    public ResponseEntity<Account> patchAccount(@RequestBody AccountDto accountDto) {
//        return new ResponseEntity<Account>(accountService.patchAccount(accountDto), HttpStatus.OK);
//    }
//
//    @PutMapping("/bootcamp/account")
//    public ResponseEntity<Account> updateAccount(@RequestBody AccountDto accountDto) {
//        return new ResponseEntity<Account>(accountService.updateAccount(accountDto), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/bootcamp/account/{id}")
//    public ResponseEntity<String> deleteAccount(@PathVariable("id") String id) {
//        accountService.deleteAccount(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
