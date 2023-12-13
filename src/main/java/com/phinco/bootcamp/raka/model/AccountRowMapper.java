package com.phinco.bootcamp.raka.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getString("id"));
        account.setAmount(rs.getLong("amount"));
        account.setCustomerId(rs.getString("customer_id"));
        account.setName(rs.getString("name"));
        account.setStatus(rs.getBoolean("status"));
        account.setType(rs.getString("type"));
        return account;
    }
}
