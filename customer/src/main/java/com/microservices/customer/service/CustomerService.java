package com.microservices.customer.service;

import com.microservices.customer.request.CustomerRegistrationRequest;
import com.microservices.customer.entity.Customer;
import com.microservices.customer.repository.CustomerRepository;
import com.microservices.fraud.response.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check firstname, lastname, email are valid

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse =
                restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            log.info("Customer is fraudulent: {}", customer);
            throw new IllegalStateException("Customer is fraudulent");
        }
    }

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer not found"));
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

}
