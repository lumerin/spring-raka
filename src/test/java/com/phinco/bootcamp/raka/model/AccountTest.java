package com.phinco.bootcamp.raka.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testSetId() {
        Account account = new Account();
        account.setId("1");
        assertEquals("1", account.getId());
    }

    @Test
    public void testSetAccountId() {
        Account account = new Account();

        account.setCustomerId("account1");
        assertEquals("account1", account.getCustomerId());
    }

    @Test
    public void testSetName() {
        Account account = new Account();

        account.setName("Damar");
        assertEquals("Damar", account.getName());
    }

    @Test
    public void testSetType() {
        Account account = new Account();

        account.setType("Savings");
        assertEquals("Savings", account.getType());
    }

    @Test
    public void testSetStatus() {
        Account account = new Account();

        account.setStatus(true);
        assertEquals(true, account.isStatus());
    }

    @Test
    public void testSetAmount() {
        Account account = new Account();

        account.setAmount(1000L);
        assertEquals(Long.valueOf(1000L), account.getAmount());
    }

    @Test
    public void testSetCreatedDate() {
        Account account = new Account();

        long currentTime = System.currentTimeMillis();
        account.setCreatedDate(new Timestamp(currentTime));
        assertEquals(currentTime, account.getCreatedDate().getTime());
    }

    @Test
    public void testSetUpdatedDate() {
        Account account = new Account();

        long currentTime = System.currentTimeMillis();
        account.setUpdatedDate(new Timestamp(currentTime));
        assertEquals(currentTime, account.getUpdatedDate().getTime());
    }
}