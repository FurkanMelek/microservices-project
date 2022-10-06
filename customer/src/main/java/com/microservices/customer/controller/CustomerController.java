package com.microservices.customer.controller;


import com.microservices.customer.dto.CustomerDto;
import com.microservices.customer.dto.request.CreateCustomerRequest;
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
    //response dönülecek hepsinde

    @PostMapping
    public ResponseEntity<CustomerDto> registerCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {

        log.info("Registering customer: {}", createCustomerRequest);
        return ResponseEntity.ok(customerService.registerCustomer(createCustomerRequest));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String customerId) {
        log.info("Getting customer by id: {}", customerId);
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        log.info("Getting all customers");
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
/*
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



    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) {
        log.info("Updating customer: {}", customer);
        customerService.updateCustomer(customer);
    }
*/
//    @PatchMapping("/{customerId}")
//    public void updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
//        log.info("Updating customer: {}", customer);
//        customerService.updateCustomer(customer);
//    }

}
