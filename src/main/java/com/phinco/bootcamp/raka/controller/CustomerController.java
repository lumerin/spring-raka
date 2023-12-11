package com.phinco.bootcamp.raka.controller;


import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;
import com.phinco.bootcamp.raka.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping("/bootcamp/customer/{id}")
    public Customer getCustomer(@PathVariable("id") String id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/bootcamp/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @PostMapping("/bootcamp/Customer")
    public ResponseEntity<Customer> save(@Valid @RequestBody CustomerDto customerDto) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<Customer>(customerService.saveCustomer(customerDto), responseHeaders, HttpStatus.CREATED);
    }

    @PatchMapping("/bootcamp/Customer")
    public ResponseEntity<Customer> patchCustomer(@RequestBody CustomerDto CustomerDto) {
        return new ResponseEntity<Customer>(customerService.patchCustomer(CustomerDto), HttpStatus.OK);
    }

    @PutMapping("/bootcamp/Customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto CustomerDto) {
        return new ResponseEntity<Customer>(customerService.updateCustomer(CustomerDto), HttpStatus.OK);
    }

    @DeleteMapping("/bootcamp/Customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
