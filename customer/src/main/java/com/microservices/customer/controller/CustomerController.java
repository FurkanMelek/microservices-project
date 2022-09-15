package com.microservices.customer.controller;


import com.microservices.customer.request.CustomerRegistrationRequest;
import com.microservices.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public void deleteCustomerById(@PathVariable Integer customerId) {
        log.info("Deleting customer with id: {}", customerId);
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping("get/{customerId}")
    public void getCustomerById(@PathVariable Integer customerId) {
        log.info("Getting customer with id: {}", customerId);
        customerService.getCustomerById(customerId);
    }

    @GetMapping("all")
    public void getAllCustomers() {
        log.info("Getting all customers");
        customerService.getAllCustomers();
    }

}
