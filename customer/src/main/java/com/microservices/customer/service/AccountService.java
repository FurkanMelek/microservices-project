package com.microservices.customer.service;

import com.microservices.customer.dto.AccountDto;
import com.microservices.customer.dto.converter.AccountDtoConverter;
import com.microservices.customer.dto.request.CreateAccountRequest;
import com.microservices.customer.model.Account;
import com.microservices.customer.model.Customer;
import com.microservices.customer.model.Transaction;
import com.microservices.customer.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), LocalDateTime.now(), account);
            account.getTransaction().add(transaction);
        }

        return accountDtoConverter.convertToAccountDto(accountRepository.save(account));

    }

}
