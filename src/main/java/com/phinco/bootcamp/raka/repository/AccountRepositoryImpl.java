package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    Logger logger = LoggerFactory.getLogger(AccountRepositoryImpl.class);
    private static final Boolean INACTIVE = false;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM accounts WHERE ID = ?";
        Account account = jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{id} );
        logger.info("getAccounById {}", id);
        return account;
    }

    @Override
    public Account getAccountByIdAndName(String id, String name) {
        String sql = "SELECT * FROM accounts WHERE ID = ? AND NAME = ?";
        Account account = jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{id} );
        logger.info("getAccounByIdAndName {}", id, name);
        return  account;
    }

    @Override
    public List<Account> getAllAccount() {
//        String sql = "SELECT * FROM accounts";
//        List<Account> account = jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{} );
//        logger.info("getAllAccount {}");
        return  null;
    }

    @Override
    public Account createAccount(Account account) {
//        String sql = "SELECT * FROM accounts";
//        List<Account> account = jdbcTemplate.query(sql);
//        logger.info("getAllAccount {}");
        return  null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }

    @Override
    public Account softDeleteAccount(Account account) {
        return null;
    }
}
