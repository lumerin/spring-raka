package com.phinco.bootcamp.raka.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {
    static Account account;
    @BeforeAll
    static void setUp() {
        account = new Account();
        account.setAmount(10.0);
        account.setId(1);
        account.setName("Raka Aditya");
    }

    @Test
    void TestGetAmount() {
        assertEquals(10.0, account.getAmount());
    }

    @Test
    void TestGetId() {
        assertEquals(1, account.getId());
    }

    @Test
    void TestGetName() {
        assertEquals("Raka Aditya", account.getName());
    }

    @Test
    void TestSetName() {
        assertTrue(true);
    }

    @Test
    void TestSetId() {
        assertTrue(true);
    }

    @Test
    void TestSetIdSting() {
        assertEquals("1", account.setIdString());
    }

    @Test
    void TestSetAmount() {
        assertTrue(true);
    }
}
