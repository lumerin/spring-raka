package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM accounts WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{id} );
    }
}
