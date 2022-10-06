package com.microservices.fraud.controller;

import com.microservices.fraud.response.FraudCheckResponse;
import com.microservices.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudulentCustomer(@PathVariable("customerId") Integer customerId) {
        FraudCheckResponse response = new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));
        return response;
    }

}
