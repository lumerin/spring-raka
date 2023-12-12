package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM ACCOUNTS WHERE ID = ";
        jdbcTemplate.queryForObject(sql, Account.class, id);
    }
}
