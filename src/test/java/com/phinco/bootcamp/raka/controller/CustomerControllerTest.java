//package com.phinco.bootcamp.raka.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.phinco.bootcamp.raka.model.Customer;
//import com.phinco.bootcamp.raka.model.CustomerDto;
//
//import com.phinco.bootcamp.raka.service.CustomerService;
//import org.hamcrest.Matchers;
//
//import org.junit.jupiter.api.Test;
//
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.util.*;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.hamcrest.CoreMatchers.is;
//
//@WebMvcTest(CustomerController.class)
//public class CustomerControllerTest {
//
//    @Autowired
//    ObjectMapper objectMapper;
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    static CustomerService customerService;
//
//    @Test
//    void testGetCustomer() throws Exception {
//        Customer customer = new Customer();
//        customer.setId("1");
//        customer.setName("account1");
//        customer.setBirthDate(LocalDate.of(2000, 6,27));
//        customer.setStatus(true);
//        customer.setCreatedDate(new Timestamp(Calendar.getInstance()
//                                                     .getTimeInMillis()));
//
//        Mockito.when(customerService.getCustomer("1"))
//               .thenReturn(customer);
//
//        mockMvc.perform(get("/bootcamp/customer/{id}", "1")
//                       .accept("application/json"))
//               .andDo(print())
//               .andExpect(jsonPath("$").isNotEmpty());
//    }
//
//    @Test
//    public void testGetCustomerWithIdNull() throws Exception {
//
//        Mockito.when(customerService.getCustomer(null)).thenReturn(null);
//
//        mockMvc.perform(get("/bootcamp/Customers"))
//               .andDo(print())
//               .andExpect(result ->  {
//                   is(Optional.empty());
//               });
//    }
//
//    @Test
//    public void testGetCustomerEmpty() throws Exception {
//
//        Mockito.when(customerService.getCustomer(anyString())).thenReturn(null);
//
//        mockMvc.perform(get("/bootcamp/Customers"))
//               .andDo(print())
//               .andExpect(result ->  {
//                   is(Optional.empty());
//               });
//    }
//
//    @Test
//    void testGetCustomers() throws Exception {
//        List<Customer> customers = new ArrayList<>();
//        Customer customer1 = new Customer();
//        Customer customer2 = new Customer();
//
//        customer1.setId("1");
//        customer1.setName("account1");
//        customer2.setId("2");
//        customer2.setName("account2");
//        customers.add(customer1);
//        customers.add(customer2);
//
//        Mockito.when(customerService.getCustomers()).thenReturn(customers);
//
//        mockMvc.perform(get("/bootcamp/customers")
//                       .contentType("application/json"))
//               .andDo(print())
//               .andExpect(jsonPath("$[0]").isNotEmpty())
//               .andExpect(jsonPath("$[0].id",Matchers.equalTo("1")))
//               .andExpect(jsonPath("$[1].id", Matchers.equalTo("2")))
//               .andExpect(jsonPath("$[1]").isNotEmpty());
//    }
//
//    @Test
//    public void testGetCustomersEmpty() throws Exception {
//
//        Mockito.when(customerService.getCustomers()).thenReturn(Collections.emptyList());
//
//        mockMvc.perform(get("/bootcamp/customers"))
//               .andExpect(status().isOk())
//               .andExpect(content().json("[]"))
//               .andDo(print());
//
//    }
//
//    @Test
//    void testSaveCustomer() throws Exception {
//
//        CustomerDto CustomerDto = new CustomerDto();
//        CustomerDto.setId("1");
//        CustomerDto.setName("Customer1");
//
//        String requestBody;
//        requestBody = objectMapper.writeValueAsString(CustomerDto);
//
//        Customer Customer = new Customer();
//        Customer.setId(CustomerDto.getId());
//        Customer.setName(CustomerDto.getName());
//
//        Mockito.when(customerService.saveCustomer(CustomerDto)).thenReturn(Customer);
//
//
//        mockMvc.perform(post("/bootcamp/Customer")
//                       .content(requestBody)
//                       .contentType("application/json"))
//               .andExpect(status().isCreated())
//               .andDo(print());
//
//    }
//
//    @Test
//    void testSaveCustomerWithIdNull() throws Exception {
//
//        CustomerDto CustomerDto = new CustomerDto();
//
//        CustomerDto.setName("Customer1");
//
//        String requestBody = objectMapper.writeValueAsString(CustomerDto);
//
//        Mockito.when(customerService.saveCustomer(CustomerDto)).thenReturn(null);
//
//        mockMvc.perform(post("/bootcamp/Customer")
//                       .content(requestBody)
//                       .contentType("application/json"))
//               .andExpect(status().isBadRequest())
//               .andDo(print());
//
//    }
//
//    @Test
//    void testPatchCustomer() throws Exception {
//
//        CustomerDto CustomerDto = new CustomerDto();
//        Customer Customer = new Customer();
//        String requestBody;
//        CustomerDto.setId("1");
//        CustomerDto.setName("Customer2");
//
//        requestBody = objectMapper.writeValueAsString(CustomerDto);
//        Customer.setId(CustomerDto.getId());
//        Customer.setName(CustomerDto.getName());
//
//        Mockito.when(customerService.updateCustomer(CustomerDto)).thenReturn(Customer);
//
//        mockMvc.perform(put("/bootcamp/Customer")
//                       .content(requestBody)
//                       .contentType("application/json"))
//               .andExpect(jsonPath("$.name",Matchers.equalTo("Customer2")))
//               .andExpect(status().isOk())
//               .andDo(print());
//
//    }
//
//    @Test
//    void testPutCustomer() throws Exception {
//
//        CustomerDto CustomerDto = new CustomerDto();
//        Customer Customer = new Customer();
//        String requestBody;
//        CustomerDto.setId("1");
//        CustomerDto.setName("Customer2");
//
//        requestBody = objectMapper.writeValueAsString(CustomerDto);
//        Customer.setId(CustomerDto.getId());
//        Customer.setName(CustomerDto.getName());
//
//        Mockito.when(customerService.patchCustomer(CustomerDto)).thenReturn(Customer);
//
//        mockMvc.perform(patch("/bootcamp/Customer")
//                       .content(requestBody)
//                       .contentType("application/json"))
//               .andExpect(jsonPath("$.name",Matchers.equalTo("Customer2")))
//               .andExpect(status().isOk())
//               .andDo(print());
//
//    }
//
//    @Test
//    void testDeleteCustomer() throws Exception {
//        Mockito.when(customerService.deleteCustomer("1")).thenReturn(null);
//
//        mockMvc.perform(delete("/bootcamp/Customer/1"))
//               .andExpect(status().isOk());
//
//    }
//
//}
