package com.phinco.bootcamp.raka.repository;

import com.phinco.bootcamp.raka.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
