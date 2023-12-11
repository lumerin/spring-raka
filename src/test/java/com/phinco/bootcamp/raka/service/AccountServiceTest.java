package com.phinco.bootcamp.raka.service;

import com.phinco.bootcamp.raka.model.Account;
import com.phinco.bootcamp.raka.model.AccountDto;

import com.phinco.bootcamp.raka.repository.AccountRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.sql.Timestamp;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;
    private Account account;
    private AccountDto accountDto = new AccountDto();

    @BeforeEach
    public void setup() {
        //employeeRepository = Mockito.mock(EmployeeRepository.class);
        //employeeService = new EmployeeServiceImpl(employeeRepository);
        account = Account.builder()
                           .id("1")
                           .name("account1")
                           .type("penjual")
                           .customerId("1")
                           .amount(45L)
                           .status(true)
                           .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                           .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                           .build();

        accountDto.setId(account.getId());
        accountDto.setName(account.getName());
        accountDto.setType(account.getType());
        accountDto.setCustomerId(account.getCustomerId());
        accountDto.setAmount(account.getAmount());
    }

    @Test
    public void testSaveService() throws Exception {

        given(this.accountRepository.save(any())).willReturn(account);
        Account savedAccount = accountService.saveAccount(accountDto);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isEqualTo("1");
        assertThat(savedAccount.getName()).isEqualTo("account1");
        assertThat(savedAccount.getType()).isEqualTo("penjual");
        assertThat(savedAccount.isStatus()).isEqualTo(true);

    }

    @Test
    public void testGetAccounts() {

        Account account1;
        account1 = Account.builder()
                          .id("2")
                          .name("account2")
                          .type("pembeli")
                          .customerId("1")
                          .amount(15L)
                          .status(true)
                          .createdDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .updatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()))
                          .build();

        AccountDto  accountDto1 = new AccountDto();
        accountDto1.setId(account1.getId());
        accountDto1.setName(account1.getName());
        accountDto1.setType(account1.getType());
        accountDto1.setCustomerId(account1.getCustomerId());
        accountDto1.setAmount(account1.getAmount());

        given(accountRepository.findByStatus(any())).willReturn(List.of(account,account1));

        List<Account> accountList = accountService.getAccounts();

        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(2);
        assertThat(accountList.indexOf(0)).isNotNull();
        assertThat(accountList.indexOf(1)).isNotNull();
        assertThat(accountList.contains(true));

    }

    @Test
    public void testGetAccount(){

        given(accountRepository.findByIdAndStatus("1", true)).willReturn(Optional.of(account));

        Account savedAccount = accountService.getAccount("1");

        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isEqualTo("1");

    }

    @Test
    public void testUpdate() {
        when(accountRepository.findByIdAndStatus("1", true))
                .thenReturn(Optional.ofNullable(account));
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account savedAccount = accountService.updateAccount(accountDto);

        assertThat(savedAccount).isNotNull();
    }

    @Test
    public void testDelete() {
//        when(acc)
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account savedAccount = accountService.deleteAccount("1");

        assertThat(savedAccount).isNotNull();
    }
}

