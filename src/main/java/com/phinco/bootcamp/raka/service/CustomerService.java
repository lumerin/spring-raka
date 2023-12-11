package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;

import java.util.List;

public interface CustomerService {
    public Customer getCustomer(String id);
    public List<Customer> getCustomers();
    public Customer saveCustomer(CustomerDto customerDto);

    public Customer updateCustomer(CustomerDto customerDto);

    public Customer patchCustomer(CustomerDto customerDto);

    public Customer deleteCustomer(String id);
}
