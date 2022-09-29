package com.microservices.customer.controller;


import com.microservices.customer.dto.CustomerDto;
import com.microservices.customer.model.Customer;
import com.microservices.customer.request.CustomerDeleteRequest;
import com.microservices.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    //response dönülecek hepsinde

    @PostMapping
    public CustomerDto registerCustomer(@RequestBody CustomerDto customerRegistrationRequest) {

        Customer customer = modelMapper.map(customerRegistrationRequest, Customer.class);

        log.info("Registering customer: {}", customerRegistrationRequest);
        customerService.registerCustomer(customer);

        return modelMapper.map(customer, CustomerDto.class);
    }

    @DeleteMapping()
    public CustomerDto deleteCustomerById(@RequestBody CustomerDeleteRequest customerDeleteRequest) {
        log.info("Deleting customer: {}", customerDeleteRequest);
        customerService.deleteCustomerById(customerDeleteRequest.customerId());
    }

    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
        log.info("Getting customer with id: {}", customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        log.info("Getting all customers");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        log.info("Updating customer: {}", customer);
        customerService.updateCustomer(customer);
    }

//    @PatchMapping("/{customerId}")
//    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
//        log.info("Updating customer: {}", customer);
//        customerService.updateCustomer(customer);
//    }

}
