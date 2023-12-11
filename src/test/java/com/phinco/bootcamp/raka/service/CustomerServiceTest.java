package com.phinco.bootcamp.raka.service;



import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;
import com.phinco.bootcamp.raka.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;
    private Customer customer;
    private CustomerDto customerDto = new CustomerDto();

    @BeforeEach
    public void setup() {
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);

        customer = Customer.builder()
                           .id("1")
                           .name("customer1")
                           .birthDate(LocalDate.now())
                           .status(true)
                           .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                           .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                           .build();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
    }

    @Test
    public void testSaveService() throws Exception {



    }

    @Test
    public void testGetCustomers() {

        Customer customer1;
        customer1 = Customer.builder()
                          .id("2")
                          .name("customer2")
                          .status(true)
                          .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .build();

        CustomerDto  customerDto1 = new CustomerDto();
        customerDto1.setId(customer1.getId());
        customerDto1.setName(customer1.getName());

        given(customerRepository.findByStatus(any())).willReturn((List.<Customer>of(customer, customer1)));

        List<Customer> customerList;
        customerList = customerService.getCustomers();

        assertThat(customerList).isNotNull();
        assertThat(customerList.size()).isEqualTo(2);
        assertThat(customerList.indexOf(0)).isNotNull();
        assertThat(customerList.indexOf(1)).isNotNull();
        assertThat(customerList.contains(true));

    }

    @Test
    public void testGetCustomer(){

        given(customerRepository.findByIdAndStatus("1", true)).willReturn(Optional.of(customer));

        Customer savedCustomer = customerService.getCustomer("1");

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isEqualTo("1");

    }

    @Test
    public void testUpdate() {
        when(customerRepository.findByIdAndStatus("1", true))
                .thenReturn(Optional.ofNullable(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.updateCustomer(customerDto);

        assertThat(savedCustomer).isNotNull();
    }

    @Test
    public void testDelete() {
//        when(customerRepository.)
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.deleteCustomer("1");

        assertThat(savedCustomer).isNotNull();
    }




}

