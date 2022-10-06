package com.microservices.customer.service;

import com.microservices.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        restTemplate = Mockito.mock(RestTemplate.class);
//        customerService = new CustomerService(customerRepository, restTemplate);
    }

    @Test
    void registerCustomer() {
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void updateCustomer() {
    }
}