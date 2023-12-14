package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryImplTest {

    @Autowired
    AccountRepository accountRepository;
    @Test
    void getAccountById() {
        String id = "1";
        Account account = accountRepository.getAccountById(id);
        assertNotNull(account);
        assertEquals("1", account.getId());
        assertEquals("account1", account.getName());
        assertEquals(true, account.isStatus());
    }
}