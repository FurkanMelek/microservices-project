package com.microservices.customer.dto.converter;


import com.microservices.customer.dto.AccountDto;
import com.microservices.customer.dto.CustomerAccountDto;
import com.microservices.customer.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
                               TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convertToAccountDto(Account from) {
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertToAccountCustomerDto(Optional.ofNullable(from.getCustomer())),
                Objects.requireNonNull(from.getTransaction())
                        .stream()
                        .map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }

}
