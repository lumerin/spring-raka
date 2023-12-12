//package com.phinco.bootcamp.raka.service;
//
//import com.phinco.bootcamp.raka.model.Account;
//import com.phinco.bootcamp.raka.model.AccountDto;
//import com.phinco.bootcamp.raka.repository.AccountRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.Timestamp;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//
//    @Autowired
//    AccountRepository repository;
//
//    @Override
//    public Account getAccount(String id) {
//        Optional<Account> acc = repository.findByIdAndStatus(id, true);
//        if(acc.isPresent()){
//            return acc.get();
//        }
//        return new Account();
//    }
//
//    @Override
//    public List<Account> getAccounts() {
//        return (List<Account>) repository.findByStatus(true);
//    }
//
//    @Override
//    public Account saveAccount(AccountDto accountDto) {
//        Account account = new Account();
//        account.setId(accountDto.getId());
//        account.setName(accountDto.getName());
//        account.setType(accountDto.getType());
//        account.setCustomerId(accountDto.getCustomerId());
//        account.setAmount(accountDto.getAmount());
//        account.setStatus(true);
//        account.setCreatedDate((new Timestamp(Calendar.getInstance().getTimeInMillis())));
//        return repository.save(account);
//    }
//
//    @Override
//    public Account updateAccount(AccountDto accountDto) {
//        Optional<Account>  acc = repository.findByIdAndStatus(accountDto.getId(), true);
//        if(acc.isPresent()) {
//            Account account = acc.get();
//            account.setId(acc.get().getId());
//            account.setName(accountDto.getName());
//            account.setType(accountDto.getType());
//            account.setCustomerId(accountDto.getCustomerId());
//            account.setAmount(accountDto.getAmount());
//            account.setStatus(acc.get().isStatus());
//            account.setCreatedDate(acc.get().getCreatedDate());
//            account.setUpdatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//            return repository.save(account);
//        }
//        return new Account();
//    }
//
//    @Override
//    public Account patchAccount(AccountDto accountDto) {
//        Optional<Account> acc = repository.findByIdAndStatus(accountDto.getId(), true);
//        if (acc.isPresent()) {
//            Account account = acc.get();
//            if (accountDto.getAmount() != null) {
//                account.setAmount(accountDto.getAmount());
//            }
//            if (accountDto.getName() != null) {
//                account.setName(accountDto.getName());
//            }
//            if (accountDto.getCustomerId() != null) {
//                account.setCustomerId(accountDto.getCustomerId());
//            }
//            if (accountDto.getType() != null) {
//                account.setType(accountDto.getType());
//            }
//            account.setUpdatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//            return repository.save(account);
//        }
//        return new Account();
//    }
//
//    @Override
//    public Account deleteAccount(String id) {
//        Optional<Account> acc = repository.findById(id);
//
//        if (acc.isPresent()) {
//            Account account = new Account();
//            account.setStatus(false);
//            account.setUpdatedDate(new Timestamp(Calendar.getInstance()
//                                                         .getTimeInMillis()));
//            return repository.save(account);
//        }
//        return new Account();
//    }
//
//}
