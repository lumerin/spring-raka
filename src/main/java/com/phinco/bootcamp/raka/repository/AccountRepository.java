package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository {
    public Account getAccountById(String id);
}
