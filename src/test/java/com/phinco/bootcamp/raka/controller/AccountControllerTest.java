package com.phinco.bootcamp.raka.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountDto;

import com.phinco.bootcamp.raka.service.AccountService;
import org.hamcrest.Matchers;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;


import java.sql.Timestamp;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    static AccountService accountService;

    @Test
    void testGetAccount() throws Exception {
            Account account = new Account();
            account.setId("1");
            account.setName("account1");
            account.setType("penjual");
            account.setCustomerId("1");
            account.setAmount(15L);
            account.setStatus(true);
            account.setCreatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            Mockito.when(accountService.getAccount("1")).thenReturn(account);

            mockMvc.perform(get("/bootcamp/account/{id}", "1")
                           .accept("application/json"))
                   .andDo(print())
                   .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    public void testGetAccountWithIdNull() throws Exception {

        Mockito.when(accountService.getAccount(anyString())).thenReturn(null);

        mockMvc.perform(get("/bootcamp/accounts"))
               .andDo(print())
               .andExpect(result ->  {
                   is(Optional.empty());
               });
    }

    @Test
    public void testGetAccountEmpty() throws Exception {

        Mockito.when(accountService.getAccount(anyString())).thenReturn(null);

        mockMvc.perform(get("/bootcamp/accounts"))
                .andDo(print())
               .andExpect(result ->  {
                   is(Optional.empty());
               });
    }

    @Test
    void testGetAccounts() throws Exception {

        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account();
        Account account2 = new Account();

        account1.setId("1");
        account1.setName("account1");
        account2.setId("2");
        account2.setName("account2");
        accounts.add(account1);
        accounts.add(account2);

        Mockito.when(accountService.getAccounts()).thenReturn(accounts);

        mockMvc.perform(get("/bootcamp/accounts")
                       .contentType("application/json"))
               .andDo(print())
               .andExpect(jsonPath("$[0]").isNotEmpty())
               .andExpect(jsonPath("$[0].id",Matchers.equalTo("1")))
               .andExpect(jsonPath("$[1].id", Matchers.equalTo("2")))
               .andExpect(jsonPath("$[1]").isNotEmpty());

    }

    @Test
    public void testGetAccountsEmpty() throws Exception {

        Mockito.when(accountService.getAccounts()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/bootcamp/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andDo(print());

    }

    @Test
    void testSaveAccount() throws Exception {

        AccountDto accountDto = new AccountDto();
        accountDto.setId("1");
        accountDto.setName("account1");

        String requestBody;
        requestBody = objectMapper.writeValueAsString(accountDto);

        Account account = new Account();
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());

        Mockito.when(accountService.saveAccount(accountDto)).thenReturn(account);


            mockMvc.perform(post("/bootcamp/account")
                                        .content(requestBody)
                                        .contentType("application/json"))
                   .andExpect(status().isCreated())
                   .andDo(print());

    }

    @Test
    void testSaveWithIdNull() throws Exception {

        AccountDto accountDto = new AccountDto();

        accountDto.setName("account1");

        String requestBody = objectMapper.writeValueAsString(accountDto);

        Mockito.when(accountService.saveAccount(accountDto)).thenReturn(null);

        mockMvc.perform(post("/bootcamp/account")
                                    .content(requestBody)
                                    .contentType("application/json"))
               .andExpect(status().isBadRequest())
               .andDo(print());

    }

    @Test
    void testPatchAccount() throws Exception {

        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        String requestBody;
        accountDto.setId("1");
        accountDto.setName("account2");

        requestBody = objectMapper.writeValueAsString(accountDto);
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());

        Mockito.when(accountService.updateAccount(accountDto)).thenReturn(account);

        mockMvc.perform(put("/bootcamp/account")
                       .content(requestBody)
                       .contentType("application/json"))
               .andExpect(jsonPath("$.name",Matchers.equalTo("account2")))
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    void testPutAccount() throws Exception {

        AccountDto accountDto = new AccountDto();
        Account account = new Account();
        String requestBody;
        accountDto.setId("1");
        accountDto.setName("account2");

        requestBody = objectMapper.writeValueAsString(accountDto);
        account.setId(accountDto.getId());
        account.setName(accountDto.getName());

        Mockito.when(accountService.patchAccount(accountDto)).thenReturn(account);

        mockMvc.perform(patch("/bootcamp/account")
                       .content(requestBody)
                       .contentType("application/json"))
               .andExpect(jsonPath("$.name",Matchers.equalTo("account2")))
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    void testDeleteAccount() throws Exception {
        Mockito.when(accountService.deleteAccount("1")).thenReturn(null);

        mockMvc.perform(delete("/bootcamp/account/1"))
                                         .andExpect(status().isOk());

    }

}
