package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findByStatus(Boolean status);
    Optional<Account> findByIdAndStatus(String id, boolean status);

}
