package com.phinco.bootcamp.raka.repository;


import com.phinco.bootcamp.raka.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    List<Customer> findByStatus(Boolean status);
    Optional<Customer> findByIdAndStatus(String id, boolean status);

}


