package com.phinco.bootcamp.raka.service;



import com.phinco.bootcamp.raka.model.Customer;
import com.phinco.bootcamp.raka.model.CustomerDto;
import com.phinco.bootcamp.raka.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    private CustomerDto customerDto;

    @BeforeEach
    public void setup() {
        customer = Customer.builder()
                         .id("1")
                         .name("Customer1")
                         .birthDate(LocalDate.of(2000, 6, 27))
                         .status(true)
                         .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                         .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                         .build();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        //belom selesai dari sini kebawah
    }

    @Test
    public void testSaveCustomer() throws Exception {

        given(this.customerRepository.save(any())).willReturn(customer);
        Customer savedCustomer = customerService.saveCustomer(customerDto);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isEqualTo("1");
        assertThat(savedCustomer.getName()).isEqualTo("Customer1");
        assertThat(savedCustomer.isStatus()).isEqualTo(true);

    }

    @Test
    public void testGetCustomers() {

        Customer customer1;
        customer1 = Customer.builder()
                          .id("2")
                          .name("Customer2")
                          .status(true)
                          .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .build();

        CustomerDto  customerDto1 = new CustomerDto();
        customerDto1.setId(customer1.getId());
        customerDto1.setName(customer1.getName());

        given(customerRepository.findByStatus(any())).willReturn(List.of(customer,customer1));

        List<Customer> customerList = customerService.getCustomers();

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
    public void testUpdateCustomer() {
        when(customerRepository.findByIdAndStatus("1", true))
                .thenReturn(Optional.ofNullable(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer savedCustomer = customerService.updateCustomer(customerDto);

        assertThat(savedCustomer).isNotNull();
    }

    @Test
    public void testPatchCustomer() {
        customer.setName("updatedName");
        customerDto.setName(customer.getName());
        when(customerRepository.findByIdAndStatus("1", true)).thenReturn(Optional.ofNullable(customer));
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer updatedCustomer = customerService.patchCustomer(customerDto);
        //belum dari sini kebawah
    }

    @Test
    public void testDeleteCustomer() {
        customer.setStatus(false);
//        when(acc)
        Mockito.when(customerRepository.findById("1")).thenReturn(Optional.ofNullable(customer));
        Mockito.when(customerRepository.save(any())).thenReturn(customer);

        Customer savedCustomer = customerService.deleteCustomer("1");
        assertThat(savedCustomer).isNotNull();
    }
}

