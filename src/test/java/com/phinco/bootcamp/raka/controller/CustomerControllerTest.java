package com.phinco.bootcamp.raka.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;
import com.phinco.bootcamp.raka.service.CustomerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;

    @MockBean
    static CustomerService customerService;

    @Test
    void testGetCustomer() throws Exception {

            Customer customer = new Customer();
            customer.setId("1");
            customer.setName("Customer1");

            when(customerService.getCustomer("1")).thenReturn(customer);

            mockMvc.perform(get("/bootcamp/customer/{id}", "1")
                           .accept("application/json"))
                   .andDo(print())
                   .andExpect(jsonPath("$").isNotEmpty());
    }

    @Test
    public void testGetCustomerEmpty() throws Exception {

        when(customerService.getCustomer(anyString())).thenReturn(null);

        mockMvc.perform(get("/bootcamp/Customers"))
                .andDo(print())
               .andExpect(result -> {
                   is(Optional.empty());
               });
    }

    @Test
    void testGetCustomers() throws Exception {

        List<Customer> Customers = new ArrayList<>();
        Customer Customer1 = new Customer();
        Customer Customer2 = new Customer();

        Customer1.setId("1");
        Customer1.setName("Customer1");
        Customer2.setId("2");
        Customer2.setName("Customer2");
        Customers.add(Customer1);
        Customers.add(Customer2);

        when(customerService.getCustomers()).thenReturn(Customers);

        mockMvc.perform(get("/bootcamp/customers")
                       .contentType("application/json"))
               .andDo(print())
               .andExpect(jsonPath("$[0]").isNotEmpty())
               .andExpect(jsonPath("$[0].id",Matchers.equalTo("1")))
               .andExpect(jsonPath("$[1].id", Matchers.equalTo("2")))
               .andExpect(jsonPath("$[1]").isNotEmpty());

    }

    @Test
    public void testGetCustomersEmpty() throws Exception {

        when(customerService.getCustomers()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/bootcamp/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andDo(print());

    }

    @Test
    void testSave() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId("1");
        customerDto.setName("customer1");

        String requestBody;
        requestBody = objectMapper.writeValueAsString(customerDto);

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());

        when(customerService.saveCustomer(customerDto)).thenReturn(customer);


            mockMvc.perform(post("/bootcamp/customer")
                                        .content(requestBody)
                                        .contentType("application/json"))
                   .andExpect(status().isCreated())
                   .andDo(print());

    }

    @Test
    void testSaveWithIdNull() throws Exception {

        CustomerDto customerDto = new CustomerDto();

        customerDto.setName("customer1");

        String requestBody = objectMapper.writeValueAsString(customerDto);

        when(customerService.saveCustomer(customerDto)).thenReturn(null);

        mockMvc.perform(post("/bootcamp/customer")
                                    .content(requestBody)
                                    .contentType("application/json"))
               .andExpect(status().isBadRequest())
               .andDo(print());

    }

    @Test
    void testPatch() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        Customer customer = new Customer();
        String requestBody;
        customerDto.setId("1");
        customerDto.setName("customer2");

        requestBody = objectMapper.writeValueAsString(customerDto);
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());

        when(customerService.updateCustomer(customerDto)).thenReturn(customer);

        mockMvc.perform(put("/bootcamp/customer")
                       .content(requestBody)
                       .contentType("application/json"))
               .andExpect(jsonPath("$.name",Matchers.equalTo("customer2")))
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    void testPut() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        Customer customer = new Customer();
        String requestBody;
        customerDto.setId("1");
        customerDto.setName("account2");

        requestBody = objectMapper.writeValueAsString(customerDto);
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());

        Mockito.when(customerService.updateCustomer(customerDto)).thenReturn(customer);

        mockMvc.perform(patch("/bootcamp/customer")
                       .content(requestBody)
                       .contentType("application/json"))
               .andExpect(jsonPath("$.name",Matchers.equalTo("account2")))
               .andExpect(status().isOk())
               .andDo(print());

    }

    @Test
    void testDelete() throws Exception {
        CustomerDto customerDto  = new CustomerDto();
        customerDto.setId("1");
        customerDto.setName("account1");
        when(customerService.deleteCustomer("1")).thenReturn(null);

        mockMvc.perform(delete("/bootcamp/customer/{id}"))
               .andExpect(status().isOk());

    }

}
