package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;
import com.phinco.bootcamp.raka.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;

    @Override
    public Customer getCustomer(String id) {
        Optional<Customer> acc = repository.findByIdAndStatus(id, true);
        if(acc.isPresent()){
            return acc.get();
        }
        return new Customer();
    }

    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) repository.findByStatus(true);
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setStatus(true);
        customer.setCreatedDate((new Timestamp(Calendar.getInstance().getTimeInMillis())));
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        Optional<Customer> acc = repository.findByIdAndStatus(customerDto.getId(), true);
        if(acc.isPresent()) {
            Customer customer = acc.get();
            customer.setId(acc.get().getId());
            customer.setName(customerDto.getName());
            customer.setStatus(acc.get().isStatus());
            customer.setCreatedDate(acc.get().getCreatedDate());
            customer.setUpdatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            return repository.save(customer);
        }
        return new Customer();
    }

    @Override
    public Customer patchCustomer(CustomerDto customerDto) {
        Optional<Customer> acc = repository.findByIdAndStatus(customerDto.getId(), true);
        if (acc.isPresent()) {
            Customer customer = acc.get();

            if (customerDto.getName() != null) {
                customer.setName(customerDto.getName());
            }

            customer.setUpdatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            return repository.save(customer);
        }
        return new Customer();
    }

    @Override
    public Customer deleteCustomer(String id) {
        Optional<Customer> acc = repository.findById(id);

        if (acc.isPresent()) {
            Customer customer = new Customer();
            customer.setStatus(false);
            customer.setUpdatedDate(new Timestamp(Calendar.getInstance()
                                                          .getTimeInMillis()));
            return repository.save(customer);
        }
        return new Customer();
    }
}
