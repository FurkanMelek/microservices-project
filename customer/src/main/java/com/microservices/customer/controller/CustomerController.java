package com.microservices.customer.controller;


import com.microservices.customer.entity.Customer;
import com.microservices.customer.request.CustomerRegistrationRequest;
import com.microservices.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("Registering customer: {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }

    @DeleteMapping("delete/{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") Integer customerId) {
        log.info("Deleting customer with id: {}", customerId);
        customerService.deleteCustomerById(customerId);
    }


    @GetMapping("get/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
        log.info("Getting customer with id: {}", customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        log.info("Getting all customers");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

}
