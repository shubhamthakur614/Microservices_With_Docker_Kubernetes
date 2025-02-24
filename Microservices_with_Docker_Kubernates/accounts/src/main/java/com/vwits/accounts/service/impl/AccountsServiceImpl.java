package com.vwits.accounts.service.impl;

import com.vwits.accounts.constants.AccountsConstants;
import com.vwits.accounts.dto.CustomerDto;
import com.vwits.accounts.entity.Accounts;
import com.vwits.accounts.entity.Customer;
import com.vwits.accounts.exceptions.CustomerAlreadyExistsException;
import com.vwits.accounts.mapper.CustomerMapper;
import com.vwits.accounts.repository.AccountsRepository;
import com.vwits.accounts.repository.CustomerRepository;
import com.vwits.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

   private AccountsRepository accountsRepository;
   private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
       if(optionalCustomer.isPresent()){
           throw new CustomerAlreadyExistsException("Customer already registered with given mobile number"+customerDto.getMobileNumber());
       }
       customer.setCreatedAt(LocalDateTime.now());
       customer.setCreatedBy("anonymous");
        Customer savedCustomer=customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomNumber = 10000000000L+new Random().nextInt();

        newAccount.setAccountNumber(randomNumber);
        newAccount.setAccount_type(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("anonymous");
        return newAccount;
    }
}
