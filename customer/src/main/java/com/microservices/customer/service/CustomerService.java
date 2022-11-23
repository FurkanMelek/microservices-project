package com.microservices.customer.service;

import com.microservices.customer.dto.CustomerDto;
import com.microservices.customer.dto.converter.CustomerDtoConverter;
import com.microservices.customer.dto.request.CreateCustomerRequest;
import com.microservices.customer.model.Customer;
import com.microservices.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
//    private final RestTemplate restTemplate;

    public CustomerDto registerCustomer(CreateCustomerRequest createCustomerRequest) {
        //todo: check firstname, lastname, email are valid

        Customer customer = new Customer(createCustomerRequest.getName(), createCustomerRequest.getSurname());

        //todo: call fraud service with customer info
        /*
        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            log.info("Customer is fraudulent: {}", customer);
            throw new IllegalStateException("Customer is fraudulent");
        }
        */




        return customerDtoConverter.convertToCustomerDto(customerRepository.saveAndFlush(customer));
    }

    protected Customer findCustomerById(String customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("Customer not found"));
    }

    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerDtoConverter::convertToCustomerDto).collect(Collectors.toList());
    }

/*
    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer not found"));
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }
*/

    //TODO: @Transactional anotasyonu araştır

}
